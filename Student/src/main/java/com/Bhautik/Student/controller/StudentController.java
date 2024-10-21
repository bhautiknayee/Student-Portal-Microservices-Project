package com.Bhautik.Student.controller;


import com.Bhautik.Student.dto.StudentDto;
import com.Bhautik.Student.entity.Student;
import com.Bhautik.Student.serice.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<Integer> createStudent(@RequestBody Student student){
       return new ResponseEntity<>(this.studentService.createStudent(student), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Student>> findAll(){
        return new ResponseEntity<>(this.studentService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Student>> findById(@PathVariable Integer id){
        return new ResponseEntity<>(this.studentService.findById(id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id){
        this.studentService.deleteStudent(id);
        return  new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/getStudentsDetailFromIds/{ids}")
    public ResponseEntity<List<StudentDto>> getStudentsDetailFromIds(@PathVariable List<Integer> ids){
        return new ResponseEntity<>(this.studentService.getStudentsDetailFromIds(ids),HttpStatus.OK);
    }


}
