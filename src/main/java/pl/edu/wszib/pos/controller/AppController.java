package pl.edu.wszib.pos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.edu.wszib.pos.model.Zgloszenie;
import pl.edu.wszib.pos.repository.ZgloszenieRepository;
import pl.edu.wszib.pos.service.*;


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

//    @RequestMapping("/")
//    public String viewHomePage(Model model) {
//        return "/index";
//    }
//
//    @RequestMapping(value = "/zgloszenia/page/{page}")
//    public ModelAndView listZgloszenia(@PathVariable("page") int page) {
//        ModelAndView modelAndView = new ModelAndView("zgloszenia-paging");
//        PageRequest pageable = PageRequest.of(page - 1, 10);
//       // Page<Zgloszenie> zgloszeniePage = zgloszenieService.getPaginatedZgloszenia(pageable);
//        //int totalPages = zgloszeniePage.getTotalPages();
//        if (totalPages > 0) {
//            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed()
//                    .collect(Collectors.toList());
//            modelAndView.addObject("pageNumbers", pageNumbers);
//        }
//        modelAndView.addObject("activeZgloszenieList", true);
//        modelAndView.addObject("zgloszenieList", zgloszeniePage.getContent());
//        return modelAndView;
//    }
//
//    @GetMapping("/user/zgloszenia")
//    public String getAllZgloszenia(Model model) {
//        pageModel.setSIZE(10);
//        pageModel.initPageAndSize();
//        model.addAttribute("zgloszenia", zgloszenieRepository.findAllByIdAndDelIsTrue(PageRequest.of(pageModel.getSIZE(), pageModel.getPAGE())));
//        return "zgloszenia";
//    }

//    @GetMapping("/user/zgloszenia")
//    public String getAllZgloszenia(Model model) {
//        pageModel.setSIZE(10);
//        pageModel.initPageAndSize();
//        model.addAttribute("zgloszenia", zgloszenieRepository.findAllByIdAndDelIsTrue(PageRequest.of(pageModel.getPAGE(), pageModel.getSIZE())));
//        return "zgloszenia";
//    }

//
//    @RequestMapping("/user/nowe")
//    public String showNoweZgloszenie(Model model) {
//        Zgloszenie zgloszenie = new Zgloszenie();
//        model.addAttribute("zgloszenie", zgloszenie);
//        return "user/nowe_zgloszenie";
//    }
//
//    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
//    public String saveZgloszenie(@ModelAttribute("zgloszenie") Zgloszenie zgloszenie, @ModelAttribute("history") History history) {
//        zgloszenie.setcData(new Date());
//        zgloszenie.setStatus("1");
//        zgloszenie.setDel(true);
//        zgloszenieService.save(zgloszenie);
//        history.setzId(zgloszenie.getId());
//        history.sethData(new Date());
//        history.sethDescription("Test");
//        history.sethUser("test");
//        historyService.save(history);
//        return "user/podsumowanie";
//    }
//
//
//    @GetMapping("/user/edycja/{id}")
//    public String edycjaZgloszenia(@PathVariable Long id, Model model) {
//        Zgloszenie zgloszenie = zgloszenieService.get(id);
//        model.addAttribute("zgloszenie", zgloszenie);
//        return "user/edycja-zgloszenia";
//    }
//
//    @RequestMapping("/user/del/{id}")
//    public String deleteZgloszenie(@PathVariable Long id, Model model) {
//        Zgloszenie zgloszenie = zgloszenieService.get(id);
//        model.addAttribute("zgloszenie", zgloszenie);
//        return "user/usun";
//    }
//
//    @RequestMapping(value = "/user/delete", method = RequestMethod.POST)
//    public String delZgloszenie(@ModelAttribute("zgloszenie") Zgloszenie zgloszenie) {
//        zgloszenie.setDel(false);
//        zgloszenieService.save(zgloszenie);
//        History history = new History(zgloszenie.getId(), new Date(), "Usunięto z bazy", "test");
//        historyService.save(history);
//        return "user/redirect:/";
//    }
//
//    @RequestMapping(value = "/manager/przydziel/{id}")
//    public String przydzielZgloszenie(@PathVariable Long id, Model model) {
//        Zgloszenie zgloszenie = zgloszenieService.get(id);
//        model.addAttribute("zgloszenie", zgloszenie);
//        return "manager/przydziel";
//    }
//
//
//@GetMapping("/user/details/{id}")
//public String detailsZgloszenia(@PathVariable Long id, Model model) {
//    Zgloszenie zgloszenie = zgloszenieService.get(id);
//    model.addAttribute("zgloszenie", zgloszenie);
//    return "user/szczegoly";
//}
//
//    @RequestMapping("/user/zakoncz/{id}")
//    public String zakonczZgloszenie(@PathVariable Long id, Model model) {
//        Zgloszenie zgloszenie = zgloszenieService.get(id);
//        model.addAttribute("zgloszenie", zgloszenie);
//        return "user/zakoncz";
//    }
//
//    @RequestMapping(value = "/user/end", method = RequestMethod.POST)
//    public String endZgloszenie(@ModelAttribute("zgloszenie") Zgloszenie zgloszenie) {
//        zgloszenie.setStatus("3");
//        zgloszenieService.save(zgloszenie);
//        History history = new History(zgloszenie.getId(), new Date(), "Zamknięto zgłoszenie", "test");
//        historyService.save(history);
//        return "user/redirect:/";
//    }

}


