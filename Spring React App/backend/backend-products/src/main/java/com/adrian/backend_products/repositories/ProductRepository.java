package com.adrian.backend_products.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.adrian.backend_products.entities.Product;

@RepositoryRestResource(path = "products")
public interface ProductRepository extends JpaRepository<Product, Long> {

}
