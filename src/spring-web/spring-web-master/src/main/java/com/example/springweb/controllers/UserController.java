package com.example.springweb.controllers;

import com.example.springweb.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class UserController {
    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    public String showForm(AppUser appUser){
        return "registration";
    }

    @RequestMapping(value="/user/add", method= RequestMethod.POST)
    public String checkPersonInfo(@ModelAttribute @Valid AppUser appUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        System.out.println(appUser);
        return "registration";
    }
}
