package com.example.udemy_backend.service;

import com.example.udemy_backend.model.Course;
import com.example.udemy_backend.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    public Iterable<Course> all(){
        return courseRepository.findAll();
    }

    public Course create(Course body) {
        return courseRepository.save(body);
    }
}
