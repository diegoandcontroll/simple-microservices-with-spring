package br.com.diegoandcontroll.school;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.diegoandcontroll.school.client.StudentClient;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolService {

  private final SchoolRepository repository;
  private final StudentClient client;

  public void save(School s) {
    repository.save(s);
  }

  public List<School> findAll() {
    return repository.findAll();
  }

  public IResponse findWithStudent(Integer id) {
    var school = repository.findById(id).orElseThrow(() -> new NotFoundException("School Not found"));
    var students = client.findAllStudentsBySchool(id);
    return IResponse.builder()
        .name(school.getName())
        .email(school.getEmail())
        .students(students)
        .build();
  }
}
