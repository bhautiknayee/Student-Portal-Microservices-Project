package com.Bhautik.Course.service.serviceImpl;

import com.Bhautik.Course.entity.Course;
import com.Bhautik.Course.repository.CourseRepository;
import com.Bhautik.Course.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public Integer create(Course course) {
        return this.courseRepository.save(course).getId();
    }

    @Override
    public List<Course> findAll() {
       return this.courseRepository.findAll();
    }

    @Override
    public Optional<Course> findById(Integer id) {
       return this.courseRepository.findById(id);
    }

    @Override
    public void deleteCourse(Integer id) {
         this.courseRepository.deleteById(id);
    }

    @Override
    public List<String> courseNamesFromIds(List<Integer> ids) {
       List<String> courseDto = new ArrayList<>();

       for(int i=0;i<ids.size();i++){
           Optional<Course> course =  this.findById(ids.get(i));
           courseDto.add(course.get().getCourseName());
       }
             return  courseDto;
    }
}
