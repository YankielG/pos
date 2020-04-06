package pl.edu.wszib.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.pos.model.History;
import pl.edu.wszib.pos.model.User;
import pl.edu.wszib.pos.model.Zgloszenie;
import pl.edu.wszib.pos.repository.UserRepository;
import pl.edu.wszib.pos.repository.ZgloszenieRepository;
import pl.edu.wszib.pos.service.HistoryService;
import pl.edu.wszib.pos.service.RoleService;
import pl.edu.wszib.pos.service.UserService;
import pl.edu.wszib.pos.service.ZgloszenieService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
