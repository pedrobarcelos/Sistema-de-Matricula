package com.grupo05.matriculas;

import java.util.ArrayList;
import java.util.List;

public abstract class Disciplina {

    public int codigo;
    public String nome;
    public List<Pessoa> alunosInscritos = new ArrayList<Pessoa>();

    public Disciplina() {
        // TODO Auto-generated method stub
    }

    public Disciplina(Disciplina target) {
        // TODO Auto-generated method stub
    }

    public abstract Disciplina clone();

    public boolean fazerLogin(Object object2) {
        // TODO Auto-generated method stub
        return false;
    }
}