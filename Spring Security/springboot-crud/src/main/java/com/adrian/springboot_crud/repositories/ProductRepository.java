package com.adrian.springboot_crud.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrian.springboot_crud.models.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

    boolean existsBySku(String sku);

}
