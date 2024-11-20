package com.adrian.springbootdi.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.adrian.springbootdi.models.Product;

@Repository("productFoo")
public class ProductRepositoryFoo implements ProductRepository {

 //   @Autowired
  //  @Qualifier("productFoo")
  //  private ProductRepository repository;

    @Override
    public List<Product> findAll() {
       return Collections.singletonList(new Product(1L, "Product 1", 100L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(1L, "Product 1", 100L);
    }

}
