package br.com.diegoandcontroll.student;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
  
  private final StudentRepository repository;

  public void save(Student s){
    repository.save(s);
  }

  public List<Student> findAll(){
    return repository.findAll();
  }
}
