package com.Bhautik.Student.serice.serviceImplement;

import com.Bhautik.Student.dto.StudentDto;
import com.Bhautik.Student.entity.Student;
import com.Bhautik.Student.repository.StudentRepository;
import com.Bhautik.Student.serice.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImplement  implements StudentService {

   private final StudentRepository studentRepository;

    @Override
    public Integer createStudent(Student student) {
        Student studentObj =  this.studentRepository.save(student);
        return studentObj.getId();
    }

    @Override
    public List<Student> findAll() {
       List<Student> students = this.studentRepository.findAll();
       return students;
    }

    @Override
    public Optional<Student> findById(Integer id) {
       Optional<Student> student = this.studentRepository.findById(id);
       return student;
    }

    @Override
    public void deleteStudent(Integer id) {
       this.studentRepository.deleteById(id);
    }

    @Override
    public List<StudentDto> getStudentsDetailFromIds(List<Integer> ids) {
       List<StudentDto> studentDtos = new ArrayList<>();
       System.out.println("IDS OF STUDENTS ARE " + ids);
        for(int i=0;i<ids.size();i++){
        System.out.println("PARTICULAR STUDENT ID IS  " + ids.get(i));
         Optional<Student> student = this.studentRepository.findById(ids.get(i));
            StudentDto studentDto = new StudentDto(student.get().getFirstName(), student.get().getLastName());
         studentDtos.add(studentDto);

        }
      return studentDtos;

    }
}
