package com.grupo05.matriculas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Pessoa implements Serializable{

    private static final long serialVersionUID = 1L;
	public String login = "admin";
    public String senha = "admin";

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin [login=" + login + ", senha=" + senha + "]";
    }

    @Override
    public int verMenu() {
        Scanner scan = new Scanner(System.in);
        int opcao;
        System.out.println(
                        "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("1 - Cadastrar aluno");
        System.out.println("2 - Cadastrar professor");
        System.out.println("3 - Cadastrar disciplina obrigatoria");
        System.out.println("4 - Cadastrar disciplina optativa");
        System.out.println("5 - Cadastrar Curso");
        System.out.println("6 - Alterar senha");
        System.out.println("7 - Sair");
        opcao = scan.nextInt();
        return opcao;
    }



    @Override
    public void alterarSenha() {
        String novaSenha =  "";
        String senhaAtual = "";
        
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Insira sua senha atual: ");
            senhaAtual = scan.nextLine();
            if(!(senhaAtual.equals(this.senha))){
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("Senha incorreta. Tente novamente");
            }
        }while(!(senhaAtual.equals(this.senha)));

        do{
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Digite sua nova senha: ");
            novaSenha = scan.nextLine();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Confirme a nova senha: ");
            String temp = scan.nextLine();
            if(novaSenha.equals(temp)){
                this.senha = novaSenha;
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("Sua senha foi alterada com sucesso.");
                novaSenha = "OK";
            }
        }while(!(novaSenha.equals("OK")));

    }

    public void cadastrarAluno(ArrayList<Alunx> alunos){
        FactoryPessoa secretaria = new FactoryAlunx();
        secretaria.criarPessoa();
        alunos.add((Alunx) secretaria.show());
    }

    public void cadastrarProfessor(ArrayList<Professorx> professores){
        FactoryPessoa secretaria = new FactoryProfessorx();
        secretaria.criarPessoa();
        professores.add((Professorx) secretaria.show());
    }

    public void cadastrarDisciplinaOBG(ArrayList<DisciplinaObrigatoria> disciplinasObrigatorias){ 
        FactoryDisciplina disci = new FactoryDObrigatoria();
        disci.criarDisciplina();
        disciplinasObrigatorias.add((DisciplinaObrigatoria) disci.show());
    }

    public void cadastrarDisciplinaOPT(ArrayList<DisciplinaOptativa> disciplinasOptativas){
        FactoryDisciplina disci = new FactoryDOptativa();
        disci.criarDisciplina();
        disciplinasOptativas.add((DisciplinaOptativa) disci.show());

    }

    public void cadastrarCurso(ArrayList<Curso> cursos){
        Curso BOOT = new Curso();
        cursos.add(BOOT);
    }
}
