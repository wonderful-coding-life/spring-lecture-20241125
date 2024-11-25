package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LombokTestApplication implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {

//        Product product = new Product();
//        product.setDescription("1등급 냉장고");
//        product.setPrice(1000000L);
//        System.out.println("product = " + product);

        Product product = Product.builder().name("김치냉장고").price(10000000L).build();
        for (int i = 0; i < 100; i++) {
            log.trace("trace...");
            log.debug("debug...");
            log.info("info... product = {}", product);
            log.warn("warn...");
            log.error("error...");
        }

        //System.out.println("product = " + product);
    }
}
