package com.grupo05.matriculas;

import java.io.Serializable;
import java.util.ArrayList;

public class DisciplinaOptativa extends Disciplina implements Serializable {
    private static final long serialVersionUID = 1L;

    public ArrayList<String> alunosInscritos = new ArrayList<String>();
    public String nome;
    public ArrayList<Curso> cursos = new ArrayList<Curso>();
    public int cargaHoraria;
    public int periodo;
     
    public DisciplinaOptativa(ArrayList<String> cadastro) {
        this.nome = cadastro.get(0);
        this.cargaHoraria = Integer.parseInt(cadastro.get(1));
        this.periodo = Integer.parseInt(cadastro.get(2));
    }

    public void inscreverAluno(String nome2) {
        if(alunosInscritos.size() < 60){
            alunosInscritos.add(nome2);
        }else{
            System.out.println("Matriculas encerradas para a disciplina " + this.nome + ".");
        }
    }
}
