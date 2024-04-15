package com.microservises.student.service;

import com.microservises.student.client.NotaClient;
import com.microservises.student.dto.NotaDto;
import com.microservises.student.entities.Student;
import com.microservises.student.http.response.NotaByStudentResponse;
import com.microservises.student.persistence.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private NotaClient notaClient;


    @Override
    public List<Student> findAll() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student update(Student student, Long id) {
        Student updateStudent = studentRepository.findById(id).orElse(new Student());
        updateStudent.setName(student.getName());
        updateStudent.setLastName(student.getLastName());
        updateStudent.setEmail(student.getEmail());
        return studentRepository.save(updateStudent);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public NotaByStudentResponse findNotaByStudent(Long idStudent) {
        // Consultar el estudiante

        Student student = studentRepository.findById(idStudent).orElse(new Student());

        // Obtener las notas

        List<NotaDto> notaDtoList = notaClient.findAllNotaByStudent(idStudent);

        return NotaByStudentResponse.builder()
                .student(student.getName())
                .notaDtoList(notaDtoList)
                .build();

    }
}
