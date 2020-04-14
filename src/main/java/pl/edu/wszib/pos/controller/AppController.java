package pl.edu.wszib.pos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.wszib.pos.helper.PageModel;
import pl.edu.wszib.pos.model.History;
import pl.edu.wszib.pos.model.User;
import pl.edu.wszib.pos.model.Zgloszenie;
import pl.edu.wszib.pos.service.HistoryService;
import pl.edu.wszib.pos.service.RoleService;
import pl.edu.wszib.pos.service.UserService;
import pl.edu.wszib.pos.service.ZgloszenieService;

import javax.validation.Valid;
import java.util.*;


@Controller
public class AppController {
    @Autowired
    private ZgloszenieService zgloszenieService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private PageModel pageModel;


    private Long zgloszenieId;
    private Zgloszenie zgloszenie;


//    @GetMapping("/zgloszenie")
//    public String getAllZgloszenia(Model model) {
//        pageModel.setSIZE(8);
//        pageModel.initPageAndSize();
//        model.addAttribute("zgloszenielist", zgloszenieService.findAll(PageRequest.of(pageModel.getPAGE(), pageModel.getSIZE())));
//        return "index";
//    }


    @RequestMapping("/user/")
    public String viewHomePage(Model model) {
        Iterable<Zgloszenie> zgloszenieList = zgloszenieService.findAll();
         model.addAttribute("zgloszenielist", zgloszenieList);
        return "user/index";
    }

//    @RequestMapping("/index/page/{page}")
//    public ModelAndView listaZgloszen(@PathVariable("page") int page ) {
//        ModelAndView modelAndView = new ModelAndView("zgloszenia-paginacja");
//        Pageable pageable = PageRequest.of(page - 1, 10);
//        Page<Zgloszenie> zgloszeniePage = zgloszenieService.getPaginated(pageable);
//        int totalPages = zgloszeniePage.getTotalPages();
//        if(totalPages > 0) {
//            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
//            modelAndView.addObject("pageNumbers", pageNumbers);
//        }
//        modelAndView.addObject("activeZgloszenieList", true);
//        modelAndView.addObject("zgloszenieList", zgloszeniePage.getContent());
//        Iterable<Zgloszenie> zgloszenieList = zgloszenieService.findAll();
//        modelAndView.addObject("zgloszenielist", zgloszenieList);
//        return modelAndView;
//    }

    @RequestMapping("/user/nowe")
    public String showNoweZgloszenie(Model model) {
        Zgloszenie zgloszenie = new Zgloszenie();
        model.addAttribute("zgloszenie", zgloszenie);
        return "user/nowe_zgloszenie";
    }

    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public String saveZgloszenie(@ModelAttribute("zgloszenie") Zgloszenie zgloszenie, @ModelAttribute("history") History history) {
        zgloszenie.setcData(new Date());
        zgloszenie.setStatus("1");
        zgloszenie.setDel(true);
        zgloszenie.setuId(1L);
        zgloszenieService.save(zgloszenie);
        history.setzId(zgloszenie.getId());
        history.sethData(new Date());
        history.sethDescription("Test");
        history.sethUser("test");
        historyService.save(history);
        return "user/podsumowanie";
    }


    @GetMapping("/user/edycja/{id}")
    public String edycjaZgloszenia(@PathVariable Long id, Model model) {
        Zgloszenie zgloszenie = zgloszenieService.get(id);
        model.addAttribute("zgloszenie", zgloszenie);
        return "user/edycja-zgloszenia";
    }

    @RequestMapping("/user/del/{id}")
    public String deleteZgloszenie(@PathVariable Long id, Model model) {
        Zgloszenie zgloszenie = zgloszenieService.get(id);
        model.addAttribute("zgloszenie", zgloszenie);
        return "user/usun";
    }

    @RequestMapping(value = "/user/delete", method = RequestMethod.POST)
    public String delZgloszenie(@ModelAttribute("zgloszenie") Zgloszenie zgloszenie) {
        zgloszenie.setDel(false);
        zgloszenieService.save(zgloszenie);
        History history = new History(zgloszenie.getId(), new Date(), "Usunięto z bazy", "test");
        historyService.save(history);
        return "user/redirect:/";
    }

    @RequestMapping(value = "/manager/przydziel/{id}")
    public String przydzielZgloszenie(@PathVariable Long id, Model model) {
        Zgloszenie zgloszenie = zgloszenieService.get(id);
        model.addAttribute("zgloszenie", zgloszenie);
//        List<User> users = userService.findById();
//        model.addAttribute("users", users);
//       List<User> userList = UserDAO.getUSERS();
//       model.addAttribute("users", userList);
//       List<User> users = (List<User>) userService.listAll();
//       model.addAttribute("users", users);
//       Iterable<User> users = userService.listAll();
//       model.addAttribute(users);

        return "manager/przydziel";
    }

//    @RequestMapping(value = "/historia/{id}")
//    public String historiaZgloszenia(@PathVariable Long id, Model model) {
//        Zgloszenie zgloszenie = zgloszenieService.get(id);
//        model.addAttribute("zgloszenie", zgloszenie);
//        Iterable<History> histories = hi
//    }
@GetMapping("/user/details/{id}")
public String detailsZgloszenia(@PathVariable Long id, Model model) {
    Zgloszenie zgloszenie = zgloszenieService.get(id);
    model.addAttribute("zgloszenie", zgloszenie);
    return "user/szczegoly";
}

    @RequestMapping("/user/zakoncz/{id}")
    public String zakonczZgloszenie(@PathVariable Long id, Model model) {
        Zgloszenie zgloszenie = zgloszenieService.get(id);
        model.addAttribute("zgloszenie", zgloszenie);
        return "user/zakoncz";
    }

    @RequestMapping(value = "/user/end", method = RequestMethod.POST)
    public String endZgloszenie(@ModelAttribute("zgloszenie") Zgloszenie zgloszenie) {
        zgloszenie.setStatus("3");
        zgloszenieService.save(zgloszenie);
        History history = new History(zgloszenie.getId(), new Date(), "Zamknięto zgłoszenie", "test");
        historyService.save(history);
        return "user/redirect:/";
    }

    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


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


