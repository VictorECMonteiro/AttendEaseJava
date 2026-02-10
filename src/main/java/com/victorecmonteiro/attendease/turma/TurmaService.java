package com.victorecmonteiro.attendease.turma;

import com.victorecmonteiro.attendease.disciplina.Disciplina;
import com.victorecmonteiro.attendease.disciplina.DisciplinaRepository;
import com.victorecmonteiro.attendease.turma.dto.TurmaCreateDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurmaService {


    @Autowired
    private TurmaRepository turmaRepository;
    @Autowired
    private DisciplinaRepository disciplinaRepository;



    public boolean create(TurmaCreateDTO turma){
        try{
            Turma turmaCreate = new Turma();
            turmaCreate.setNomeTurma(turma.getNomeTurma());
            turmaRepository.save(turmaCreate);
            return true;
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }






    }

    @Transactional
    public void setDisciplina(Integer idDisciplina, Integer idTurma) {
        Disciplina disciplina = disciplinaRepository.getDisciplinaByIdDisciplina(idDisciplina);
        Turma turma = turmaRepository.getTurmasByIdTurma(idTurma);
        turma.getDisciplinas().add(disciplina);
    }
}
