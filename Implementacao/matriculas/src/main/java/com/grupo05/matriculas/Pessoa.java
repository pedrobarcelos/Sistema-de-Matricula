package com.grupo05.matriculas;

public abstract class Pessoa {

    public String login;
    public String senha;
    public String nome;

    public Pessoa() {
    }

    public Pessoa(Pessoa target) {
        this.login = target.login;
        this.senha = target.senha;
        this.nome = target.nome;
    }

    public abstract Pessoa clone();

}