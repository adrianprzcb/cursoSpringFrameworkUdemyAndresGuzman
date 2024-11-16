package com.adrian.springboot_web.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.springboot_web.models.User;
import com.adrian.springboot_web.models.DTO.UserDto;

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


    @GetMapping("/detailsDto")
    public UserDto detailsDto() {
        UserDto userDto = new UserDto();
        User user = new User("Adrian", "Gonzalez");
        userDto.setName(user.getName());
        userDto.setLastname(user.getLastname());
        userDto.setTitle("Hola Mundo Spring Boot");
    

        return userDto;
    }


    @GetMapping("/list")
    public List<User> list() {
        List<User> users = new ArrayList<>();
        users.add(new User("Adrian", "Gonzalez"));
        users.add(new User("John", "Doe"));
        users.add(new User("Jane", "Doe"));
        return users;
    }

    
}
