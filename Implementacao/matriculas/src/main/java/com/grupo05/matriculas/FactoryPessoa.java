package com.grupo05.matriculas;

public abstract class FactoryPessoa { //

    protected Pessoa pessoa;

    public abstract void criarPessoa();

    public Pessoa show(){
        return pessoa;
    }
}