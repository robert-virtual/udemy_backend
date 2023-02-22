package com.example.udemy_backend.controllers;

import com.example.udemy_backend.model.Course;
import com.example.udemy_backend.model.Student;
import com.example.udemy_backend.model.StudentCourse;
import com.example.udemy_backend.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    @GetMapping("/all")
    public Iterable<Student> all(){
        return studentService.all();
    }
    @PostMapping("/create")
    public Student create(@RequestBody Student body){
        return studentService.create(body);
    }
    @GetMapping("/{student_id}/course")
    public Iterable<Course> getCourse(@PathVariable long student_id){
        return studentService.getStudentCourses(student_id);
    }
    @PostMapping("/course")
    public Student addCourse(@RequestBody StudentCourse body){
         return studentService.addCourseToStudent(body);
    }
}
