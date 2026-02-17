package com.example.course_manager.service;

import com.example.course_manager.dto.CourseRequestDto;
import com.example.course_manager.dto.CourseResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseService {
    public CourseResponseDto addCourse(CourseRequestDto course);
    public List<CourseResponseDto> getCourses();
    public CourseResponseDto getCourseById(Long courseId);
    public CourseResponseDto updateCourse(Long courseId, CourseRequestDto course);
    public void removeCourse(Long courseId);
}
