package com.adrian.springboot_crud.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adrian.springboot_crud.models.entities.User;
import com.adrian.springboot_crud.repositories.UserRepository;
import com.adrian.springboot_crud.services.interfaces.UserService;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>) repository.findAll();
    }

    @Override
    @Transactional
    public User save(User user) {
        return repository.save(user);
    }

}
