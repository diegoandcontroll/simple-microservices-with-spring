package br.com.diegoandcontroll.school;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {
  private final SchoolService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void save(@RequestBody School data){
    service.save(data);
  }

  @GetMapping
  public ResponseEntity<List<School>> findAll(){
    return ResponseEntity.ok(service.findAll());
  }
}
