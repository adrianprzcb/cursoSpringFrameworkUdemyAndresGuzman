package com.adrian.springboot_crud.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.springboot_crud.models.entities.Product;
import com.adrian.springboot_crud.services.interfaces.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    public ProductService productService;


    @PreAuthorize("hasAnyRole('ADMIN' , 'USER')")
    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @PreAuthorize("hasAnyRole('ADMIN' , 'USER')")
    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<Product> optProduct = productService.findById(id);
        if(optProduct.isPresent()){
            return ResponseEntity.ok(optProduct.orElseThrow());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Product product, BindingResult result){
        if(result.hasFieldErrors()){
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<?> update( @Valid @RequestBody Product product, BindingResult result, @PathVariable Long id){
        if(result.hasFieldErrors()){
            return validation(result);
        }
        Optional<Product> optProduct = productService.update(id,product);
        if(optProduct.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(optProduct.orElseThrow());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Product> optProduct = productService.delete(id);
        if(optProduct.isPresent()){
          return ResponseEntity.ok(optProduct.orElseThrow());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    private ResponseEntity<?> validation(BindingResult result){
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(err ->{
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }

}
