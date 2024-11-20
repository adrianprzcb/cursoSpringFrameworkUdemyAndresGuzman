package com.adrian.springbootdi.services;

import java.util.List;

import com.adrian.springbootdi.models.Product;

public interface ProductService {

    List<Product> findAll();

    Product findById(Long id);

}
