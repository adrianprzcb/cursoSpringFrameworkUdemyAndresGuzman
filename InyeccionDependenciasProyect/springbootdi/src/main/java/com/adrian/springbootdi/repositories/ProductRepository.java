package com.adrian.springbootdi.repositories;

import java.util.List;

import com.adrian.springbootdi.models.Product;

public class ProductRepository {

    List<Product> data;

    public ProductRepository() {
        this.data = List.of(
            new Product(1L, "Product 1", 100.0),
            new Product(2L, "Product 2", 200.0),
            new Product(3L, "Product 3", 300.0)
        );
    }

}
