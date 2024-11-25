package com.adrian.springboot_crud.validation;

import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.adrian.springboot_crud.repositories.UserRepository;
import com.adrian.springboot_crud.services.interfaces.UserService;
import com.adrian.springboot_crud.validation.ExistsByUsername;

@Component
public class ExistsByUsernameValidation implements ConstraintValidator<ExistsByUsername, String> {

    @Autowired
    private UserService userService;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
       return !userService.existsByUsername(username);
    }

}