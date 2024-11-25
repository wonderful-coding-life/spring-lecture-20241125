package com.example.demo;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

//@Component
public class AppleWatch implements Watch {
    public String getDate() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    public String getTime() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss"));
    }
}
