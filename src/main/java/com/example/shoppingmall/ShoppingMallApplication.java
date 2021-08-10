package com.example.shoppingmall;

import com.example.shoppingmall.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShoppingMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingMallApplication.class, args);
    }
//    @Bean
//    CommandLineRunner init(StorageService storageService) {
//        return (args -> {
//            storageService.init();
//        });
//    }
}
