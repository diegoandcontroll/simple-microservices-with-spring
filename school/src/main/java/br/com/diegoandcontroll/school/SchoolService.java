package br.com.diegoandcontroll.school;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolService {
  
  private final SchoolRepository repository;

  public void save(School s){
    repository.save(s);
  }

  public List<School> findAll(){
    return repository.findAll();
  }
}
