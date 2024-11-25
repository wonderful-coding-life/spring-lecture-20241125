package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Greeting {

    @PrintExecutionTime
    public String sayHello(String guest) {
        try {
            Thread.sleep((long) (Math.random() * 2000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "Hello " + guest;
    }
}
