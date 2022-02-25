package com.grupo05.matriculas;

public abstract class FactoryDisciplina { //

    protected Disciplina disciplina;

    public abstract void criarDisciplina();

    public Disciplina show(){
        return disciplina;
    }
}