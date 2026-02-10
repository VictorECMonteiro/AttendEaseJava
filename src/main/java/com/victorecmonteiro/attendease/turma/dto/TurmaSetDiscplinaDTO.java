package com.victorecmonteiro.attendease.turma.dto;

public class TurmaSetDiscplinaDTO {
    public Integer idDiscplina;
    public Integer idTurma;

    public TurmaSetDiscplinaDTO(Integer idTurma, Integer idDiscplina) {
        this.idTurma = idTurma;
        this.idDiscplina = idDiscplina;
    }
}
