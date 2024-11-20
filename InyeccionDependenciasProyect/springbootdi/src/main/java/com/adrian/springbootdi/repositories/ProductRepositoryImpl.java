package com.adrian.springbootdi.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.adrian.springbootdi.models.Product;

@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository {

    List<Product> data;

    public ProductRepositoryImpl() {
        this.data = List.of(
            new Product(1L, "Product 1", 100L),
            new Product(2L, "Product 2", 200L),
            new Product(3L, "Product 3", 300L),
            new Product(4L, "Product 4", 400L)
        );
    }


    public List<Product> findAll() {
        return data;
    }

    public Product findById(Long id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }

    
    



}
