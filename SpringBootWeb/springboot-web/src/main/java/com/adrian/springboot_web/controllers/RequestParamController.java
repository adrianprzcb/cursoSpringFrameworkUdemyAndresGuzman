package com.adrian.springboot_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.springboot_web.models.DTO.ParamDto;
import com.adrian.springboot_web.models.DTO.ParamMixDto;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/params")
public class RequestParamController {

    @GetMapping("/foo")
        public ParamDto foo(@RequestParam(required = false, defaultValue = "hola que tal") String message) {
            ParamDto paramDto = new ParamDto();

            paramDto.setMessage(message);
            return paramDto;
        }


        @GetMapping("/bar")
        public ParamMixDto bar(@RequestParam String text, @RequestParam Integer code){
            ParamMixDto params = new ParamMixDto();
            params.setMessage(text);
            params.setCode(code);
            return params;
        }



        @GetMapping("/request")
        public ParamMixDto request(HttpServletRequest request){
            ParamMixDto params = new ParamMixDto();
            params.setMessage(request.getParameter("message"));
            params.setCode(Integer.parseInt(request.getParameter("code")));
            return params;
        }
    }
    

