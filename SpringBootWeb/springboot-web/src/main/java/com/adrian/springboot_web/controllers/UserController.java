package com.adrian.springboot_web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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


    @GetMapping("/list")
    public String list(ModelMap model){
        List<User> users = new ArrayList<>();
        model.addAttribute("users", users);
        model.addAttribute("title", "Spring Boot App");
        return "list";
    }

}
