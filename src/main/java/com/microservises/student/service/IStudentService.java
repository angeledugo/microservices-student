package com.microservises.student.service;

import com.microservises.student.entities.Student;
import com.microservises.student.http.response.NotaByStudentResponse;

import java.util.List;

public interface IStudentService {

    List<Student> findAll();
    Student findById(Long id);
    void save(Student student);
    Student update(Student student, Long id);
    void delete(Long id);

    NotaByStudentResponse findNotaByStudent(Long idStudent);
}
