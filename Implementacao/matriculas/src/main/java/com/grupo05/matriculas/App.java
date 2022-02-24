package com.grupo05.matriculas;

import java.util.Scanner;
import java.util.ArrayList;

public class App {

    static Scanner scan = new Scanner(System.in);
    static Serializador s = new Serializador();
    static Deserializador d = new Deserializador();

    public static void verMenu() {
        System.out.println("Selecionar tipo: ");
        System.out.println("Alunx");
        System.out.println("Professorx");
        System.out.println("Admin");
    }

    public static ArrayList<String> fazerLogin() {

        ArrayList<String> credentials = new ArrayList<String>(2);
        String login, senha;

        System.out.println("Login: ");
        login = scan.nextLine();
        System.out.println("Senha: ");
        senha = scan.nextLine();

        credentials.add(login);
        credentials.add(senha);

        return credentials;

    }

    public static void main(String[] args) {

        ArrayList<Pessoa> alunos = new ArrayList<Pessoa>();
        ArrayList<Pessoa> professores = new ArrayList<Pessoa>();
        Admin admin = new Admin();
        admin = null;
        try {
            admin = (Admin) d.deserializar("admin");
            alunos = null;
            professores = null;
            alunos = (ArrayList<Pessoa>) d.deserializar("TB_ALUNOS");
            professores = (ArrayList<Pessoa>) d.deserializar("TB_PROFESSORES");
            for (Pessoa aluno : alunos) {
                System.out.println("Aluno: " + aluno.codigoPessoa + " - " + aluno.nome);
            }
            for (Pessoa professor : professores) {
                System.out.println("Professor: " + professor.codigoPessoa + " - " + professor.nome);
            }
        } catch (Exception ex) {
            System.err.println("Falha ao deserializar! - " + ex.toString());
        }

        verMenu();

        String opcao = scan.nextLine();
        ArrayList<String> credentials = new ArrayList<String>(2);
        credentials = fazerLogin();

        if (opcao.equals("alunx")) {
            System.out.println("ola aluno");
        } else if (opcao.equals("professorx")) {
            System.out.println("ola prof.");
        } else if (opcao.equals("admin")) {
            System.out.println("ola administrador");
        }
        SecretariaFactory secretaria = new FactoryAlunx();
        secretaria.criarPessoa();
        alunos.add(secretaria.show());

        try {
            s.serializar("TB_ALUNOS", alunos);
            s.serializar("TB_PROFESSORES", professores);
        } catch (Exception ex) {
            System.err.println("Falha ao deserializar! - " + ex.toString());
        }
    }
}
