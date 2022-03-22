package com.grupo05.matriculas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Cobranca extends Pessoa implements IFazerLogin, IMenu,Serializable{
    
    public List<Pessoa> alunos = new ArrayList<Pessoa>();
    private static final long serialVersionUID = 1L;
    static Scanner scan = new Scanner(System.in);

    public String login;
    public String senha;
    public String nome;

    public Cobranca(ArrayList<String> credenciais) {
        this.login = credenciais.get(1);
        this.senha = credenciais.get(2);
        this.nome = credenciais.get(0);
    }

    public Cobranca(Cobranca target){
    }

    @Override
    public Cobranca clone() {
        return new Cobranca(this);
    }

    @Override
    public boolean fazerLogin(Object object2) {
        return false;
    }

   
    
    public void cobrarAluno(ArrayList<Aluno> alunos2) throws InterruptedException{
            String descricao = "";
                System.out.println(CLEAR + "Escolha um aluno: ");
                int opcao = 999999;
                int iterator = 0;
                for(Aluno aluno : alunos2){
                    System.out.println(iterator + " - " + aluno.nome);
                    iterator ++;
                }
                
                while(opcao > alunos2.size()){
                    opcao = scan.nextInt();
                    iterator = 0;
                    if(opcao > alunos.size()){
                        System.out.println(CLEAR + "Opcão inválida. Tente novamente.");
                        for(Aluno aluno : alunos2){
                            System.out.println(iterator + " - " + aluno.nome);
                            iterator ++;
                        }
                    }
                }

                System.out.println(CLEAR + "Insira a descricao da cobranca:");
                descricao = scan.nextLine();
                Solicitacao solicitacao = new Solicitacao(this,alunos2.get(opcao),descricao);
                alunos2.get(opcao).solicitacoes.add(solicitacao);
                System.out.println(CLEAR+"Solicitacão enviada.");  
                TimeUnit.SECONDS.sleep(2);      
    }

    @Override
    public int verMenu() {
        int opcao;
        System.out.println(CLEAR);
        System.out.println("1 - Cobrar aluno");
        System.out.println("2 - Alterar senha");
        System.out.println("3 - Sair");
        opcao = scan.nextInt();
        return opcao;
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