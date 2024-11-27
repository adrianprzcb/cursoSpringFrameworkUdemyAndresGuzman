package com.adrian.backend_products.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adrian.backend_products.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
