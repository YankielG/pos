package pl.edu.wszib.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.wszib.pos.model.Zgloszenie;
import pl.edu.wszib.pos.service.ZgloszenieService;

import java.util.Date;
import java.util.List;

@Controller
public class AppController {
    @Autowired
    private ZgloszenieService zgloszenieService;

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
    public String saveZgloszenie(@ModelAttribute("zgloszenie") Zgloszenie zgloszenie) {
        zgloszenie.setcData(new Date());
        zgloszenie.setStatus("1");
        zgloszenieService.save(zgloszenie);

        return "redirect:/";
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
