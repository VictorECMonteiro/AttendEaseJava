package com.victorecmonteiro.attendease.turma;

import com.victorecmonteiro.attendease.disciplina.Disciplina;
import com.victorecmonteiro.attendease.turma.dto.TurmaCreateDTO;
import com.victorecmonteiro.attendease.turma.dto.TurmaSetDiscplinaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/turma")
@PreAuthorize("hasRole('Professor')")
public class TurmaController {
    @Autowired
    private TurmaService turmaService;

    @PreAuthorize("hasRole('Professor')")
    @PostMapping("/create")
    public ResponseEntity<Boolean>create(
            @RequestBody
            @Validated
            TurmaCreateDTO turma
    ){
        try{
            turmaService.create(turma);
            return ResponseEntity.status(200).body(true);
        }
        catch(Exception e){
            System.out.println(e);
            return ResponseEntity.status(400).body(false);
        }
    }
    @PostMapping("/setDisciplina")
    public ResponseEntity<Boolean> setDisciplina(
            @RequestBody
            @Validated
            TurmaSetDiscplinaDTO turmaSetDiscplinaDTO
    ){
        try{
            turmaService.setDisciplina(turmaSetDiscplinaDTO.idDiscplina, turmaSetDiscplinaDTO.idDiscplina);
            return ResponseEntity.status(200).body(true);
        }
        catch(Exception e){
            return ResponseEntity.status(400).body(false);

        }


    }

}
