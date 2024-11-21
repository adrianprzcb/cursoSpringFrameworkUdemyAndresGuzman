package com.adrian.springboot_errors.services;

import java.util.List;

import com.adrian.springboot_errors.models.domain.User;

public interface UserService {

    List<User> findAll();
    User findById(Long id);

}
