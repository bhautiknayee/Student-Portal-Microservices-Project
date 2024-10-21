package com.Bhautik.Enrollment.repository;

import com.Bhautik.Enrollment.entity.Enrollment;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Integer> {

    @Query("SELECT e.courseId FROM Enrollment e WHERE e.studentId = :studentId")
    List<Integer> findCourseIdByStudentId(@Param("studentId") Integer studentId);

    @Query("SELECT e.studentId FROM Enrollment e WHERE e.courseId = :courseId")
    List<Integer> findStudentIdByCourseId(@Param("courseId") Integer courseId);

}
