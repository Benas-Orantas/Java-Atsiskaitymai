package com.example.course_manager.controller;

import com.example.course_manager.dto.CourseRequestDto;
import com.example.course_manager.dto.CourseResponseDto;
import com.example.course_manager.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<CourseResponseDto> createCourse(@Valid @RequestBody CourseRequestDto course) {
        return new ResponseEntity(courseService.addCourse(course), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CourseResponseDto>> getCourses() {
        return ResponseEntity.ok(courseService.getCourses());
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseResponseDto> getCourseById(@PathVariable Long courseId) {
        return ResponseEntity.ok(courseService.getCourseById(courseId));
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<CourseResponseDto> updateCourse(@PathVariable Long courseId, @RequestBody CourseRequestDto course) {
        return ResponseEntity.ok(courseService.updateCourse(courseId, course));
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long courseId) {
        courseService.removeCourse(courseId);
        return ResponseEntity.noContent().build();
    }
}
