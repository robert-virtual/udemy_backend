package com.example.udemy_backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private LocalDateTime created_at = LocalDateTime.now();

//    @ManyToMany(mappedBy = "students",fetch = FetchType.LAZY)
//    private List<Course> courses = new ArrayList<>();
//
//    public void addCourse(Course course){
//        courses.add(course);
//    }

}
