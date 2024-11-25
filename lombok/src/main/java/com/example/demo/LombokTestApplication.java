package com.example.demo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class LombokTestApplication implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

//        Product product = new Product();
//        product.setDescription("1등급 냉장고");
//        product.setPrice(1000000L);
//        System.out.println("product = " + product);

        Product product = Product.builder().name("김치냉장고").price(10000000L).build();
        System.out.println("product = " + product);
    }
}
