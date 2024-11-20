package com.adrian.springbootdi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.adrian.springbootdi.repositories.ProductRepository;
import com.adrian.springbootdi.repositories.ProductRepositoryJson;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Primary
    @Bean
     ProductRepository productRepositoryJson(){
        return new ProductRepositoryJson();
    }

    
}
