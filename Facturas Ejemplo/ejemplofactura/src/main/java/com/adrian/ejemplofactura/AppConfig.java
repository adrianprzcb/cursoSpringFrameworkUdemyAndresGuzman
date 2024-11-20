package com.adrian.ejemplofactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.adrian.ejemplofactura.models.Item;
import com.adrian.ejemplofactura.models.Product;

@Configuration
@PropertySource("classpath:data.properties")
public class AppConfig {

    @Bean
    List<Item> itemsInvoice(){
        Product p1 = new Product("Laptop", "1500");
        Product p2 = new Product("Mouse", "20");
      return Arrays.asList(new Item(p1, 2), new Item(p2, 4));
    }
    
}
