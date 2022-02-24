package com.grupo05.matriculas;

public abstract class SecretariaFactory { //

    protected Pessoa pessoa;

    public abstract void criarPessoa();

    public Pessoa show(){
        return pessoa;
    }
}