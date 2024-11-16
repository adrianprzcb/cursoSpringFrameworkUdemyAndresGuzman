package com.adrian.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public String details() {
        Map<String, String> body = new HashMap<>();

        body.put("title", "Spring Boot App");
        body.put("name", "Adrian");
        body.put("lastname", "Gonzalez");


        return body.toString();
    }
    
}
