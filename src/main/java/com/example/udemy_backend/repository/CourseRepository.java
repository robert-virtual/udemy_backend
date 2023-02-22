package com.example.udemy_backend.repository;

import com.example.udemy_backend.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course,Long> {
}
