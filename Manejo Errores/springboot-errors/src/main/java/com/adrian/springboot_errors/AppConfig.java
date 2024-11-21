package com.adrian.springboot_errors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.adrian.springboot_errors.models.domain.User;

@Configuration
public class AppConfig {

        @Bean
        List<User> users(){
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Adrian", "Gomez"));
        users.add(new User(2L, "John", "Doe"));
        users.add(new User(3L, "Jane", "Doe"));
        users.add(new User(4L, "Tomas", "Smith"));
        users.add(new User(5L, "Jhon", "Smith"));
        users.add(new User(6L, "Jane", "Smith"));

        return users;
    }

}
