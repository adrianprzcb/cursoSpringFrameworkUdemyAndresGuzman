package com.adrian.springboot_errors.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.springboot_errors.exceptions.UserNotFoundException;
import com.adrian.springboot_errors.models.domain.User;
import com.adrian.springboot_errors.services.UserService;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserService service;


    @GetMapping
    public String index(){
       // int value = 100/0;
       int value = Integer.parseInt("10X");
        System.out.println(value);
        return "Ok 200";
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<?> show(@PathVariable(name = "id") Long id){
     //   User user = service.findById(id).orElseThrow(() -> new UserNotFoundException("Error el usuario no existe"));
        Optional<User> optionalUser = service.findById(id);
        if (optionalUser.isEmpty()){
            return ResponseEntity.notFound().build();
        }
       // System.out.println(user.getLastname());
       return ResponseEntity.ok(optionalUser.orElseThrow());
    }


}
