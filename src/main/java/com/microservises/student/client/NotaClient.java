package com.microservises.student.client;

import com.microservises.student.dto.NotaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-nota", url = "localhost:8000/api/nota")
public interface NotaClient {
    @GetMapping("/search-my-notas/{idStudent}")
    List<NotaDto> findAllNotaByStudent(@PathVariable Long idStudent);
}
