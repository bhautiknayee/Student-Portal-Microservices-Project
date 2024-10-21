package com.Bhautik.Enrollment.Feign;


import com.Bhautik.Enrollment.dto.dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("STUDENT")
public interface StudentInterface {

    @GetMapping("/api/student/getStudentsDetailFromIds/{ids}")
    public List<StudentDto> studentDetailsFromIds(@PathVariable List<Integer> ids);

}
