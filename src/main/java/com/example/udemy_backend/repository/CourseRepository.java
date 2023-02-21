package com.example.udemy_backend.repository;

import com.example.udemy_backend.dto.CoursesDto;
import com.example.udemy_backend.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {
    @Query(
            value = "select C.* from course C inner join students_courses SC on C.id = SC.course_id where SC.student_id = :student_id",
            nativeQuery = true
    )
    List<CoursesDto> getCourses(long student_id);
}
