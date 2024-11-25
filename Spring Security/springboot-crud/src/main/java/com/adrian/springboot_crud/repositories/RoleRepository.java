package com.adrian.springboot_crud.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrian.springboot_crud.models.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{

    Optional<Role> findByName(String name);

}
