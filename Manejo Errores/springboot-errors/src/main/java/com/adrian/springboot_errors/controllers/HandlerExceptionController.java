package com.adrian.springboot_errors.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<?> divisionByZero(Exception ex){
        return ResponseEntity.internalServerError().body("Error 500");
    }

}
