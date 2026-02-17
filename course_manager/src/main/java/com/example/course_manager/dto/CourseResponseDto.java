package com.example.course_manager.dto;

import com.example.course_manager.enums.CourseType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CourseResponseDto {
    private Long id;
    private String name;
    private String description;
    private CourseType type;
    private LocalDate startDate;
    private LocalDate endDate;
}
