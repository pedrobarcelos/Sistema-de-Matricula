package com.grupo05.matriculas;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa {
    
    public List<Disciplina> disciplinas = new ArrayList<Disciplina>();

    public Professor() {
        // TODO Auto-generated method stub
    }

    public Professor(Professor target){
        // TODO Auto-generated method stub
    }

    @Override
    public Professor clone() {
        // TODO Auto-generated method stub
        return new Professor(this);
    }

    @Override
    public boolean fazerLogin(Object object2) {
        // TODO Auto-generated method stub
        return false;
    }
    
    public void selectAlunosByDisicplina(List<Disciplina> disciplinas){
        // TODO Auto-generated method stub
    }
}