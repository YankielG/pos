package pl.edu.wszib.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.wszib.pos.model.*;
import pl.edu.wszib.pos.repository.*;
import pl.edu.wszib.pos.service.HistoryService;
import pl.edu.wszib.pos.service.MailService;
import pl.edu.wszib.pos.service.RoleService;
import pl.edu.wszib.pos.service.UserService;
import pl.edu.wszib.pos.service.impl.CategoryServiceImpl;
import pl.edu.wszib.pos.service.impl.EmployeeServiceImpl;
import pl.edu.wszib.pos.service.impl.ZgloszenieServiceImpl;


import javax.validation.Valid;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    private ZgloszenieRepository repo;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @Autowired
    private ZgloszenieServiceImpl zgloszenieService;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private HistoryRepository historyRepository;
    @Autowired
    private CategoryServiceImpl category;
    @Autowired
    private EmployeeServiceImpl employeeService;
        @Autowired
    private HistoryService historyService;
        @Autowired
        private EmployeeRepository employeeRepository;


//    private Long zgloszenieId;
//    private Zgloszenie zgloszenie;
    @Autowired
    private MailService mailService;

    @GetMapping("/zgloszenia/lista")
    public ModelMap listaZgloszen(@PageableDefault(size = 5)Pageable pageable, @RequestParam(name = "id", required = false) Long id, Model model){

            return new ModelMap().addAttribute("listaZgloszen", repo.findAllByIdAndDelIsFalse(id, pageable));

    }

    @RequestMapping("/glowna")
    public String viewHomePage(Model model) {
        return "glowna";
    }

    @GetMapping("/zgloszenia/form")
    public ModelMap edycjaZgloszenia(@RequestParam(value = "id",required = false)Zgloszenie zgloszenie){
        return new ModelMap("zgloszenie", zgloszenie);
    }

    @GetMapping("zgloszenia/add")
    public String addZgloszenie(Zgloszenie zgloszenie, Model model) {
        List<Category> categories = category.getAllCategories();
        model.addAttribute("zgloszenie", zgloszenie);
        model.addAttribute("categories", categories);
        return "zgloszenia/add";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute("zgloszenie") Zgloszenie zgloszenie, @ModelAttribute("history") History history) {
        //zgloszenie.setcData(zgloszenie.getcData());
        //zgloszenie.setStatus("1");
        //zgloszenie.setDel(true);
        repo.save(zgloszenie);
        history = new History();
        history.setzId(zgloszenie.getId());
        history.sethData(new Date());
        history.sethDescription("Edit");
       history.sethUser("edit");
        historyRepository.save(history);
        return "redirect:zgloszenia/lista";
    }

    @RequestMapping(value = "/saveAdd", method = RequestMethod.POST)
    public String saveAdd(@ModelAttribute("zgloszenie") Zgloszenie zgloszenie, @ModelAttribute("history") History history) {
        zgloszenie.setcData(new Date());
        //zgloszenie.setStatus("1");
        zgloszenie.setDel(false);
        repo.save(zgloszenie);
        history.setzId(zgloszenie.getId());
        history.sethData(new Date());
        history.sethDescription("Test");
        history.sethUser("test");
        historyRepository.save(history);
        return "redirect:zgloszenia/lista";
    }

    @RequestMapping(value = "/sendemail", method = RequestMethod.GET)
    public String sendEmail() {
                    mailService.sendSimpleEmail("Odbiorca <skazada@poczta.fm>", "Test e-mail", "Testing");
        return "redirect:zgloszenia/lista";
    }

    @GetMapping("/zgloszenia/details")
    public ModelMap details(@RequestParam(value = "id",required = false)Zgloszenie zgloszenie){
        return new ModelMap("zgloszenie", zgloszenie);
    }

    @GetMapping("/zgloszenia/history")
    public String history(@RequestParam(value = "id",required = false)Long id, Zgloszenie zgloszenie, History history, Model model) {
        id = zgloszenie.getId();
        List<History> histories = historyRepository.findByzId(id);
        model.addAttribute("histories", histories);
        return "zgloszenia/history";
    }

    @GetMapping("/manager/przydziel")
    public String przydziel(@RequestParam(value = "id", required = true)Long id, Zgloszenie zgloszenie, Model model) {
        id=zgloszenie.getId();
        Zgloszenie zgloszenie1 = zgloszenieService.get(id);
      model.addAttribute("zgloszenie1", zgloszenie1);
      List<Employee> employees = employeeService.getAllEmployee();
      model.addAttribute("employees", employees);
        return "manager/przydziel";
    }

    @GetMapping("/zgloszenia/zamknij")
    public ModelMap zamkniecie(@RequestParam(value = "id",required = false)Zgloszenie zgloszenie){
        return new ModelMap("zgloszenie", zgloszenie);
    }

    @RequestMapping(value = "/saveEnd", method = RequestMethod.POST)
    public String saveEnd(@ModelAttribute("zgloszenie") Zgloszenie zgloszenie, @ModelAttribute("history") History history) {
        //zgloszenie.setDel(zgloszenie.getDel);
        //zgloszenie
        //zgloszenie.setDel(true);
        zgloszenie.setArchive(true);
        zgloszenie.setIs_end(true);
        repo.save(zgloszenie);
        history = new History();
        history.setzId(zgloszenie.getId());
        history.sethData(new Date());
        history.sethDescription("zakończenie");
        history.sethUser("zakończenie");
        historyRepository.save(history);
        String tresc = "Serwis komputerowy uprzejmie informuje o zamknięciu zgłoszenia nr : " + zgloszenie.getId() + "dotyczącego : " +zgloszenie.getDescription() + "."+
                "Naprawa obejmowała : " + zgloszenie.getEndDescription()+"." +
                "Po sprzęt można się zgłosić w dni robocze w godz: 7:30 - 15:30.";
        mailService.sendSimpleEmail("Odbiorca <skazada@poczta.fm>", "Zamknięcie zgłoszenia", tresc);
        return "redirect:zgloszenia/lista";
    }

    @GetMapping("/zgloszenia/archiwe")
    public ModelMap listaZgloszenArchiwalnych(@PageableDefault(size = 5)Pageable pageable, @RequestParam(name = "id", required = false) Long id, Model model){
          return new ModelMap().addAttribute("listaZgloszen", repo.findAll(pageable));
        }

    @GetMapping("admin/categories")
    public String viewsCategories(Category category, Model model) {
        List<Category> categories = (List<Category>) categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "admin/categories";
    }

    @GetMapping("/admin/add_category")
    public ModelMap addCategory(Category category)
    {
        return new ModelMap("category", category);
    }

    @RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
    public String saveCategory(@ModelAttribute("category")Category category) {
        categoryRepository.save(category);
        return "redirect:admin/categories";
    }


    @GetMapping("admin/usun")
    public ModelMap usunZgłoszenie(@RequestParam(value = "id")Zgloszenie zgloszenie) {
        return new ModelMap("zgloszenie", zgloszenie);
    }
    @GetMapping("/manager/employees")
    public ModelMap listaPracowników(@PageableDefault(size = 5)Pageable pageable, @RequestParam(name = "id", required = false) Long id, Model model){

        return new ModelMap().addAttribute("employees", employeeRepository.findAllById(id, pageable));

    }

    @GetMapping("/manager/add_employee")
    public String addEmployee(Employee employee, Model model) {
        model.addAttribute("employee", employee);
        return "manager/add_employee";
    }

    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employee.setIs_active(true);
        employeeRepository.save(employee);
        return "redirect:manager/employee";
    }
//
//@RequestMapping(value = "del", method = RequestMethod.POST)
//public String delete(@RequestParam(value = "id") Zgloszenie zgloszenie, History history, Model model) {
//        zgloszenie.setDel(true);
//        repo.save(zgloszenie);
//        history.setzId(zgloszenie.getId());
//        history.sethData(new Date());
//        historyRepository.save(history);
//        return "redirect: zgloszenia/lista";
//}

//    @RequestMapping(value = "/del", method = RequestMethod.POST)
//    public String delZgloszenie(@ModelAttribute("zgloszenie") Zgloszenie zgloszenie, @ModelAttribute("history") History history) {
//        //zgloszenie.setStatus("1");
//        zgloszenie.setDel(true);
//        repo.save(zgloszenie);
//        history.setzId(zgloszenie.getId());
//        history.sethData(new Date());
//        history.sethDescription("usunięto");
//        history.sethUser("test");
//        historyRepository.save(history);
//        return "redirect:zgloszenia/lista";
//    }
//
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delZgloszenie(@ModelAttribute("zgloszenie") Zgloszenie zgloszenie, @ModelAttribute("history") History history) {
        zgloszenie.setDel(true);
        repo.save(zgloszenie);
        history = new History();
        history.setzId(zgloszenie.getId());
        history.sethData(new Date());
        history.sethDescription("Usunięto z bazy");
        history.sethUser("usuwanie");
        historyRepository.save(history);
        return "redirect:zgloszenia/lista";
    }

    @GetMapping(value={"/", "/login"})
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
//
//    @GetMapping(value="/admin/add_user")
//    public ModelAndView registration(){
//        ModelAndView modelAndView = new ModelAndView();
//        User user = new User();
//        modelAndView.addObject("user", user);
//        modelAndView.setViewName("add_user");
//        return modelAndView;
//    }
//
//    @PostMapping(value = "/admin/add_user")
//    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
//        ModelAndView modelAndView = new ModelAndView();
//        User userExists = userService.findUserByUserName(user.getUserName());
//        if (userExists != null) {
//            bindingResult
//                    .rejectValue("userName", "error.user",
//                            "Użytkownik o takiej nazwie istnieje już w systemie");
//        }
//        if (bindingResult.hasErrors()) {
//            modelAndView.setViewName("add_user");
//        } else {
//            userService.saveUser(user);
//            modelAndView.addObject("successMessage", "Poprawnie dodano użytkownika");
//            modelAndView.addObject("user", new User());
//            modelAndView.setViewName("add_user");
//
//        }
//        return modelAndView;
//    }
//
//    @GetMapping(value="/admin/home")
//    public ModelAndView home(){
//        ModelAndView modelAndView = new ModelAndView();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = userService.findUserByUserName(auth.getName());
//        modelAndView.addObject("userName", "Welcome " + user.getUserName() + "/" + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
//        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
//        modelAndView.setViewName("admin/home");
//        return modelAndView;
//    }
//



//    @RequestMapping(value = "/manager/przydziel/{id}")
//    public String przydzielZgloszenie(@PathVariable Long id, Model model) {
//        Zgloszenie zgloszenie = zgloszenieService.get(id);
//        model.addAttribute("zgloszenie", zgloszenie);
//        return "manager/przydziel";
//    }


//
//    @RequestMapping("/zakoncz/{id}")
//    public String zakonczZgloszenie(@PathVariable Long id, Model model) {
//        Zgloszenie zgloszenie = zgloszenieService.get(id);
//        model.addAttribute("zgloszenie", zgloszenie);
//        return "zakoncz";
//    }

//    @RequestMapping(value = "/end", method = RequestMethod.POST)
//    public String endZgloszenie(@ModelAttribute("zgloszenie") Zgloszenie zgloszenie) {
//        zgloszenie.setStatus("3");
//        zgloszenieService.save(zgloszenie);
//        //History history = new History(zgloszenie.getId(), new Date(), "Zamknięto zgłoszenie", "test");
//       // historyService.save(history);
//        return "redirect:/";
//    }
//    @GetMapping("/zgloszenia")
//    public String Zgloszenia(Zgloszenie zgloszenie, Model model) {
//        zgloszenieService.get()
//    }


    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByUserName(user.getUserName());
        if (userExists != null) {
            bindingResult
                    .rejectValue("userName", "error.user",
                            "There is already a user registered with the user name provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }

    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getUserName() + "/" + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }





}


