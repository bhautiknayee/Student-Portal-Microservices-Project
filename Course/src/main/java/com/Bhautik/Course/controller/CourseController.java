package com.Bhautik.Course.controller;


import com.Bhautik.Course.dto.CourseDto;
import com.Bhautik.Course.entity.Course;
import com.Bhautik.Course.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/course")
public class CourseController {

     private final CourseService courseService;

    @PostMapping("/create")
    public ResponseEntity<Integer> createCourse(@RequestBody Course course){

          return  new ResponseEntity<>(this.courseService.create(course),HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Course>> findAll(){
        return new ResponseEntity<>(this.courseService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public  ResponseEntity<Optional<Course>> findById(@PathVariable Integer id){
         return new ResponseEntity<>(this.courseService.findById(id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Integer id){
        this.courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/ids/{ids}")
    public ResponseEntity<List<String>> courseNamesFromIds(@PathVariable List<Integer> ids){
        System.out.println("IDS----- "+ ids.toString());
       return new ResponseEntity<>(this.courseService.courseNamesFromIds(ids),HttpStatus.OK);
    }

}
