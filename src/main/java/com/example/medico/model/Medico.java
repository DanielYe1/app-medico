package com.example.medico.model;

import org.springframework.data.annotation.Id;
import java.io.Serializable;

public class Medico implements Serializable {
    @Id
    private String id;
    private String login;
    private String senha;
    private String nome;
    private String crm;
    private String especialidade;
    private String dataDeNascimento;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Medico(String login, String senha, String nome, String crm, String especialidade, String dataDeNascimento) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
        this.dataDeNascimento = dataDeNascimento;
    }

    public Medico(){}

     public Medico(String id) {
        this.id = id;
    }
}
