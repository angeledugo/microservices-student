package com.microservises.student.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotaDto {

    private String name;

    @Column(name="teacher_id")
    private String teacherId;
    @Column(name="student_id")
    private String studentId;
    private Integer valor;
}
