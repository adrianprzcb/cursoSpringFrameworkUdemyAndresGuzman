package com.adrian.springboot_jpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.adrian.springboot_jpa.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {



}
