package com.adrian.springboot_crud.services.interfaces;

import java.util.List;

import com.adrian.springboot_crud.models.entities.User;

public interface UserService {

    List<User> findAll();

    User save (User user);

    boolean existsByUsername(String username);
    
} 