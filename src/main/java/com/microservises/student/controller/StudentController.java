package com.microservises.student.controller;

import com.microservises.student.entities.Student;
import com.microservises.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;



    @GetMapping("/all")
    public ResponseEntity<?> listStudent() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(studentService.findById(id));

    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student) {
        studentService.save(student);
    }

    @GetMapping("/search-my-notas/{idStudent}")
    public ResponseEntity<?> findByIdStudent(@PathVariable Long idStudent) {
        return ResponseEntity.ok(studentService.findNotaByStudent(idStudent));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        Student existingStudent = this.studentService.findById(id);

        studentService.delete(existingStudent.getId());

    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id,@RequestBody Student student) {
        return studentService.update(student, id);
    }




}
