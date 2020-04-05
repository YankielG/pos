package pl.edu.wszib.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.pos.model.History;
import pl.edu.wszib.pos.model.Zgloszenie;
import pl.edu.wszib.pos.service.HistoryService;
import pl.edu.wszib.pos.service.RoleService;
import pl.edu.wszib.pos.service.UserService;
import pl.edu.wszib.pos.service.ZgloszenieService;

import java.sql.Time;
import java.util.Date;

@Controller
public class AppController {
    @Autowired
    private ZgloszenieService zgloszenieService;
    private RoleService roleService;
    private UserService userService;
    private HistoryService historyService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        Iterable<Zgloszenie> zgloszenieList = zgloszenieService.listAll();
        model.addAttribute("zgloszenielist", zgloszenieList);
        return "index";
    }

    @RequestMapping("/nowe")
    public String showNoweZgloszenie(Model model) {
        Zgloszenie zgloszenie = new Zgloszenie();
        model.addAttribute("zgloszenie", zgloszenie);
        return "nowe_zgloszenie";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveZgloszenie(@ModelAttribute("zgloszenie") Zgloszenie zgloszenie, History history) {
        zgloszenie.setcData(new Date());
        zgloszenie.setStatus("1");
        zgloszenieService.save(zgloszenie);
//        history.sethData(new Date());
//        history.sethDescription("Przyjęcie do serwisu");
//       historyService.save(history);
        return "redirect:/";
    }

    @GetMapping("/edycja/{id}")
    public String edycjaZgloszenia(@PathVariable Long id, Model model) {
        Zgloszenie zgloszenie = zgloszenieService.get(id);
        model.addAttribute("zgloszenie", zgloszenie);
        return "edycja-zgloszenia";
    }

    @GetMapping("/przydziel/{id}")
    public String przydzielZgloszenia(@PathVariable Long id, Model model) {
        Zgloszenie zgloszenie = zgloszenieService.get(id);
        model.addAttribute("zgloszenie", zgloszenie);
//        List<User> list = userService.getUsers();
//        model.addAttribute("users", list);
        return "przydziel";
    }


//    @RequestMapping("/edit/{id}")
//    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
//        ModelAndView mav = new ModelAndView("edycja_zgloszenia");
//        Zgloszenie zgloszenie = ZgloszenieService.get(id);
//        mav.addObject("zgloszenie", zgloszenie);
//
//        return mav;
//    }


}
