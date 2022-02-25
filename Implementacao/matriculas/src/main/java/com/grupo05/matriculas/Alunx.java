package com.grupo05.matriculas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Alunx extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    public String nome;
    public String codigoPessoa;
    public String senha;
    static Scanner scan = new Scanner(System.in);
	public String turno;
    public String curso;
    public int periodo;
    public ArrayList<Disciplina> disciplinasInscrito = new ArrayList<Disciplina>();
    public ArrayList<DisciplinaObrigatoria> DObrigatoriasInscrito = new ArrayList<DisciplinaObrigatoria>();
    public ArrayList<DisciplinaOptativa> DOptativasInscrito = new ArrayList<DisciplinaOptativa>();

    public Alunx(ArrayList<String> cadastro) {
        this.nome = cadastro.get(0);
        this.codigoPessoa = cadastro.get(1);
        this.senha = cadastro.get(2);
        this.curso = cadastro.get(3);
        this.turno = cadastro.get(4);
        this.periodo = Integer.parseInt(cadastro.get(5));
    }

    @Override
    public int verMenu() {
        int opcao = 0;
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("1 - Fazer Matrícula");
        System.out.println("2 - Alterar senha");
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

    public void fazerMatricula(ArrayList<DisciplinaObrigatoria> obrigatorias, ArrayList<DisciplinaOptativa> optativas){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("1 - Inscrever-se em uma materia obrigatoria(max 4)");
        System.out.println("2 - Inscrever-se em uma materia obrigatoria(max 2)");
        int opcao = scan.nextInt();
        DisciplinaOptativa materiaOPT;
        DisciplinaObrigatoria materiaOBG;
        switch(opcao){
            case 1:
                materiaOPT = listarOptativas(optativas);
                if(DOptativasInscrito.size() < 4){
                    for (DisciplinaOptativa disciplinaOptativa : optativas) {
                        if(disciplinaOptativa.equals(materiaOPT)){
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            System.out.println("Você já se inscreveu para esta materia.");
                        }else{
                           DOptativasInscrito.add(materiaOPT); 
                           materiaOPT.inscreverAluno(this);
                        }
                    }
                }
                else{
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("Você já se inscreveu para o maximo de matérias optativas possíveis para o semestre.");
                }
            break;
            case 2:
                materiaOBG = listarObrigatorias(obrigatorias);
                if(DObrigatoriasInscrito.size() < 2){
                    for (DisciplinaObrigatoria disciplinaObrigatoria : obrigatorias) {
                        if(disciplinaObrigatoria.equals(materiaOBG)){
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            System.out.println("Você já se inscreveu para esta materia.");
                        }else{
                           DObrigatoriasInscrito.add(materiaOBG);
                           materiaOBG.inscreverAluno(this);
                        }
                    }
                }
                else{
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("Você já se inscreveu para o maximo de matérias obrigatorias possíveis para o semestre.");
                
                }
            break;
            default: 
            System.out.println("opcao invalida.");
        }

    }

    private DisciplinaObrigatoria listarObrigatorias(ArrayList<DisciplinaObrigatoria> obrigatorias) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        int index = 0;
        for (DisciplinaObrigatoria disciplinaObrigatoria : obrigatorias) {
            System.out.println(index + " - " + disciplinaObrigatoria.nome);
        }
        int opcao = scan.nextInt();
        return obrigatorias.get(opcao);
    }

    private DisciplinaOptativa listarOptativas(ArrayList<DisciplinaOptativa> optativas) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        int index = 0;
        for (DisciplinaOptativa disciplinaOptativa : optativas) {
            System.out.println(index + " - " + disciplinaOptativa.nome);
        }
        int opcao = scan.nextInt();
        return optativas.get(opcao);
    }

    @Override
    public String toString() {
        return "Alunx [curso=" + curso + ", periodo=" + periodo + ", turno=" + turno +  "nome=" + this.nome + "]";
    }

}