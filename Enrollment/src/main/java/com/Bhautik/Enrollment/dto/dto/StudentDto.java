package com.Bhautik.Enrollment.dto.dto;

import lombok.Data;

@Data
public class StudentDto {

    private String firstName;
    private String lastName;

    public StudentDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
