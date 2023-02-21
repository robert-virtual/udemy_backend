package com.example.udemy_backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private LocalDateTime created_at = LocalDateTime.now();

//    @OneToMany(mappedBy = "teacher",fetch = FetchType.LAZY)
//    private List<Course> courses = new ArrayList<>();
}
