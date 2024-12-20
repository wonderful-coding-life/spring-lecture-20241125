package com.example.jpa.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
//@Table(name="member")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(name="name")
    private String name;
    private String email;
    private Integer age;

    @OneToMany(mappedBy = "member")
    @ToString.Exclude
    //@JsonIgnore
    private List<Article> articles;
}
