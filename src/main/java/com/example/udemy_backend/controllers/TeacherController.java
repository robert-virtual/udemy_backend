package com.example.udemy_backend.controllers;

import com.example.udemy_backend.model.Course;
import com.example.udemy_backend.model.Teacher;
import com.example.udemy_backend.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    @GetMapping("/all")
    public Iterable<Teacher> all() {
        return teacherService.all();
    }

    @PostMapping("/create")
    public Teacher create(@RequestBody Teacher body){
        return teacherService.create(body);
    }
}
