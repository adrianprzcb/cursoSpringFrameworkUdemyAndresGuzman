package com.adrian.springboot_errors.services;

import java.util.List;
import java.util.Optional;

import com.adrian.springboot_errors.models.domain.User;

public interface UserService {

    List<User> findAll();
    Optional<User> findById(Long id);

}
