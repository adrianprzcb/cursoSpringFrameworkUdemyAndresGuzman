package com.adrian.springboot_crud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.adrian.springboot_crud.models.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{

}
