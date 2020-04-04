package pl.edu.wszib.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.wszib.pos.model.User;
import pl.edu.wszib.pos.service.UserService;

import javax.validation.Valid;

public class Controller {

    @Autowired
    private UserService userService;

    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @RequestMapping(value="/admin/adduser", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("adduser");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/adduser", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByOIC(user.getOIC());
        if (userExists != null) {
            bindingResult
                    .rejectValue("OIC", "error.user",
                            "Użytkownik o takim OIC już istnieje w systemie");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("adduser");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "Poprawnie dodano użytkownika");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("adduser");

        }
        return modelAndView;
    }

    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByOIC(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getOIC() + "/" + user.getfName() + " " + user.getlName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }


}

