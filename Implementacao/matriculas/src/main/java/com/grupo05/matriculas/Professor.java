package com.grupo05.matriculas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Professor extends Pessoa implements IFazerLogin, IMenu, Serializable{
    
    static Scanner scan = new Scanner(System.in);
    private static final long serialVersionUID = 1L;
    public List<Disciplina> disciplinas = new ArrayList<Disciplina>();
    public String login;
    public String senha;
    public String nome;
    
    public Professor(ArrayList<String> credenciais) {
        this.login = credenciais.get(1);
        this.senha = credenciais.get(2);
        this.nome = credenciais.get(0);
    }

    public Professor(Professor target){
    }

    @Override
    public Professor clone() {
        return new Professor(this);
    }

    @Override
    public boolean fazerLogin(Object object2) {
        return false;
    }

    
    
    public void selectAlunosByDisicplina(List<Disciplina> disciplinas){
    }

    @Override
    public int verMenu() {
        int opcao;
        System.out.println(CLEAR);
        System.out.println("1 - Ver alunos inscritos em uma oferta");
        System.out.println("2 - Alterar senha");
        System.out.println("3 - Sair");
        opcao = scan.nextInt();
        return opcao;
    }

    public void searchAlunosOBG(ArrayList<Obrigatoria> obrigatorias, ArrayList<Aluno> alunos) {
    }

    public void searchAlunosOPT(ArrayList<Optativa> optativas, ArrayList<Aluno> alunos) {
    }

    @Override
    public void alterarSenha() throws InterruptedException {
        String nova = "";
        String confirma = "";
        boolean validar = false;
        while(validar == false) {
            System.out.println(CLEAR + "Digite sua nova senha: ");
            nova = scan.next();
            System.out.println(CLEAR + "Confirme:");
            confirma = scan.next();
            validar = (nova.equals(confirma));
            if(!(validar)){
                System.out.println(CLEAR + "Senhas incompatíveis, tente novamente.");
                TimeUnit.SECONDS.sleep(2);
            }
        }
        this.senha = nova;
    }
    
}