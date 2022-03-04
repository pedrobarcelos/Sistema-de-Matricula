package com.grupo05.matriculas;

import java.util.ArrayList;
import java.util.List;

public class Cobranca extends Pessoa {
    
    public List<Pessoa> alunos = new ArrayList<Pessoa>();

    public Cobranca() {
        // TODO Auto-generated method stub
    }

    public Cobranca(Cobranca target){
        // TODO Auto-generated method stub
    }

    @Override
    public Cobranca clone() {
        // TODO Auto-generated method stub
        return new Cobranca(this);
    }

    @Override
    public boolean fazerLogin(Object object2) {
        // TODO Auto-generated method stub
        return false;
    }
    
    public void cobrarAluno(Pessoa object){
        // TODO Auto-generated method stub
    }
}