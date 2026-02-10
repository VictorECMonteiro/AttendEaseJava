package com.victorecmonteiro.attendease.login;


import com.victorecmonteiro.attendease.user.Usuario;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
@Table(name = "login")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String senha;

    private String funcao;
    @Nullable
    private String token;

    public void setId(Integer id){
        this.id = id;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }



    @Nullable
    public String getToken() {
        return token;
    }

    public void setToken(@Nullable String token) {
        this.token = token;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId(){
        return id;
    }

    public String getSenha(){
        return senha;
    }

    @OneToOne(mappedBy = "login", cascade = CascadeType.ALL)
    private Usuario usuario;

}

