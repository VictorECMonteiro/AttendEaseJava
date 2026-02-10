package com.victorecmonteiro.attendease.disciplina;

import com.victorecmonteiro.attendease.disciplina.dto.DisciplinaCreateDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {



    @PostMapping
    public ResponseEntity<Boolean>create(
            @RequestBody
            @Validated
            DisciplinaCreateDTO disciplinaCreateDTO

    ){




    }









}
