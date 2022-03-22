package com.grupo05.matriculas;

import java.util.ArrayList;
import java.util.List;

public abstract class Disciplina {

    public String codigo;
    public String nome;
    public String cargaHoraria;
    public List<Pessoa> alunosInscritos = new ArrayList<Pessoa>();

    public Disciplina() {
    }

    public Disciplina(Disciplina target) {
    }

    public abstract Disciplina clone();
}