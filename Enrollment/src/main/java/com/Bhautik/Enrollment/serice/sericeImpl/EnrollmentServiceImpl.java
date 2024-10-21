package com.Bhautik.Enrollment.serice.sericeImpl;

import com.Bhautik.Enrollment.Feign.CourseInterface;
import com.Bhautik.Enrollment.Feign.StudentInterface;
import com.Bhautik.Enrollment.dto.dto.StudentDto;
import com.Bhautik.Enrollment.entity.Enrollment;
import com.Bhautik.Enrollment.repository.EnrollmentRepository;
import com.Bhautik.Enrollment.serice.EnrollmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    private final CourseInterface courseInterface;

    private final StudentInterface studentInterface;

    @Override
    public Integer enrollment(Enrollment enrollment) {
       return this.enrollmentRepository.save(enrollment).getId();
    }

    @Override
    public List<String> enrollmentListFromStudentId(Integer id) {
        System.out.println("studentId FROM SERVICE IS " + id);
        List<Integer> ids = this.enrollmentRepository.findCourseIdByStudentId(id);
        System.out.println("IDS OF COURSES ARE " + ids);
        System.out.println("COMEEEEEEEEEEEEEEEEEEEEE");

        List<String> courseNames = courseInterface.courseNamesFromIds(ids);
        return  courseNames;

    }

    @Override
    public List<StudentDto> studentDetailsFromStudentIds(Integer courseId) {
        System.out.println("studentId FROM SERVICE IS " + courseId);
        List<Integer> ids = this.enrollmentRepository.findStudentIdByCourseId(courseId);
        List<StudentDto> studentDto = this.studentInterface.studentDetailsFromIds(ids);
        return studentDto;
    }
}
