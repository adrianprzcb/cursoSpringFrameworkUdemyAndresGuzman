package com.adrian.springboot_horario.controllers;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/foo")
    public ResponseEntity<?> foo(){
        Map<String, Object> data = new HashMap<>();
        data.put("Title", "Bienvenido al sistema de atención");
        data.put("Date", new Date());
        return ResponseEntity.ok(data);
    }

}
