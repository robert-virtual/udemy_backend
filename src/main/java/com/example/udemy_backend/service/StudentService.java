package com.example.udemy_backend.service;

import com.example.udemy_backend.dto.CoursesDto;
import com.example.udemy_backend.model.Course;
import com.example.udemy_backend.model.Student;
import com.example.udemy_backend.model.StudentCourse;
import com.example.udemy_backend.repository.CourseRepository;
import com.example.udemy_backend.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;
    public Iterable<Student> all(){
        return studentRepo.findAll();
    }

    public Student create(Student body) {
        return studentRepo.save(body);
    }

    public Course addCourse(StudentCourse body) {
         return courseRepo.findById(body.getCourse_id()).map(course -> {
             course.setName(course.getName()+" (updated)");
             Student student = studentRepo.findById(body.getStudent_id()).orElseThrow();
             course.addStudent(student);
             return courseRepo.save(course);
         }).orElseThrow();

    }

    public Iterable<CoursesDto> getCourses(long student_id) {
        return courseRepo.getCourses(student_id);
    }
}
