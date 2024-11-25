package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class AopTestApplication implements ApplicationRunner {
    @Autowired
    private Greeting greeting;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        greeting.sayHello("Spiderman");
    }
}
