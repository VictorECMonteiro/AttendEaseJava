package com.victorecmonteiro.attendease.turma;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends CrudRepository<Turma, Integer>{


    Turma getTurmasByIdTurma(Integer idTurma);
}
