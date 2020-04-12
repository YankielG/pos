package pl.edu.wszib.pos.controller;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.model.IModel;
import pl.edu.wszib.pos.model.History;
import pl.edu.wszib.pos.model.User;
import pl.edu.wszib.pos.model.Zgloszenie;
import pl.edu.wszib.pos.repository.ZgloszenieRepository;
import pl.edu.wszib.pos.service.HistoryService;
import pl.edu.wszib.pos.service.RoleService;
import pl.edu.wszib.pos.service.UserService;
import pl.edu.wszib.pos.service.ZgloszenieService;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



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



    private Long zgloszenieId;
    private Zgloszenie zgloszenie;


    @RequestMapping("/")
    public String viewHomePage( Model model) {
        Iterable<Zgloszenie> zgloszenieList = zgloszenieService.findAll();
         model.addAttribute("zgloszenielist", zgloszenieList);
        return "index";
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

    @RequestMapping("/nowe")
    public String showNoweZgloszenie(Model model) {
        Zgloszenie zgloszenie = new Zgloszenie();
        model.addAttribute("zgloszenie", zgloszenie);
        return "nowe_zgloszenie";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveZgloszenie(@ModelAttribute("zgloszenie") Zgloszenie zgloszenie, @ModelAttribute("history") History history) {
        zgloszenie.setcData(new Date());
        zgloszenie.setStatus("1");
        zgloszenie.setDel(0);
        zgloszenie.setuId((long) 1);
        zgloszenieService.save(zgloszenie);
        history.setzId(zgloszenie.getId());
        history.sethData(new Date());
        history.sethDescription("Test");
        history.sethUser("test");
        historyService.save(history);
        return "podsumowanie";
    }


    @GetMapping("/edycja/{id}")
    public String edycjaZgloszenia(@PathVariable Long id, Model model) {
        Zgloszenie zgloszenie = zgloszenieService.get(id);
        model.addAttribute("zgloszenie", zgloszenie);
        return "edycja-zgloszenia";
    }

    @RequestMapping("/del/{id}")
    public String deleteZgloszenie(@PathVariable Long id, Model model) {
        Zgloszenie zgloszenie = zgloszenieService.get(id);
        model.addAttribute("zgloszenie", zgloszenie);
        return "usun";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delZgloszenie(@ModelAttribute("zgloszenie") Zgloszenie zgloszenie) {
        zgloszenie.setDel(1);
        zgloszenieService.save(zgloszenie);
        History history = new History(zgloszenie.getId(), new Date(), "Usunięto z bazy", "test");
        historyService.save(history);
        return "redirect:/";
    }

    @RequestMapping(value = "/przydziel/{id}")
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

        return "przydziel";
    }

//    @RequestMapping(value = "/historia/{id}")
//    public String historiaZgloszenia(@PathVariable Long id, Model model) {
//        Zgloszenie zgloszenie = zgloszenieService.get(id);
//        model.addAttribute("zgloszenie", zgloszenie);
//        Iterable<History> histories = hi
//    }


}
