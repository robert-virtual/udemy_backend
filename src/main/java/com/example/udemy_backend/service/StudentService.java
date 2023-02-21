package com.example.udemy_backend.service;

import com.example.udemy_backend.dto.CoursesDto;
import com.example.udemy_backend.model.Course;
import com.example.udemy_backend.model.Student;
import com.example.udemy_backend.model.StudentCourse;
import com.example.udemy_backend.repository.CourseRepository;
import com.example.udemy_backend.repository.StudentCourseRepository;
import com.example.udemy_backend.repository.StudentRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepo;
    private final EntityManager entityManager;
    private final StudentCourseRepository studentCourseRepo;
    private final CourseRepository courseRepo;
    public Iterable<Student> all(){
        return studentRepo.findAll();
    }

    public Student create(Student body) {
        return studentRepo.save(body);
    }

    public Course addCourse(StudentCourse body) {
        // TODO: add course to student

//         return courseRepo.findById(body.getCourse_id()).map(course->{
//                    course.addStudent(studentRepo.findById(body.getStudent_id()).orElseThrow());
//                    return course;
//        }).orElseThrow();
        // entityManager.find()
        Course course = entityManager.find(Course.class,body.getCourse_id());
        Student student = entityManager.find(Student.class,body.getStudent_id());
        course.addStudent(student);
        entityManager.persist(course);
        return course;
    }

    public Iterable<CoursesDto> getCourses(long student_id) {
        // Student student = studentRepo.findById(id).orElseThrow();
        Iterable<CoursesDto> res = courseRepo.getCourses(student_id);
        return res;
    }
}
