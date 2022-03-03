package com.grupo05.matriculas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Professorx extends Pessoa implements Serializable {

    public String nome;
    public String codigoPessoa;
    public String login;
    public String senha;
    static Scanner scan = new Scanner(System.in);
    private static final long serialVersionUID = 1L;

    public Professorx(){
    }

    public Professorx(ArrayList<String> cadastro) {
        this.nome = cadastro.get(0);
        this.codigoPessoa = cadastro.get(1);
        this.senha = cadastro.get(2);
    }

    @Override
    public int verMenu() {
        int opcao;
        System.out.println("1 - Ver alunos matriculados por matéria");
        System.out.println("0 - Sair");
        opcao = scan.nextInt();
        return opcao;
    }

    @Override
    public void alterarSenha() {
        String novaSenha =  "";
        String senhaAtual = "";
        
        do{
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Insira sua senha atual: ");
            senhaAtual = scan.nextLine();
            if(!(senhaAtual == this.senha)){
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("Senha incorreta. Tente novamente");
            }
        }while(senhaAtual != this.senha);

        do{
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Digite sua nova senha: ");
            novaSenha = scan.nextLine();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Confirme a nova senha: ");
            if(novaSenha.equals(scan.nextLine())){
                this.senha = novaSenha;
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("Sua senha foi alterada com sucesso.");
                novaSenha = "OK";
            }
        }while(novaSenha.equals("OK"));
    }

    public void searchAlunosOPT(ArrayList<DisciplinaOptativa> DOPT, ArrayList<Alunx> alunos){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Escolha a disciplina: ");
        int count = 0;
        for (DisciplinaOptativa dis : DOPT) {
            System.out.println(count + " Nome: " + dis.nome);
            count ++;
        }
        int opcao = scan.nextInt();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        for (String nome : DOPT.get(opcao).alunosInscritos) {
            System.out.println("Nome: " + nome);
        }   
    }
    public void searchAlunosOBG(ArrayList<DisciplinaObrigatoria> DOBG, ArrayList<Alunx> alunos){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Escolha a disciplina: ");
        int count = 0;
        for (DisciplinaObrigatoria dis : DOBG) {
            System.out.println(count + " Nome: " + dis.nome);
            count ++;
        }
        int opcao = scan.nextInt();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        for (String nome : DOBG.get(opcao).alunosInscritos) {
            System.out.println("Nome: " + nome);
        }   
    }
}