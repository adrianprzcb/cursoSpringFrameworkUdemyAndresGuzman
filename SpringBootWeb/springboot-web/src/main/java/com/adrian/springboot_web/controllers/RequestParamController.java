package com.adrian.springboot_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.springboot_web.models.DTO.ParamDto;

@RestController
@RequestMapping("/api/params")
public class RequestParamController {

    @GetMapping("/foo")
        public ParamDto foo(@RequestParam(required = false, defaultValue = "hola que tal") String message) {
            ParamDto paramDto = new ParamDto();

            paramDto.setMessage(message);
            return paramDto;
        }
    }
    

