package com.victorecmonteiro.attendease.frequencia;

import com.victorecmonteiro.attendease.turma.Turma;
import com.victorecmonteiro.attendease.user.Usuario;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="frequencia")
public class Frequencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFrequencia;
    private Date dataEntrada;
    private Date dataSaida;

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Integer getIdFrequencia() {
        return idFrequencia;
    }

    public void setIdFrequencia(Integer idFrequencia) {
        this.idFrequencia = idFrequencia;
    }

    @OneToOne
    @JoinColumn(name="idUsuario")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "idTurma")
    private Turma turma;






}
