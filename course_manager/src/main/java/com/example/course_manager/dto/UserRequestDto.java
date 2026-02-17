package com.example.course_manager.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserRequestDto {
    @NotEmpty
    @NotNull
    private String name;
    @NotEmpty
    @NotNull
    private String lastName;
}
