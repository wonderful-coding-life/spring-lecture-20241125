package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WatchTester {
    @Autowired
    private List<Watch> watches;

    @PostConstruct
    public void run() {
        for (Watch watch : watches) {
            System.out.println("getDate() returns " + watch.getDate());
            System.out.println("getTime() returns " + watch.getTime());
        }
    }
}
