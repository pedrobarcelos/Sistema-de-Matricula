package com.grupo05.matriculas;

import java.util.Scanner;
import java.util.ArrayList;

public class FactoryProfessorx extends SecretariaFactory implements ICadastro{

    public Scanner scan = new Scanner(System.in);

    @Override
    public void criarPessoa(){
            
        ArrayList<String> cadastro = new ArrayList<String>(6);
        cadastro = fazerCadastro();
        pessoa = new Professorx(cadastro);
    }

    @Override
    public ArrayList<String> fazerCadastro() {
        ArrayList<String> cadastro = new ArrayList<String>(6);
        String nome,codigoPessoa,senha;
        System.out.println("Nome do professor(a): ");
        nome = scan.nextLine();
        cadastro.add(nome);
        System.out.println("Criar codigo de pessoa(login): ");
        codigoPessoa = scan.nextLine();
        cadastro.add(codigoPessoa);
        System.out.println("Criar senha(8 caracteres): ");
        senha = scan.nextLine();
        cadastro.add(senha);
        return cadastro;
    }
}
