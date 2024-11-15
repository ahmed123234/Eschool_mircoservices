package com.ahmed.school.client;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ahmed.school.Student;

// stablishing a communication and make an http call to our distance api or third part api
@FeignClient(name="student-service", url="${application.config.students-url}")
public interface StudentClient {
    // it will have an automatic implentatioin by openfiegn
    @GetMapping("/school/{school-id}")
    List<Student> findAllStudentsBySchool(@PathVariable("school-id") Integer schoolId);
}
