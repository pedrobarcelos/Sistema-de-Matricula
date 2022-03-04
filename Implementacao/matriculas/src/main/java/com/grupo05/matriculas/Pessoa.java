package com.grupo05.matriculas;

public abstract class Pessoa {

    public String login;
    public String senha;
    public String nome;

    public Pessoa() {
        // TODO Auto-generated method stub
    }

    public Pessoa(Pessoa target) {
        // TODO Auto-generated method stub
    }

    public abstract Pessoa clone();

    public boolean fazerLogin(Object object2) { //equals
        // TODO Auto-generated method stub
        return false;
    }
}