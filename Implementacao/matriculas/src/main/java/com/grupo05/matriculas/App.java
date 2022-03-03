package com.grupo05.matriculas;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

public class App {

    static ArrayList<String> credentials = new ArrayList<String>(2);
    static Serializador s = new Serializador();
    static Deserializador d = new Deserializador();
    static ArrayList<Alunx> alunos = new ArrayList<Alunx>();
    static ArrayList<Professorx> professores = new ArrayList<Professorx>();
    static ArrayList<Curso> cursos = new ArrayList<Curso>();
    static ArrayList<DisciplinaObrigatoria> DObrigatorias = new ArrayList<DisciplinaObrigatoria>();
    static ArrayList<DisciplinaOptativa> DOptativas = new ArrayList<DisciplinaOptativa>();
    static ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
    static Admin admin = new Admin();

    public static void verMenu() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Selecionar tipo: ");
        System.out.println("1 - Alunx");
        System.out.println("2 - Professorx");
        System.out.println("3 - Admin");
        System.out.println("4 - Esqueci minha senha");
    }

    public static boolean validarSenhaAluno(String login, String password) throws InterruptedException {
        boolean validar = false;
        for (Alunx aluno : alunos) {
            if (login.equals(aluno.codigoPessoa) && password.equals(aluno.senha)) {
                validar = true;
            }
        }
        if (validar == false) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Credenciais não encontradas no banco.\nTente novamente.");
            TimeUnit.SECONDS.sleep(3);
        }

        return validar;
    }

    public static boolean validarSenhaProfessor(String login, String password) throws InterruptedException {
        boolean validar = false;
        for (Professorx profe : professores) {
            if (login.equals(profe.codigoPessoa) && password.equals(profe.senha)) {
                validar = true;
            }
        }
        if (validar == false) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Credenciais não encontradas no banco.\nTente novamente.");
            TimeUnit.SECONDS.sleep(3);
        }

        return validar;
    }

    public static ArrayList<String> fazerLogin() {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> credentials = new ArrayList<String>(2);
        String login, senha;
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Login: ");
        login = scan.nextLine();
        System.out.println("Senha: ");
        senha = scan.nextLine();

        credentials.add(login);
        credentials.add(senha);

        // System.out.println("CADASTRANDO: " + credentials.get(0) + " - " +
        // credentials.get(1));
        return credentials;

    }

    public static void main(String[] args) throws InterruptedException {

        // Deserializacao
        deserializacao();

        // autentificacao
        int tipo = autentificar();

        // instanciar o individuo logado
        acessarSistema(tipo);

        // Serializacao
        serializacao();
    }

    // FactoryPessoa secretaria = new FactoryAlunx();
    // secretaria.criarPessoa();
    // alunos.add((Alunx) secretaria.show());

    // try {
    // s.serializar("TB_ALUNOS", alunos);
    // s.serializar("TB_PROFESSORES", professores);
    // } catch (Exception ex) {
    // System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    // System.err.println("Falha ao deserializar! - " + ex.toString());
    // }
    // }

    private static void acessarSistema(int tipo) {
        if (tipo == 1) {
            for (Alunx aluno : alunos) {
                if (aluno.codigoPessoa.equals(credentials.get(0))) {
                    int opcaoAluno = aluno.verMenu();
                    while (opcaoAluno != 0) {
                        switch (opcaoAluno) {
                        case 1:
                            aluno.fazerMatricula(DObrigatorias, DOptativas);
                            break;
                        case 2:
                            aluno.alterarSenha();
                            break;
                        default:
                            System.err.println("Opcao invalida.");
                        }
                        opcaoAluno = aluno.verMenu();
                    }
                }
            }
        } else if (tipo == 2) {
            for (Professorx professor : professores) {
                if (professor.codigoPessoa.equals(credentials.get(0))) {
                    int opcaoProfessor = professor.verMenu();
                    while (opcaoProfessor != 0) {
                        switch (opcaoProfessor) {
                        case 1:
                            System.out.println(
                                    "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            System.out.println("1 - Disciplinas Obrigatorias");
                            System.out.println("2 - Disciplinas Optativas");
                            Scanner scan = new Scanner(System.in);
                            int opcao = scan.nextInt();
                            switch (opcao) {
                            case 1:
                                professor.searchAlunosOBG(DObrigatorias, alunos);
                                break;
                            case 2:
                                professor.searchAlunosOPT(DOptativas, alunos);
                                break;
                            default:
                                break;
                            }
                            break;
                        }
                        opcaoProfessor = professor.verMenu();
                    }
                }
            }
        } else {
            int aux = 1;
            int opcaoAdmin = 0;
            while (aux != 0) {
                opcaoAdmin = admin.verMenu();
                switch (opcaoAdmin) {
                case 1:
                    admin.cadastrarAluno(alunos);
                    break;
                case 2:
                    admin.cadastrarProfessor(professores);
                    break;
                case 3:
                    admin.cadastrarDisciplinaOBG(DObrigatorias);
                    break;
                case 4:
                    admin.cadastrarDisciplinaOPT(DOptativas);
                    break;
                case 5:
                    admin.cadastrarCurso(cursos);
                    break;
                case 6:
                    admin.alterarSenha();
                    break;
                case 7:
                    aux = 0;
                    break;
                default:
                    System.out.println("Opcao invalida");
                }
            }
        }

    }

    private static int autentificar() throws InterruptedException {
        int tipo;
        boolean fazerLogin = false;
        do {
            Scanner scan = new Scanner(System.in);
            verMenu();
            String opcao = scan.nextLine();
            credentials = null;
            if (opcao.equals("1")) {
                credentials = fazerLogin();
                fazerLogin = validarSenhaAluno(credentials.get(0), credentials.get(1));
            } else if (opcao.equals("2")) {
                credentials = fazerLogin();
                fazerLogin = validarSenhaProfessor(credentials.get(0), credentials.get(1));
            } else if (opcao.equals("3")) {
                credentials = fazerLogin();
                fazerLogin = validarSenhaAdmin(credentials.get(0), credentials.get(1));
            } else {
                System.out.println(
                        "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("Tipo inválido. Tente novamente.");
            }
            tipo = Integer.parseInt(opcao);

        } while (fazerLogin == false);
        return tipo;
    }

    private static void serializacao() {
        try {
            s.serializar("TB_ALUNOS", alunos);
            s.serializar("TB_PROFESSORES", professores);
            s.serializar("TB_CURSOS", cursos);
            s.serializar("TB_DISCIPLINAS_OBRIGATORIAS", DObrigatorias);
            s.serializar("TB_DISCIPLINAS_OPTATIVAS", DOptativas);
        } catch (Exception ex) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.err.println("Falha ao serializar! - " + ex.toString());
        }
    }

    private static void deserializacao() {
        try {
            admin = (Admin) d.deserializar("admin");
            alunos = null;
            professores = null;
            cursos = null;
            DOptativas = null;
            DObrigatorias = null;
            alunos = (ArrayList<Alunx>) d.deserializar("TB_ALUNOS");
            professores = (ArrayList<Professorx>) d.deserializar("TB_PROFESSORES");
            cursos = (ArrayList<Curso>) d.deserializar("TB_CURSOS");
            DOptativas = (ArrayList<DisciplinaOptativa>) d.deserializar("TB_DISCIPLINAS_OPTATIVAS");
            DObrigatorias = (ArrayList<DisciplinaObrigatoria>) d.deserializar("TB_DISCIPLINAS_OBRIGATORIAS");
            System.out.println("ALUNO BASE: " + alunos.get(0).toString());
            for (Alunx aluno : alunos) {
                System.out.println(
                        "Aluno: " + aluno.codigoPessoa + " - Nome: " + aluno.nome + " - Senha: " + aluno.senha);
            }
            for (Professorx professor : professores) {
                System.out.println("Professor: " + professor.codigoPessoa + " - Nome: " + professor.nome);
            }
            for (DisciplinaObrigatoria Dobgt : DObrigatorias) {
                System.out.println("Disciplina Obrigatoria: " + Dobgt.nome + " - Carga Horario: " + Dobgt.cargaHoraria);
            }
            for (DisciplinaOptativa Doptv : DOptativas) {
                System.out.println("Disciplina Optativo: " + Doptv.nome + " - Carga Horario: " + Doptv.cargaHoraria);
            }
            for (Curso crs : cursos) {
                System.out.println("Curso: " + crs.nome + " - Creditos:" + crs.creditos);
            }
            System.out.println("Admin: " + admin.login + " - Creditos:" + admin.senha);
        } catch (Exception ex) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.err.println("Falha ao deserializar! - " + ex.toString() + ex.getStackTrace());
        }

        for (DisciplinaOptativa ptv : DOptativas) {
            disciplinas.add(ptv);
        }
        for (DisciplinaObrigatoria obg : DObrigatorias) {
            disciplinas.add(obg);
        }
    }

    private static boolean validarSenhaAdmin(String string, String string2) throws InterruptedException {
        if (!(string.equals("admin") && string2.equals("admin"))) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Credenciais não encontradas no banco.\nTente novamente.");
            TimeUnit.SECONDS.sleep(3);
        }
        return (string.equals("admin") && string2.equals("admin")) ? true : false;
    }
}
