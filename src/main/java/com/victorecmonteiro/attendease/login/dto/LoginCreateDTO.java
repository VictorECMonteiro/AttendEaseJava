package com.victorecmonteiro.attendease.login.dto;

import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

public class LoginCreateDTO {
    @NotNull
    private String senha;
    @NotNull
    private String funcao;
    @NotNull
    private String username;
    @NotNull
    private String nomeUsuario;
    @NotNull
    private String sobrenomeUsuario;
    @NotNull
    private Date dataNascimento;
    @NotNull
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
