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
import pl.edu.wszib.pos.model.History;
import pl.edu.wszib.pos.model.Zgloszenie;
import pl.edu.wszib.pos.repository.ZgloszenieRepository;
import pl.edu.wszib.pos.service.HistoryService;
import pl.edu.wszib.pos.service.RoleService;
import pl.edu.wszib.pos.service.UserService;
import pl.edu.wszib.pos.service.impl.ZgloszenieServiceImpl;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/")
public class AppController {

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

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private ZgloszenieServiceImpl zgloszenieService;
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

    @GetMapping("/zgloszenia/add")
    public ModelMap addZgloszenie(Zgloszenie zgloszenie){
        return new ModelMap("zgloszenie", zgloszenie);
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute("zgloszenie") Zgloszenie zgloszenie, @ModelAttribute("history") History history) {
        //zgloszenie.setcData(zgloszenie.getcData());
        //zgloszenie.setStatus("1");
        zgloszenie.setDel(true);
        repo.save(zgloszenie);
        history = new History();
        history.setzId(zgloszenie.getId());
        history.sethData(new Date());
        history.sethDescription("Edit");
        history.sethUser("edit");
        historyService.save(history);
        return "redirect:zgloszenia/lista";
    }

    @RequestMapping(value = "/saveAdd", method = RequestMethod.POST)
    public String saveAdd(@ModelAttribute("zgloszenie") Zgloszenie zgloszenie, @ModelAttribute("history") History history) {
        zgloszenie.setcData(new Date());
        //zgloszenie.setStatus("1");
        zgloszenie.setDel(true);
        repo.save(zgloszenie);
        history.setzId(zgloszenie.getId());
        history.sethData(new Date());
        history.sethDescription("Test");
        history.sethUser("test");
        historyService.save(history);
        return "redirect:zgloszenia/lista";
    }
    @GetMapping("/zgloszenia/details")
    public ModelMap details(@RequestParam(value = "id",required = false)Zgloszenie zgloszenie){
        return new ModelMap("zgloszenie", zgloszenie);
    }

//    @GetMapping("zgloszenia/del")
//    public ModelMap usunZgłoszenie(@RequestParam(value = "id")Zgloszenie zgloszenie) {
//        return new ModelMap("zgloszenie", zgloszenie);
//    }
//
//    @RequestMapping(value = "/del", method = RequestMethod.POST)
//    public String delZgloszenie(@ModelAttribute("zgloszenie") Zgloszenie zgloszenie, @ModelAttribute("history") History history) {
//        //zgloszenie.setStatus("1");
//        zgloszenie.setDel(true);
//        repo.save(zgloszenie);
//        history.setzId(zgloszenie.getId());
//        history.sethData(new Date());
//        history.sethDescription("usunięto");
//        history.sethUser("test");
//        historyService.save(history);
//        return "redirect:zgloszenia/lista";
//    }
//
//    @RequestMapping(value = "/delete", method = RequestMethod.POST)
//    public String delZgloszenie(@ModelAttribute("zgloszenie") Zgloszenie zgloszenie, @ModelAttribute("historia") History history) {
//        zgloszenie.setDel(false);
//        repo.save(zgloszenie);
////        History history = new History("", new Date(), "Usunięto z bazy", "test", zgloszenie.getId());
////        historyService.save(history);
//        return "redirect:/";
//    }

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


