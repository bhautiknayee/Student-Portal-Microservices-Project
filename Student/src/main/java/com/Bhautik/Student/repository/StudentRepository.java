package com.Bhautik.Student.repository;

import com.Bhautik.Student.dto.StudentDto;
import com.Bhautik.Student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
