package com.victorecmonteiro.attendease.login;

import org.antlr.v4.runtime.misc.NotNull;

public class LoginDTO {

    @NotNull
    private String senha;
    @NotNull
    private String funcao;
    @NotNull
    private String username;

    public LoginDTO(String senha, String funcao, String username) {
        this.senha = senha;
        this.funcao = funcao;
        this.username = username
        ;
    }

    public String getSenha() {
        return senha;
    }

    public String getFuncao() {
        return funcao;
    }

    public String getUsername() {
        return username;
    }
}
