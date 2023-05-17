package br.com.diegoandcontroll.student;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
public class StudentController {
  private final StudentService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void save(@RequestBody Student data){
    service.save(data);
  }

  @GetMapping
  public ResponseEntity<List<Student>> findAll(){
    return ResponseEntity.ok(service.findAll());
  }
  @GetMapping("/school/{schoolId}")
  public ResponseEntity<List<Student>> findWithSchool(@PathVariable("schoolId") Integer schoolId){
    return ResponseEntity.ok(service.findWithSchool(schoolId));
  }

 
}
