package pl.edu.wszib.pos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.pos.helper.PageModel;
import pl.edu.wszib.pos.model.History;
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


    @RequestMapping("/user/index")
    public String viewHomePage(Model model) {
        Iterable<Zgloszenie> zgloszenieList = zgloszenieService.findAll();
         model.addAttribute("zgloszenielist", zgloszenieList);
        return "user/index";
    }


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
        return "manager/przydziel";
    }


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


}


