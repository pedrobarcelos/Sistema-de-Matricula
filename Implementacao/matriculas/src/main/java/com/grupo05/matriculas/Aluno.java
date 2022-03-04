package com.grupo05.matriculas;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa implements IFazerLogin{
    
    public List<Disciplina> disciplinas = new ArrayList<Disciplina>();

    public Aluno() {
        // TODO Auto-generated method stub
    }

    public Aluno(Aluno target) {
        // TODO Auto-generated method stub
        super(target);
    }

    @Override
    public Aluno clone() {
        // TODO Auto-generated method stub
        return new Aluno(this);
    }

    @Override
    public boolean fazerLogin(Object object2) {
        // TODO Auto-generated method stub
        return false;
    }

    public void verDisicplinasAtivas(){
        // TODO Auto-generated method stub
    }

    public void fazerMatricula(List<Disciplina> disciplinas){
        // TODO Auto-generated method stub
    }

    public void inscreverEmDisciplina(List<Disciplina> disciplinas){
        // TODO Auto-generated method stub
    }
    
    @Override
    public boolean alterarSenha() {
        // TODO Auto-generated method stub
        return false;
    }
}