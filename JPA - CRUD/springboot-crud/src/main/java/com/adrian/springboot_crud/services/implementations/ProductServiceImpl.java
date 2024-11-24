package com.adrian.springboot_crud.services.implementations;

import java.util.List;

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
        // TODO Auto-generated method stub
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public Product findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Transactional
    @Override
    public Product save(Product product) {
        // TODO Auto-generated method stub
        return null;
    }


    @Transactional
    @Override
    public void delete(Product product) {
        // TODO Auto-generated method stub

    }
    

}
