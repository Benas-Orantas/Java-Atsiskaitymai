package com.example.course_manager.service;

import com.example.course_manager.dto.CourseRequestDto;
import com.example.course_manager.dto.CourseResponseDto;
import com.example.course_manager.entity.Course;
import com.example.course_manager.exception.CourseNotFoundException;
import com.example.course_manager.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courses;

    public CourseServiceImpl(CourseRepository courses) {
        this.courses = courses;
    }

    @Override
    public CourseResponseDto addCourse(CourseRequestDto course) {
        Course course1 = courses.save(toEntity(course));
        return toResponseDto(course1);
    }

    @Override
    public List<CourseResponseDto> getCourses() {
        return courses.findAll().stream().map(this::toResponseDto).toList();
    }

    @Override
    public CourseResponseDto getCourseById(Long courseId) {
        return toResponseDto(courses.findById(courseId).orElseThrow(() -> new CourseNotFoundException("Course with id of " + courseId + " does not exist")));
    }

    @Override
    public CourseResponseDto updateCourse(Long courseId, CourseRequestDto course) {
        if (!courses.existsById(courseId)) throw new CourseNotFoundException("Course with id of " + courseId + " does not exist");
        Course updated = toEntity(course);
        updated.setId(courseId);
        courses.save(updated);
        return toResponseDto(updated);
    }

    @Override
    public void removeCourse(Long courseId) {
        if (!courses.existsById(courseId)) throw new CourseNotFoundException("Course with id of " + courseId + " does not exist");
        courses.deleteById(courseId);
    }

    public Course toEntity(CourseRequestDto course) {
        return new Course(course.getName(), course.getDescription(), course.getType(), course.getStartDate(), course.getEndDate());
    }

    public CourseResponseDto toResponseDto(Course course) {
        return new CourseResponseDto(course.getId(), course.getName(), course.getDescription(), course.getType(), course.getStartDate(), course.getEndDate());
    }
}
