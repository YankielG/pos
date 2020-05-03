package pl.edu.wszib.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.wszib.pos.model.Zgloszenie;
import pl.edu.wszib.pos.repository.ZgloszenieRepository;
import pl.edu.wszib.pos.service.impl.ZgloszenieServiceImpl;
import pl.edu.wszib.pos.utils.Pager;

import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping("/")
public class AppController {
//    private static final int BUTTONS_TO_SHOW = 5;
//    private static final int INITIAL_PAGE = 0;
//    private static final int INITIAL_PAGE_SIZE = 5;
//    private static final int[] PAGE_SIZES = {5};
//    private final ZgloszenieServiceImpl zgloszenieService;
//    public AppController(ZgloszenieServiceImpl zgloszenieService) {
//        this.zgloszenieService = zgloszenieService;
//    }

    @Autowired
    private ZgloszenieRepository repo;

    @GetMapping("/zgloszenia/lista")
    public ModelMap listaZgloszen(@PageableDefault(size = 5)Pageable pageable, @RequestParam(name = "id", required = false) Long id, Model model){
        if (id != null){
            model.addAttribute("id", id);
            return new ModelMap().addAttribute("listaZgloszen", repo.findAllByIdAndDelIsFalse(id, pageable));
        }else {
            return new ModelMap().addAttribute("listaZgloszen", repo.findAll(pageable));
        }
    }
//    @GetMapping("/zgloszenia/lista")
//    public ModelAndView showPersonsPage(@RequestParam("pageSize") Optional<Integer> pageSize,
//                                        @RequestParam("page") Optional<Integer> page) {
//        ModelAndView modelAndView = new ModelAndView("zgloszenia/lista");
//        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
//        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
//        Page<Zgloszenie> zgloszenia = zgloszenieService.findAllPageable(PageRequest.of(evalPage, evalPageSize));
//        Pager pager = new Pager(zgloszenia.getTotalPages(), zgloszenia.getNumber(), BUTTONS_TO_SHOW);
//        modelAndView.addObject("zgloszenia", zgloszenia);
//        modelAndView.addObject("selectedPageSize", evalPageSize);
//        modelAndView.addObject("pageSizes", PAGE_SIZES);
//        modelAndView.addObject("pager", pager);
//        return modelAndView;
//    }
//    @Autowired
//    private RoleService roleService;
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private HistoryService historyService;
//    @Autowired
//    private ZgloszenieServiceImpl zgloszenieService;
//    private Long zgloszenieId;
//    private Zgloszenie zgloszenie;
    @RequestMapping("/glowna")
    public String viewHomePage(Model model) {
        return "glowna";
    }
//

    @GetMapping("/zgloszenia/form")
    public ModelMap edycjaZgloszenia(@RequestParam(value = "id",required = false)Zgloszenie zgloszenie){
        if(zgloszenie == null){
            zgloszenie = new Zgloszenie();
        }
        return new ModelMap("zgloszenie", zgloszenie);
    }

    @PostMapping("/zgloszenia/form")
    public String save(@ModelAttribute @Valid Zgloszenie zgloszenie, BindingResult errors, SessionStatus status){
        if (errors.hasErrors()){
            return "zgloszenia/form";
        }
        repo.save(zgloszenie);
        return "redirect:lista";
    }
//
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public String saveZgloszenie(@ModelAttribute("zgloszenie") Zgloszenie zgloszenie, @ModelAttribute("history") History history) {
//        zgloszenie.setcData(new Date());
//        //zgloszenie.setStatus("1");
//        zgloszenie.setDel(true);
//        zgloszenieRepository.save(zgloszenie);
//        history.setzId(zgloszenie.getId());
//        history.sethData(new Date());
//        history.sethDescription("Test");
//        history.sethUser("test");
//        historyService.save(history);
//        return "podsumowanie";
//    }

//    @RequestMapping("/edycja{id}")
//    public ModelAndView showEditZgloszeniePage(@PathVariable Long id) {
//        ModelAndView modelAndView = new ModelAndView("edycja-zgloszenia");
//        Zgloszenie zgloszenie = zgloszenieService.get(id);
//        modelAndView.addObject("zgloszenie", zgloszenie);
//        return modelAndView;
//    }
//    @GetMapping("/edycja/{id}")
//    public String edycjaZgloszenia(@PathVariable Long id, Model model) {
//        Zgloszenie zgloszenie = zgloszenieService.get(id);
//        model.addAttribute("zgloszenie", zgloszenie);
//        return "edycja-zgloszenia";
//    }

//    @RequestMapping("/del/{id}")
//    public String deleteZgloszenie(@PathVariable Long id, Model model) {
//        Zgloszenie zgloszenie = zgloszenieService.get(id);
//        model.addAttribute("zgloszenie", zgloszenie);
//        return "usun";
//    }
//
//    @RequestMapping(value = "/delete", method = RequestMethod.POST)
//    public String delZgloszenie(@ModelAttribute("zgloszenie") Zgloszenie zgloszenie, @ModelAttribute("historia") History history) {
//        zgloszenie.setDel(false);
//        zgloszenieRepository.save(zgloszenie);
////        History history = new History(zgloszenie.getId(), new Date(), "Usunięto z bazy", "test");
////        historyService.save(history);
//        return "redirect:/";
//    }
//
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


//@GetMapping("/details/{id}")
//public String detailsZgloszenia(@PathVariable Long id, Model model) {
//    Zgloszenie zgloszenie = zgloszenieService.get(id);
//    model.addAttribute("zgloszenie", zgloszenie);
//    return "szczegoly";
//}
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



}


