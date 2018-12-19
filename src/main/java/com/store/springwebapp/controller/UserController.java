package com.store.springwebapp.controller;


import com.store.springwebapp.model.User;
import com.store.springwebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String test() {
        return "login";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST )
public String test(@ModelAttribute("user") User user, BindingResult bindingResult, Model model){

        userService.save(user);

        return "hello";
}


}
