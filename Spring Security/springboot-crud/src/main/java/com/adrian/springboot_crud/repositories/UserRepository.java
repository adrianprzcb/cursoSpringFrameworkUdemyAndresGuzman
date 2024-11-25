package com.adrian.springboot_crud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.adrian.springboot_crud.models.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{
    
}
