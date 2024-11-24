package com.adrian.springboot_crud.services.interfaces;

import java.util.List;
import java.util.Optional;


import com.adrian.springboot_crud.models.entities.Product;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    Product save(Product product);

    Optional<Product> delete(Product product);

}
