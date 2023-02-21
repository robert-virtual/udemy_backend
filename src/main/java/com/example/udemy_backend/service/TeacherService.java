package com.example.udemy_backend.service;

import com.example.udemy_backend.model.Teacher;
import com.example.udemy_backend.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepo;
    public Iterable<Teacher> all(){
        return teacherRepo.findAll();
    }

    public Teacher create(Teacher body) {
        return teacherRepo.save(body);
    }
}
