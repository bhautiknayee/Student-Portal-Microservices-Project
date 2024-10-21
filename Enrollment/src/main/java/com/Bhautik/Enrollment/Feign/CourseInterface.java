package com.Bhautik.Enrollment.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("COURSE")
public interface CourseInterface {

    @GetMapping("/api/course/ids/{ids}")
    public List<String> courseNamesFromIds(@PathVariable List<Integer> ids);

}
