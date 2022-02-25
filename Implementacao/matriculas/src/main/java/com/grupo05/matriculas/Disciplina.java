package com.grupo05.matriculas;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Disciplina implements Serializable{

	private static final long serialVersionUID = 1L;
    public String nome;
    public ArrayList<Curso> cursos = new ArrayList<Curso>();
    public int cargaHoraria;
    public int periodo;
    

}