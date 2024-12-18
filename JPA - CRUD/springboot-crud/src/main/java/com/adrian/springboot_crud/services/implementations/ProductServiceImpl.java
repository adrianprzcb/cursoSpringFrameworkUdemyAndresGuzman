package com.adrian.springboot_crud.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrian.springboot_crud.models.entities.Product;
import com.adrian.springboot_crud.repositories.ProductRepository;
import com.adrian.springboot_crud.services.interfaces.ProductService;

import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }


    @Transactional
    @Override
    public Optional<Product> delete(Long id) {
        Optional<Product> productToDelete = productRepository.findById(id);
        productToDelete.ifPresent(prod -> productRepository.delete(prod));

        return productToDelete;

    }

    @Transactional
    @Override
    public Optional<Product> update(Long id, Product product){
        Optional<Product> optProduct = productRepository.findById(id);
        if(optProduct.isPresent()){
            Product productToUpdate = optProduct.orElseThrow();
            productToUpdate.setName(product.getName());
            productToUpdate.setDescription(product.getDescription());
            productToUpdate.setPrice(product.getPrice());
            return Optional.of(productRepository.save(productToUpdate));
        }
        return optProduct;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsBySku(String sku) {
        return productRepository.existsBySku(sku);
    }

    

}
