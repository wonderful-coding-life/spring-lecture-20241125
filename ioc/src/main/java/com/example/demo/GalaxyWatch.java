package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class GalaxyWatch implements Watch {
    @Override
    public String getDate() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
    }
    @Override
    public String getTime() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("hh시 mm분 ss초"));
    }
}
