package com.adrian.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.adrian.springboot_web.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        User user = new User("Adrian", "Gonzalez");
        model.addAttribute("title", "Spring Boot App");
       model.addAttribute("user", user);
        return "details";
    }

}
