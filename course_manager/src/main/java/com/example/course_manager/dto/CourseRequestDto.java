package com.example.course_manager.dto;

import com.example.course_manager.enums.CourseType;
import com.example.course_manager.exception.InvalidDateException;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
public class CourseRequestDto {
    @NotEmpty
    @NotNull
    private String name;
    @NotEmpty
    @NotNull
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CourseType type;
    private LocalDate startDate;
    private LocalDate endDate;

    public CourseRequestDto(String name, String description, CourseType type, String startDate, String endDate) {
        this.name = name;
        this.description = description;
        this.type = type;
        if(startDate == null) throw new InvalidDateException("Start Date cannot be null");
        if(endDate == null) throw new InvalidDateException("End Date cannot be null");
        if(startDate.trim().isEmpty()) throw new InvalidDateException("Start date cannot be empty");
        if(endDate.trim().isEmpty()) throw new InvalidDateException("End Date cannot be empty");
        this.startDate = LocalDate.parse(startDate);
        this.endDate = LocalDate.parse(endDate);
        if(this.startDate.equals(this.endDate) || this.startDate.isAfter(this.endDate) || this.startDate.equals(LocalDate.now())) throw new InvalidDateException("Start Date has to be in the future and before the End Date");
        if(this.endDate.isBefore(this.startDate)) throw new InvalidDateException("End Date must come after start date");
    }
}
