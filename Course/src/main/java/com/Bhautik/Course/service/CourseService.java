package com.Bhautik.Course.service;

import com.Bhautik.Course.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

     Integer create(Course course);

     List<Course> findAll();

     Optional<Course> findById(Integer id);

    void deleteCourse(Integer id);

    List<String> courseNamesFromIds(List<Integer> ids);
}
