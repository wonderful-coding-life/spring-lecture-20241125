package com.example.demo;

import lombok.*;

@Data
@Builder
public class Product {
    private String name;
    private String description;
    private Long price;
}
