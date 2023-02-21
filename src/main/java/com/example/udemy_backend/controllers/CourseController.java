package com.example.udemy_backend.controllers;

import com.example.udemy_backend.model.Course;
import com.example.udemy_backend.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    @GetMapping("/all")
    public Iterable<Course> all(){
        return courseService.all();
    }
    @PostMapping("/create")
    public Course create(@RequestBody Course body){
        return courseService.create(body);
    }
}
