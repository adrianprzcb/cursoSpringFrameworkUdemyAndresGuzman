package com.adrian.springboot_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.springboot_web.models.DTO.ParamDto;

@RestController
@RequestMapping("/api/var")
public class PathVariableController{


    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable() String message){
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }
    

}
