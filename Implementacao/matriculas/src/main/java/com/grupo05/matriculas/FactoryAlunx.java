package com.grupo05.matriculas;
import java.util.Scanner;
import java.util.ArrayList;

public class FactoryAlunx extends SecretariaFactory implements ICadastro{

    public Scanner scan = new Scanner(System.in);

    @Override
    public void criarPessoa(){
            
        ArrayList<String> cadastro = new ArrayList<String>(6);
        cadastro = fazerCadastro();
        pessoa = new Alunx(cadastro);
    }

    @Override
    public ArrayList<String> fazerCadastro() {
        ArrayList<String> cadastro = new ArrayList<String>(6);
        String nome,codigoPessoa,senha,curso,turno,periodo;
        System.out.println("Nome do aluno: ");
        nome = scan.nextLine();
        cadastro.add(nome);
        System.out.println("Criar codigo de pessoa(login): ");
        codigoPessoa = scan.nextLine();
        cadastro.add(codigoPessoa);
        System.out.println("Criar senha(8 caracteres): ");
        senha = scan.nextLine();
        cadastro.add(senha);
        System.out.println("Curso: ");
        curso = scan.nextLine();
        cadastro.add(curso);
        System.out.println("Turno: ");
        turno = scan.nextLine();
        cadastro.add(turno);
        System.out.println("Periodo: ");
        periodo = scan.nextLine();
        cadastro.add(periodo);
        return cadastro;
    }
}
