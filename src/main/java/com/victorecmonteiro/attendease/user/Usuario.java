package com.victorecmonteiro.attendease.user;

import com.victorecmonteiro.attendease.frequencia.Frequencia;
import com.victorecmonteiro.attendease.login.Login;
import com.victorecmonteiro.attendease.turma.Turma;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="user")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    private String nomeUsuario;
    private String sobrenomeUsuario;
    private Date dataNascimento;
    private boolean Status;

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSobrenomeUsuario() {
        return sobrenomeUsuario;
    }

    public void setSobrenomeUsuario(String sobrenomeUsuario) {
        this.sobrenomeUsuario = sobrenomeUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @ManyToOne
    @JoinColumn(name = "idTurma")
    private Turma turma;

    @OneToOne
    @JoinColumn(name = "idLogin")
    private Login login;

    @OneToOne(mappedBy = "usuario")
    private Frequencia frequencia;

    public void setLogin(Login login) {
        this.login = login;
    }

    public Usuario(String nomeUsuario, String sobrenomeUsuario, Date dataNascimento, boolean status) {
        this.nomeUsuario = nomeUsuario;
        this.sobrenomeUsuario = sobrenomeUsuario;
        this.dataNascimento = dataNascimento;
        Status = status;
    }
}
