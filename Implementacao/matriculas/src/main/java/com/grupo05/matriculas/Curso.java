package com.grupo05.matriculas;

import java.io.Serializable;
import java.util.ArrayList;

public class Curso implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
    public String nome;

    public Curso() {
    }
    public Curso(String nome) {
        this.nome = nome;
    }

    

}
