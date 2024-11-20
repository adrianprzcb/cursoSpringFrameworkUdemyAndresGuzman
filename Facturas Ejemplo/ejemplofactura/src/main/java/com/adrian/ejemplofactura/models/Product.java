package com.adrian.ejemplofactura.models;


public class Product {

    public Product(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public Product() {
    
    }
    private String name;
    private Integer price;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }

}
