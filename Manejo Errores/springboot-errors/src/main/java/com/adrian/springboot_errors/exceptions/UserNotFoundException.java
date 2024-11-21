package com.adrian.springboot_errors.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message){
        super(message);
    }

}
