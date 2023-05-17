package br.com.diegoandcontroll.school.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.diegoandcontroll.school.Student;

@FeignClient(name = "student-service", url = "${application.config.students-url}")
public interface StudentClient {
  
  @GetMapping("/school/{schoolId}")
  public List<Student> findAllStudentsBySchool(@PathVariable("schoolId") Integer schoolId);
}
