package com.example.udemy_backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String price;

    private String description;

    private String duration;
    @ManyToOne
    @JoinColumn(name = "teacher_id",referencedColumnName = "id")
    private Teacher teacher;

//    @ManyToMany
//    @JoinTable(
//            name = "students_courses",
//           joinColumns = @JoinColumn(name = "course_id",referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "student_id",referencedColumnName = "id")
//    )
//    private List<Student> students = new ArrayList<>();

//    public void addStudent(Student student){
//        this.students.add(student);
//    }
    private LocalDateTime created_at = LocalDateTime.now();
}
