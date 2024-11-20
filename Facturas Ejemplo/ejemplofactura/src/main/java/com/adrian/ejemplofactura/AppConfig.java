package com.adrian.ejemplofactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.adrian.ejemplofactura.models.Item;
import com.adrian.ejemplofactura.models.Product;

@Configuration
@PropertySource(value ="classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

    @Bean
    List<Item> itemsInvoice(){
        Product p1 = new Product("Laptop", 1500);
        Product p2 = new Product("Mouse", 20);
      return Arrays.asList(new Item(p1, 2), new Item(p2, 4));
    }

    @Bean
    @Primary
    List<Item> itemsInvoiceOffice(){
        Product p1 = new Product("Camara", 1000);
        Product p2 = new Product("Mousrerer", 32);
        Product p3 = new Product("aewew", 12);
      return Arrays.asList(new Item(p1, 1), new Item(p2, 3), new Item(p3, 5));
    }
    
}
