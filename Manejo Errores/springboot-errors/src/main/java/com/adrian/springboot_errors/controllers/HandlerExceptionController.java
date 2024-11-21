package com.adrian.springboot_errors.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.adrian.springboot_errors.models.Error;

import io.micrometer.core.ipc.http.HttpSender.Response;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> numberFormatException(Exception e){
        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date().toString());
        error.put("error", "Número invadlido o incorrecto, no tiene formato de digito!");
        error.put("message" , e.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        
        return error;
    }


    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Error> divisionByZero(Exception ex){
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Error division por cero");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    //    return ResponseEntity.internalServerError().body(error);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFoundException(NoHandlerFoundException e){

        Error error = new Error();
        error.setDate(new Date());
        error.setError("Api Rest no encontrado");
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);

    }




}
