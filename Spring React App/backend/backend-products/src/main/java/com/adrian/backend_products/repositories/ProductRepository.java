package com.adrian.backend_products.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adrian.backend_products.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
