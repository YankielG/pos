package pl.edu.wszib.pos.controller;

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
import pl.edu.wszib.pos.model.History;
import pl.edu.wszib.pos.model.Zgloszenie;
import pl.edu.wszib.pos.service.HistoryService;
import pl.edu.wszib.pos.service.ZgloszenieService;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class AppController {

    @Autowired
    private ZgloszenieService zgloszenieService;
//    @Autowired
//    private RoleService roleService;
//    private UserService userService;
    @Autowired
    private HistoryService historyService;
    private Long zgloszenieId;
    private Zgloszenie zgloszenie;


   @RequestMapping("/")
    public String viewHomePage(Model model) {
        Iterable<Zgloszenie> zgloszenieList = zgloszenieService.findAll();
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
    public String saveZgloszenie(@ModelAttribute("zgloszenie") Zgloszenie zgloszenie, @ModelAttribute("history") History history) {
        zgloszenie.setcData(new Date());
        zgloszenie.setStatus("1");
        zgloszenie.setAllocation("brak");
        zgloszenie.setEndDescription("brak");
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
    public String deleteZgloszenie(@PathVariable(name = "id") long id) {
        zgloszenieService.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/test")
    public String test() {
        return "test_tabeli";
    }

}


