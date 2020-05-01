package pl.edu.wszib.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.wszib.pos.configuration.Pager;
import pl.edu.wszib.pos.model.History;
import pl.edu.wszib.pos.model.Zgloszenie;
import pl.edu.wszib.pos.repository.ZgloszenieRepository;
import pl.edu.wszib.pos.service.*;

import java.util.Date;
import java.util.Optional;


@Controller
public class AppController {

    private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 5;
    private static final int[] PAGE_SIZES = {5, 10, 20, 50};

    private final ZgloszenieService zgloszenieService;
    public AppController(ZgloszenieService zgloszenieService) {
        this.zgloszenieService = zgloszenieService;
    }

    @GetMapping("/zgloszenia")
    public ModelAndView showPersonsPage(@RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("zgloszenia");


        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);

        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        Page<Zgloszenie> zgloszenia = zgloszenieService.findAllPageable(PageRequest.of(evalPage, evalPageSize));
        Pager pager = new Pager(zgloszenia.getTotalPages(), zgloszenia.getNumber(), BUTTONS_TO_SHOW);

        modelAndView.addObject("zgloszenia", zgloszenia);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }
//    @Autowired
//    private RoleService roleService;
//    @Autowired
//    private UserService userService;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private ZgloszenieRepository zgloszenieRepository;
//    private Long zgloszenieId;
//    private Zgloszenie zgloszenie;
//
    @RequestMapping("/")
    public String viewHomePage(Model model) {
        return "glowna";
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
        zgloszenie.setDel(true);
        zgloszenieRepository.save(zgloszenie);
        history.setzId(zgloszenie.getId());
        history.sethData(new Date());
        history.sethDescription("Test");
        history.sethUser("test");
        historyService.save(history);
        return "podsumowanie";
    }


//    @GetMapping("/edycja/{id}")
//    public String edycjaZgloszenia(@PathVariable Long id, Model model) {
//        Zgloszenie zgloszenie = zgloszenieService.get(id);
//        model.addAttribute("zgloszenie", zgloszenie);
//        return "edycja-zgloszenia";
//    }
//
//    @RequestMapping("/del/{id}")
//    public String deleteZgloszenie(@PathVariable Long id, Model model) {
//        Zgloszenie zgloszenie = zgloszenieService.get(id);
//        model.addAttribute("zgloszenie", zgloszenie);
//        return "usun";
//    }
////
//    @RequestMapping(value = "/delete", method = RequestMethod.POST)
//    public String delZgloszenie(@ModelAttribute("zgloszenie") Zgloszenie zgloszenie) {
//        zgloszenie.setDel(false);
//        zgloszenieService.save(zgloszenie);
//        //History history = new History(zgloszenie.getId(), new Date(), "Usunięto z bazy", "test");
//        //historyService.save(history);
//        return "user/redirect:/";
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


