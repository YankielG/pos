package pl.edu.wszib.pos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.pos.model.History;
import pl.edu.wszib.pos.model.Zgloszenie;
import pl.edu.wszib.pos.repository.ZgloszenieRepository;
import pl.edu.wszib.pos.service.*;

import java.util.Date;


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
    private ZgloszenieRepository zgloszenieRepository;
    private Long zgloszenieId;
    private Zgloszenie zgloszenie;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        return "/index";
    }

    @RequestMapping("/nowe")
    public String showNoweZgloszenie(Model model) {
        Zgloszenie zgloszenie = new Zgloszenie();
        model.addAttribute("zgloszenie", zgloszenie);
        return "nowe_zgloszenie";
    }
//
    @RequestMapping(value = "/save", method = RequestMethod.POST)
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
//
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delZgloszenie(@ModelAttribute("zgloszenie") Zgloszenie zgloszenie) {
        zgloszenie.setDel(false);
        zgloszenieService.save(zgloszenie);
        //History history = new History(zgloszenie.getId(), new Date(), "Usunięto z bazy", "test");
        //historyService.save(history);
        return "user/redirect:/";
    }

    @RequestMapping(value = "/manager/przydziel/{id}")
    public String przydzielZgloszenie(@PathVariable Long id, Model model) {
        Zgloszenie zgloszenie = zgloszenieService.get(id);
        model.addAttribute("zgloszenie", zgloszenie);
        return "manager/przydziel";
    }


@GetMapping("/details/{id}")
public String detailsZgloszenia(@PathVariable Long id, Model model) {
    Zgloszenie zgloszenie = zgloszenieService.get(id);
    model.addAttribute("zgloszenie", zgloszenie);
    return "szczegoly";
}

    @RequestMapping("/zakoncz/{id}")
    public String zakonczZgloszenie(@PathVariable Long id, Model model) {
        Zgloszenie zgloszenie = zgloszenieService.get(id);
        model.addAttribute("zgloszenie", zgloszenie);
        return "zakoncz";
    }

    @RequestMapping(value = "/end", method = RequestMethod.POST)
    public String endZgloszenie(@ModelAttribute("zgloszenie") Zgloszenie zgloszenie) {
        zgloszenie.setStatus("3");
        zgloszenieService.save(zgloszenie);
        //History history = new History(zgloszenie.getId(), new Date(), "Zamknięto zgłoszenie", "test");
       // historyService.save(history);
        return "redirect:/";
    }

}


