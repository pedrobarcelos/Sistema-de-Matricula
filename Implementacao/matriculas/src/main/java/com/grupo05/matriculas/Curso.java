package com.grupo05.matriculas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Curso implements ICadastro, Serializable {

    private static final long serialVersionUID = 1L;
    transient Scanner scan = new Scanner(System.in);
    
    public String nome;
    public int creditos;
    public ArrayList<Disciplina> disciplinas;

    public Curso(){
        ArrayList<String> cadastro = new ArrayList<String>(2);
        cadastro = fazerCadastro();
        this.nome = cadastro.get(0);
        this.creditos = Integer.parseInt(cadastro.get(1));
    }
    @Override
    public ArrayList<String> fazerCadastro() {
        ArrayList<String> cadastro = new ArrayList<String>(2);
        String nome;
        String creditos;
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Nome do curso: ");
        nome = scan.nextLine();
        cadastro.add(nome);
        System.out.println("Quantidade de creditos: ");
        creditos = scan.nextLine();
        cadastro.add(creditos);
        return cadastro;

    } 
}
