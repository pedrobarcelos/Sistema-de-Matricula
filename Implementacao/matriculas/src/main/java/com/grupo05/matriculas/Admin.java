package com.grupo05.matriculas;

public class Admin extends Pessoa implements IFazerLogin{
    
    public Admin() {
        // TODO Auto-generated method stub
    }

    public Admin(Admin target) {
        // TODO Auto-generated method stub
        super(target);
    }

    @Override
    public Admin clone() {
        // TODO Auto-generated method stub
        return new Admin(this);
    }

    @Override
    public boolean fazerLogin(Object object2) {
        // TODO Auto-generated method stub
        return false;
    }

    public Pessoa createAluno(){
        // TODO Auto-generated method stub
        return null;
    }

    public Pessoa createProf(){
        // TODO Auto-generated method stub
        return null;
    }

    public Pessoa createAdmin(){
        // TODO Auto-generated method stub
        return null;
    }

    public Pessoa createCobranca(){
        // TODO Auto-generated method stub
        return null;
    }

    public Disciplina createDisciplina(){
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean alterarSenha() {
        // TODO Auto-generated method stub
        return false;
    }
}
