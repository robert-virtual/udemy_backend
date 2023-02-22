package com.example.udemy_backend.service;

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

    public Student addCourseToStudent(StudentCourse body) {
         return studentRepo.findById(body.getStudent_id()).map(student -> {
             Course course = courseRepo.findById(body.getCourse_id()).orElseThrow();
             student.addCourse(course);
             return studentRepo.save(student);
         }).orElseThrow();

    }

    public Iterable<Course> getStudentCourses(long student_id) {
        return studentRepo.findById(student_id).orElseThrow().getCourses();
    }
}
