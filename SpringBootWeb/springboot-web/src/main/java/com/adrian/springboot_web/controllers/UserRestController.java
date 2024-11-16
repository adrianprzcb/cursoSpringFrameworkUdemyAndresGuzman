package com.adrian.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.springboot_web.models.User;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public Map<String, Object> details() {
        User user = new User("Adrian", "Gonzalez");
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Spring Boot App");
        body.put("name", user);


        return body;
    }
    
}
