package com.grupo05.matriculas;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

public class App {

    public static String CLEAR = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";

    public static ArrayList<String> credentials = new ArrayList<String>(2);
    public static Serializador s = new Serializador();
    public static Deserializador d = new Deserializador();
    public static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    public static ArrayList<Professor> professores = new ArrayList<Professor>();
    public static ArrayList<Obrigatoria> obrigatorias = new ArrayList<Obrigatoria>();
    public static ArrayList<Optativa> optativas = new ArrayList<Optativa>();
    public static ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
    public static ArrayList<Cobranca> cobranca = new ArrayList<Cobranca>();
    public static ArrayList<Admin> admins = new ArrayList<Admin>();
    public static ArrayList<Curso> cursos = new ArrayList<Curso>();
    public static ArrayList<String> ofertas = new ArrayList<String>();

    public static void main(String[] args) throws InterruptedException {

        // boot();

        // Deserializacao
        deserializacao();

        // autentificacao
        int tipo = autentificar();

        // instanciar o individuo logado
        acessarSistema(tipo);

        // Serializacao
        serializacao();

        System.out.println(CLEAR + "Encerrando aplicacão");
        TimeUnit.SECONDS.sleep(1);
        System.out.println(CLEAR + "Encerrando aplicacão.");
        TimeUnit.SECONDS.sleep(1);
        System.out.println(CLEAR + "Encerrando aplicacão..");
        TimeUnit.SECONDS.sleep(1);
        System.out.println(CLEAR + "Encerrando aplicacão...");
        TimeUnit.SECONDS.sleep(1);
        System.out.println(CLEAR + "Encerrando aplicacão.");
        TimeUnit.SECONDS.sleep(1);
        System.out.println(CLEAR + "Finished.");
        TimeUnit.SECONDS.sleep(1);
    }

    public static void verMenu() {
        System.out.println(CLEAR);
        System.out.println("Selecionar tipo: ");
        System.out.println("1 - Aluno");
        System.out.println("2 - Professor");
        System.out.println("3 - Cobranca");
        System.out.println("4 - Administrador");
    }

    public static boolean validarSenhaAluno(String login, String password) throws InterruptedException {
        boolean validar = false;
        for (Aluno aluno : alunos) {
            if (login.equals(aluno.login) && password.equals(aluno.senha)) {
                validar = true;
            }
        }
        if (validar == false) {
            System.out.println(CLEAR);
            System.out.println("Credenciais não encontradas no banco.\nTente novamente.");
            TimeUnit.SECONDS.sleep(3);
        }

        return validar;
    }

    public static boolean validarSenhaCobranca(String login, String password) throws InterruptedException {
        boolean validar = false;
        for (Cobranca cbrnc : cobranca) {
            if (login.equals(cbrnc.login) && password.equals(cbrnc.senha)) {
                validar = true;
            }
        }
        if (validar == false) {
            System.out.println(CLEAR);
            System.out.println("Credenciais não encontradas no banco.\nTente novamente.");
            TimeUnit.SECONDS.sleep(3);
        }

        return validar;
    }

    public static boolean validarSenhaProfessor(String login, String password) throws InterruptedException {
        boolean validar = false;
        for (Professor profe : professores) {
            if (login.equals(profe.login) && password.equals(profe.senha)) {
                validar = true;
            }
        }
        if (validar == false) {
            System.out.println(CLEAR);
            System.out.println("Credenciais não encontradas no banco.\nTente novamente.");
            TimeUnit.SECONDS.sleep(3);
        }

        return validar;
    }

    public static ArrayList<String> fazerLogin() {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> credentials = new ArrayList<String>(2);
        String login, senha;
        System.out.println(CLEAR);
        System.out.println("Login: ");
        login = scan.nextLine();

        System.out.println(CLEAR + "Senha: ");
        senha = scan.nextLine();

        credentials.add(login);
        credentials.add(senha);

        return credentials;

    }

    private static void boot() {
        ArrayList<String> str = new ArrayList<String>();
        str.add("Pedro Barcelos");
        str.add("689803");
        str.add("PEDRO123");
        ArrayList<String> fessor = new ArrayList<String>();
        fessor.add("Laerte");
        fessor.add("123456");
        fessor.add("LAERTE123");
        ArrayList<String> admini = new ArrayList<String>();
        admini.add("Eveline");
        admini.add("543212");
        admini.add("EVELINE123");
        ArrayList<String> mtr = new ArrayList<String>();
        mtr.add("AED2");
        mtr.add("000");
        mtr.add("200");
        ArrayList<String> filo = new ArrayList<String>();
        filo.add("Filosofia");
        filo.add("001");
        filo.add("150");
        ArrayList<String> cobranca2 = new ArrayList<String>();
        cobranca2.add("Alexandre");
        cobranca2.add("456795");
        cobranca2.add("ALEXANDRE123");
        Aluno boot = new Aluno(str);
        alunos.add(boot);
        Professor boot2 = new Professor(fessor);
        professores.add(boot2);
        Admin boot3 = new Admin(admini);
        admins.add(boot3);
        Cobranca boot4 = new Cobranca(cobranca2);
        cobranca.add(boot4);
        Obrigatoria boot5 = new Obrigatoria(mtr);
        obrigatorias.add(boot5);
        Optativa boot6 = new Optativa(filo);
        optativas.add(boot6);
    }

    private static void acessarSistema(int tipo) throws InterruptedException {
        if (tipo == 1) {
            for (Aluno aluno : alunos) {
                if (aluno.login.equals(credentials.get(0))) {
                    int opcaoAluno = aluno.verMenu();
                    while (opcaoAluno != 5) {
                        switch (opcaoAluno) {
                        case 1:
                            aluno.fazerMatricula(ofertas);
                            break;
                        case 2:
                            aluno.verCurriculo();
                            break;
                        case 3:
                            aluno.verSolicitacoes();
                            break;
                        case 4:
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
            for (Professor professor : professores) {
                if (professor.login.equals(credentials.get(0))) {
                    int opcaoProfessor = professor.verMenu();
                    while (opcaoProfessor != 0) {
                        switch (opcaoProfessor) {
                        case 1:
                            System.out.println(CLEAR);
                            System.out.println("1 - Disciplinas Obrigatorias");
                            System.out.println("2 - Disciplinas Optativas");
                            Scanner scan = new Scanner(System.in);
                            int opcao = scan.nextInt();
                            switch (opcao) {
                            case 1:
                                professor.searchAlunosOBG(obrigatorias, alunos);
                                break;
                            case 2:
                                professor.searchAlunosOPT(optativas, alunos);
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
        } else if (tipo == 3) {
            for (Cobranca cbrnc : cobranca) {
                if (cbrnc.login.equals(credentials.get(0))) {
                    int opcaoCobranca = cbrnc.verMenu();
                    while (opcaoCobranca != 3) {
                        switch (opcaoCobranca) {
                        case 1:
                            cbrnc.cobrarAluno(alunos);
                            break;
                        case 2:
                            cbrnc.alterarSenha();
                            break;
                        default:
                            System.err.println("Opcao invalida.");
                        }
                        opcaoCobranca = cbrnc.verMenu();
                    }
                }
            }
        } else if (tipo == 4) {
            ArrayList<String> credenciaisadmin = new ArrayList<String>(3);
            ArrayList<String> credenciais = new ArrayList<String>(3);
            credenciaisadmin.add("master");
            credenciaisadmin.add("999999");
            credenciaisadmin.add("999999");
            Admin master = new Admin(credenciaisadmin);
            for (Admin adm : admins) {
                if (adm.login.equals(credentials.get(0))) {
                    int opcaoAdm = adm.verMenu();
                    while (opcaoAdm != 9) {
                        switch (opcaoAdm) {
                        case 1:
                            credenciais = adm.createAluno(alunos);
                            Aluno temp = new Aluno(credenciais);
                            alunos.add(temp);
                            TimeUnit.SECONDS.sleep(2);
                            break;
                        case 2:
                            credenciais = adm.createProf(professores);
                            Professor temp1 = new Professor(credenciais);
                            professores.add(temp1);
                            TimeUnit.SECONDS.sleep(2);
                            break;
                        case 3:
                            credenciais = adm.createAdmin(admins);
                            Admin temp2 = new Admin(credenciais);
                            admins.add(temp2);
                            TimeUnit.SECONDS.sleep(2);
                            break;
                        case 4:
                            credenciais = adm.createCobranca(cobranca);
                            Cobranca temp3 = new Cobranca(credenciais);
                            cobranca.add(temp3);
                            TimeUnit.SECONDS.sleep(2);
                            break;
                        case 5:
                            credenciais = adm.createOptativa(optativas);
                            Optativa temp4 = new Optativa(credenciais);
                            optativas.add(temp4);
                            TimeUnit.SECONDS.sleep(2);
                            break;
                        case 6:
                            credenciais = adm.createObrigatoria(obrigatorias);
                            Obrigatoria temp5 = new Obrigatoria(credenciais);
                            TimeUnit.SECONDS.sleep(2);
                            obrigatorias.add(temp5);
                            break;
                        case 7:
                            master.alterarSenha();
                            TimeUnit.SECONDS.sleep(2);
                            break;
                        case 8:
                            ArrayList<String> ofrts = new ArrayList<String>();
                            ofrts = master.gerarOfertas(obrigatorias, optativas);
                            for (String string : ofrts) {
                                boolean repete = false;
                                for (String string2 : ofertas) {
                                    if (string.equals(string2)) {
                                        repete = true;
                                    }
                                }
                                if (!(repete))
                                    ofertas.add(string);
                            }
                            TimeUnit.SECONDS.sleep(2);
                            break;
                        case 9:
                            break;
                        default:
                            System.out.println("Opcao invalida");
                        }
                        opcaoAdm = adm.verMenu();
                    }
                } else if ((credentials.get(0).equals("admin") && credentials.get(1).equals("admin"))) {
                    int opcaoAdm = master.verMenu();
                    while (opcaoAdm != 9) {
                        switch (opcaoAdm) {
                        case 1:
                            credenciais = master.createAluno(alunos);
                            Aluno temp = new Aluno(credenciais);
                            alunos.add(temp);
                            TimeUnit.SECONDS.sleep(2);
                            break;
                        case 2:
                            credenciais = master.createProf(professores);
                            Professor temp1 = new Professor(credenciais);
                            professores.add(temp1);
                            TimeUnit.SECONDS.sleep(2);
                            break;
                        case 3:
                            credenciais = master.createAdmin(admins);
                            Admin temp2 = new Admin(credenciais);
                            admins.add(temp2);
                            TimeUnit.SECONDS.sleep(2);
                            break;
                        case 4:
                            credenciais = master.createCobranca(cobranca);
                            Cobranca temp3 = new Cobranca(credenciais);
                            cobranca.add(temp3);
                            TimeUnit.SECONDS.sleep(2);
                            break;
                        case 5:
                            credenciais = master.createOptativa(optativas);
                            Optativa temp4 = new Optativa(credenciais);
                            optativas.add(temp4);
                            TimeUnit.SECONDS.sleep(2);
                            break;
                        case 6:
                            credenciais = master.createObrigatoria(obrigatorias);
                            Obrigatoria temp5 = new Obrigatoria(credenciais);
                            TimeUnit.SECONDS.sleep(2);
                            obrigatorias.add(temp5);
                            break;
                        case 7:
                            master.alterarSenha();
                            TimeUnit.SECONDS.sleep(2);
                            break;
                        case 8:
                            ArrayList<String> ofrts = new ArrayList<String>();
                            ofrts = master.gerarOfertas(obrigatorias, optativas);
                            for (String string : ofrts) {
                                boolean repete = false;
                                for (String string2 : ofertas) {
                                    if (string.equals(string2)) {
                                        repete = true;
                                    }
                                }
                                if (!(repete))
                                    ofertas.add(string);
                            }
                            TimeUnit.SECONDS.sleep(2);
                            break;
                        case 9:
                            break;
                        default:
                            System.out.println("Opcao invalida");
                        }
                        opcaoAdm = adm.verMenu();
                    }
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
                fazerLogin = validarSenhaCobranca(credentials.get(0), credentials.get(1));
            } else if (opcao.equals("4")) {
                credentials = fazerLogin();
                fazerLogin = validarSenhaAdmin(credentials.get(0), credentials.get(1));
            } else {
                System.out.println(CLEAR);
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
            s.serializar("TB_DISCIPLINAS_OBRIGATORIAS", obrigatorias);
            s.serializar("TB_DISCIPLINAS_OPTATIVAS", optativas);
            s.serializar("TB_ADMINS", admins);
            s.serializar("TB_COBRANCA", cobranca);
            s.serializar("TB_CURSOS", cursos);
            s.serializar("TB_OFERTAS", ofertas);
        } catch (Exception ex) {
            System.out.println(CLEAR);
            System.err.println("Falha ao serializar! - " + ex.toString());
        }
    }

    private static void deserializacao() throws InterruptedException {

        System.out.println(CLEAR
                + "                                                                    OBJETOS PERSISTENTES          \n\n\n\n\n\n\n\n\n\n\n\n\nVocê terá 5 segundos para analisar cada sessão");
        TimeUnit.SECONDS.sleep(3);

        try {

            admins = null;
            cobranca = null;
            alunos = null;
            professores = null;
            optativas = null;
            obrigatorias = null;
            cursos = null;
            ofertas = null;

            alunos = (ArrayList<Aluno>) d.deserializar("TB_ALUNOS");
            admins = (ArrayList<Admin>) d.deserializar("TB_ADMINS");
            cobranca = (ArrayList<Cobranca>) d.deserializar("TB_COBRANCA");
            professores = (ArrayList<Professor>) d.deserializar("TB_PROFESSORES");
            optativas = (ArrayList<Optativa>) d.deserializar("TB_DISCIPLINAS_OPTATIVAS");
            obrigatorias = (ArrayList<Obrigatoria>) d.deserializar("TB_DISCIPLINAS_OBRIGATORIAS");
            cursos = (ArrayList<Curso>) d.deserializar("TB_CURSOS");
            ofertas = (ArrayList<String>) d.deserializar("TB_OFERTAS");
            System.out
                    .println(CLEAR + "-------------------------------PESSOAS----------------------------------------");
            System.out.println("Modelo: tipo,login,nome,senha;");
            System.out.println("------------------------------------------------------------------------------");

            for (Aluno aluno : alunos) {
                System.out.println("aluno," + aluno.login + "," + aluno.nome + "," + aluno.senha + ";");
                System.out.println("------------------------------------------------------------------------------");
            }

            for (Curso curso : cursos) {
                System.out.println("curso," + curso.nome + ";");
                System.out.println("------------------------------------------------------------------------------");
            }

            for (Admin adm : admins) {
                System.out.println("admin," + adm.login + "," + adm.nome + "," + adm.senha + ";");
                System.out.println("------------------------------------------------------------------------------");
            }
            for (Cobranca cbrnc : cobranca) {
                System.out.println("cobranca," + cbrnc.login + "," + cbrnc.nome + "," + cbrnc.senha + ";");
                System.out.println("------------------------------------------------------------------------------");
            }
            for (Professor professor : professores) {
                System.out.println("professor," + professor.login + "," + professor.nome + "," + professor.senha + ";");
                System.out.println("------------------------------------------------------------------------------");
            }

            TimeUnit.SECONDS.sleep(3);
            System.out.println(CLEAR + "-------------------------------OFERTAS----------------------------------------");
            System.out.println("Modelo: tipo,nome;");
            System.out.println("------------------------------------------------------------------------------");

            for (String oferta : ofertas) {
                System.out.println("oferta," + oferta + ";");
                System.out.println("------------------------------------------------------------------------------");
            }

            System.out.println("\n\n-------------------------------DISCIPLINAS------------------------------------");
            System.out.println("Modelo: tipo,nome,carga;");
            System.out.println("------------------------------------------------------------------------------");

            for (Obrigatoria Dobgt : obrigatorias) {
                System.out.println("obrigatoria," + Dobgt.nome + "," + Dobgt.cargaHoraria + ";");
                System.out.println("------------------------------------------------------------------------------");
            }
            for (Optativa Doptv : optativas) {
                System.out.println("optativa," + Doptv.nome + "," + Doptv.cargaHoraria + ";");
                System.out.println("------------------------------------------------------------------------------");
            }
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception ex) {
            System.out.println(CLEAR);
            System.err.println("Falha ao deserializar! - " + ex.toString() + ex.getStackTrace());
        }

        for (Optativa ptv : optativas) {
            disciplinas.add(ptv);
        }
        for (Obrigatoria obg : obrigatorias) {
            disciplinas.add(obg);
        }
        TimeUnit.SECONDS.sleep(2);
    }

    private static boolean validarSenhaAdmin(String login, String password) throws InterruptedException {
        boolean validar = false;
        for (Admin adm : admins) {
            if (login.equals(adm.login) && password.equals(adm.senha)) {
                validar = true;
            }
        }
        if (validar == false) {
            if (login.equals("admin") && password.equals("admin")) {
                validar = true;
            } else {
                System.out.println(CLEAR);
                System.out.println("Credenciais não encontradas no banco.\nTente novamente.");
                TimeUnit.SECONDS.sleep(3);
            }
        }
        return validar;
    }
}
