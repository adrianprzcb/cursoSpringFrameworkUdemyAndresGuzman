package com.adrian.springboot_crud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.adrian.springboot_crud.models.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
