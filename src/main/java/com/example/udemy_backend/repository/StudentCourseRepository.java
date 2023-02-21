package com.example.udemy_backend.repository;


import com.example.udemy_backend.model.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCourseRepository extends JpaRepository<StudentCourse,Long> {
}
