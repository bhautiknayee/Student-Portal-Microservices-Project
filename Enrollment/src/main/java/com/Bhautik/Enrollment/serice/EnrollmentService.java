package com.Bhautik.Enrollment.serice;

import com.Bhautik.Enrollment.dto.CourseDto;
import com.Bhautik.Enrollment.dto.dto.StudentDto;
import com.Bhautik.Enrollment.entity.Enrollment;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EnrollmentService {


    Integer enrollment(Enrollment enrollment);

    List<String> enrollmentListFromStudentId(Integer id);

    List<StudentDto> studentDetailsFromStudentIds(Integer courseId);
}
