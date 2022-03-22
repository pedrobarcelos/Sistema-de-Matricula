package com.grupo05.matriculas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Aluno extends Pessoa implements IFazerLogin, IMenu, Serializable{

    public String login;
    public String senha;
    public String nome;
    static Scanner scan = new Scanner(System.in);
    public Matricula matricula = new Matricula();
    public ArrayList<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
    private static final long serialVersionUID = 1L;

    public Aluno(ArrayList<String> credenciais) {
        this.login = credenciais.get(1);
        this.senha = credenciais.get(2);
        this.nome = credenciais.get(0);
    }

    public Aluno(Aluno target) {
        super(target);
    }

    @Override
    public Aluno clone() {
        return new Aluno(this);
    }

    @Override
    public boolean fazerLogin(Object object2) {
        return false;
    }

    public void verDisicplinasAtivas(){
    }

    public void fazerMatricula(List<String> ofertas) throws InterruptedException{
        if(ofertas.size() > 0){    
            boolean acabou = false;
            ArrayList<String> escolhas = new ArrayList<String>();
            while(acabou == false){
                System.out.println(CLEAR + "Escolha uma disciplina: ");
                int opcao = 999999;
                int iterator = 0;
                for(String o : ofertas){
                    System.out.println(iterator + " - " + o);
                    iterator ++;
                }
                
                while(opcao > ofertas.size()){
                    opcao = scan.nextInt();
                    iterator = 0;
                    if(opcao > ofertas.size()){
                        System.out.println(CLEAR + "Opcão inválida. Tente novamente.");
                        for(String o : ofertas){
                            System.out.println(iterator + " - " + o);
                            iterator ++;
                        }
                    }
                }

                escolhas.add(ofertas.get(opcao));
                System.out.println("Deseja escolher mais disciplinas? (s/n)");
                String resp = scan.next();
                if(!(resp.equals("s") || resp.equals("S"))){
                    acabou = true;
                }
            }

            matricula.ofertas = escolhas;
        }else{
            System.out.println(CLEAR + "A secretaria do curso ainda não ofertou nenhuma disciplina.");
            TimeUnit.SECONDS.sleep(2);
        }
    }

    public void verSolicitacoes() throws InterruptedException{
        if(this.solicitacoes.size() > 0){
            for (Solicitacao solicitacao : solicitacoes) {
                System.out.println(CLEAR + "Descricao:" + solicitacao.descricao);
                System.out.println("Rementente: " + solicitacao.rementente.nome);
                TimeUnit.SECONDS.sleep(1);
            }
        }
        TimeUnit.SECONDS.sleep(3);
    }

    @Override
    public int verMenu() {
        int opcao;
        System.out.println(CLEAR);
        System.out.println("1 - Fazer matricula");
        System.out.println("2 - Ver seu curriculo");
        System.out.println("3 - Ver solicitacões");
        System.out.println("4 - Alterar senha");
        System.out.println("5 - Sair");
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

    public void verCurriculo() throws InterruptedException {
        if(this.matricula == null) {
            System.out.println("Você ainda não fez matrícula.");
            TimeUnit.SECONDS.sleep(2);
        }
    }
}