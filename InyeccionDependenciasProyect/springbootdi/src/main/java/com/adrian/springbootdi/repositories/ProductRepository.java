package com.adrian.springbootdi.repositories;

import java.util.List;

import com.adrian.springbootdi.models.Product;

public interface ProductRepository {
    List<Product> findAll();

    Product findById(Long id);
}
