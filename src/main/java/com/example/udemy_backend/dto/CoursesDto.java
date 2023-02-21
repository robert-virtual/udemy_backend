package com.example.udemy_backend.dto;

import java.time.LocalDateTime;


public interface CoursesDto {

     long getId();
     String getName();
     String getPrice();

     String getDescription();

     String getDuration();
     LocalDateTime getCreated_at();
}
