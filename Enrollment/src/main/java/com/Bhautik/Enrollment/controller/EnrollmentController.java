package com.Bhautik.Enrollment.controller;

import com.Bhautik.Enrollment.dto.CourseDto;
import com.Bhautik.Enrollment.dto.dto.StudentDto;
import com.Bhautik.Enrollment.entity.Enrollment;
import com.Bhautik.Enrollment.serice.EnrollmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollment")
@AllArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping("/create")
    public ResponseEntity<Integer> enrollment(@RequestBody Enrollment enrollment){
        return  new ResponseEntity<>(this.enrollmentService.enrollment(enrollment), HttpStatus.OK);
    }

    /*
    GET /enrollment/student/{studentId}: View courses a student is enrolled in.
    Response: Returns a list of enrollments for the specified student.
     */

    @GetMapping("course/{studentId}")
    public ResponseEntity<List<String>> enrollmentListFromStudentId(@PathVariable Integer studentId){

        return  new ResponseEntity<>(this.enrollmentService.enrollmentListFromStudentId(studentId), HttpStatus.OK);

    }

    /*
    GET /enrollments/course/{courseId}: View students enrolled in a course.
    Response: Returns a list of enrollments for the specified course.
     */

    @GetMapping("student/{courseId}")
    public ResponseEntity<List<StudentDto>> studentDetailsFromStudentIds(@PathVariable Integer courseId){
        return new ResponseEntity<>(this.enrollmentService.studentDetailsFromStudentIds(courseId),HttpStatus.OK);
    }

}
