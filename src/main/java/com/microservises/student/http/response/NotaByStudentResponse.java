package com.microservises.student.http.response;

import com.microservises.student.dto.NotaDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.cert.CertPathBuilder;
import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotaByStudentResponse {
    private String student;
    private List<NotaDto> notaDtoList;


}
