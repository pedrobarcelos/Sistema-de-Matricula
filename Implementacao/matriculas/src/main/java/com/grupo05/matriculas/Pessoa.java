package com.grupo05.matriculas;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Pessoa implements IMenu{

	public String nome;
    public String codigoPessoa;
    public String login;
    public String senha;
    @Override
    public int verMenu() {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public void alterarSenha() {
        // TODO Auto-generated method stub
        
    }
    public void searchAlunos(ArrayList<Disciplina> disciplinas, ArrayList<Alunx> alunos) {
    }

}