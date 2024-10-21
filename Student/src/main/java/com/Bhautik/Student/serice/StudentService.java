package com.Bhautik.Student.serice;

import com.Bhautik.Student.dto.StudentDto;
import com.Bhautik.Student.entity.Student;

import java.util.List;
import java.util.Optional;


public interface StudentService {
   public Integer createStudent(Student student);

   public List<Student> findAll();

   public Optional<Student> findById(Integer id);

   void deleteStudent(Integer id);

    List<StudentDto> getStudentsDetailFromIds(List<Integer> ids);
}
