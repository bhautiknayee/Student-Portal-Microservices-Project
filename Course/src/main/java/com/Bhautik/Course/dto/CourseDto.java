package com.Bhautik.Course.dto;

import lombok.Data;

import java.util.List;

@Data
public class CourseDto {

    private List<String> courseNames;

    public CourseDto(List<String> courseNames){
        this.courseNames = courseNames;
    }

}
