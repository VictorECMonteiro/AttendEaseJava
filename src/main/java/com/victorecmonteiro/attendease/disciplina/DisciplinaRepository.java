package com.victorecmonteiro.attendease.disciplina;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends CrudRepository<Disciplina, Integer> {
    Disciplina getDisciplinaByIdDisciplina(Integer idDisciplina);
}
