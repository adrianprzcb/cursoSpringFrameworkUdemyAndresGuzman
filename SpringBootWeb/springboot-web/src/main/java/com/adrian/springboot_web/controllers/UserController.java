package com.adrian.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        model.addAttribute("title", "Spring Boot App");
        model.addAttribute("name", "Adrian");
        model.addAttribute("lastname", "Gonzalez");
        return "details";
    }

}
