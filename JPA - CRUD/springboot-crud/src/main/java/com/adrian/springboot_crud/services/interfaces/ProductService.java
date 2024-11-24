package com.adrian.springboot_crud.services.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adrian.springboot_crud.models.entities.Product;

public interface ProductService {

    List<Product> findAll();

    Product findById(Long id);

    Product save(Product product);

    void delete(Product product);

}
