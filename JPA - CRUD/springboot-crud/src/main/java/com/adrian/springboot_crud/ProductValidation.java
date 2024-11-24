package com.adrian.springboot_crud;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.adrian.springboot_crud.models.entities.Product;



@Component
public class ProductValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        if (product.getName() == null || product.getName().isEmpty()) {
            errors.rejectValue("name", "name.empty");
        }
        if (product.getPrice() == null || product.getPrice() <= 0) {
            errors.rejectValue("price", "price.invalid");
        }
    }

}
