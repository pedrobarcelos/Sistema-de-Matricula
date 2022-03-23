package com.grupo05.matriculas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Admin extends Pessoa implements IFazerLogin, IMenu, ICadastroDisciplina, ICadastroPessoa, Serializable{
    
    private static final long serialVersionUID = 1L;
    public static Scanner scan = new Scanner(System.in);

    public String login;
    public String senha;
    public String nome;

    public Admin(ArrayList<String> credenciais) {
        this.login = credenciais.get(1);
        this.senha = credenciais.get(2);
        this.nome = credenciais.get(0);
    }

    public Admin(Admin target) {
        super(target);
    }

    @Override
    public Admin clone() {
        return new Admin(this);
    }

    @Override
    public boolean fazerLogin(Object object2) {
        return false;
    }

    public ArrayList<String> createAluno(ArrayList<Aluno> alunos) throws InterruptedException{

        ArrayList<String> logins = new ArrayList<String>(alunos.size());
        for(Aluno aluno : alunos){
            logins.add(aluno.login);
        }
        ArrayList<String> credenciais = cadastroPessoa();
        
        while(!(validaLogin(credenciais.get(1), logins))){
            System.out.println(CLEAR + "Login já existente no banco! Tente novamente.");
            TimeUnit.SECONDS.sleep(3);
            credenciais = cadastroPessoa();
        }

        return credenciais;
    }

    public boolean validaLogin(String login, ArrayList<String> logins) {
        boolean valida = true;
        if(logins.size() > 0){    
                for(int i = 0; i < logins.size(); i++){
                    System.out.println("login 1: " + login + " = " + logins.get(i));
                    if(login.equals(logins.get(i)))valida = false;
                }
        }else if(login.equals(logins.get(0))){
            valida = false;
        }
        return valida;
    }

    public ArrayList<String> createProf(ArrayList<Professor> professores) throws InterruptedException{

        ArrayList<String> logins = new ArrayList<String>(professores.size());
        for(Professor prf : professores){
            logins.add(prf.login);
        }
        ArrayList<String> credenciais = cadastroPessoa();
        while(!(validaLogin(credenciais.get(1), logins))){
            System.out.println(CLEAR + "Login já existente no banco! Tente novamente.");
            credenciais = cadastroPessoa();
        }

        return credenciais;
    }

    public ArrayList<String> createAdmin(ArrayList<Admin> admins) throws InterruptedException{

        ArrayList<String> logins = new ArrayList<String>(admins.size());
        for(Admin adm : admins){
            logins.add(adm.login);
        }
        ArrayList<String> credenciais = cadastroPessoa();
        while(!(validaLogin(credenciais.get(1), logins))){
            System.out.println(CLEAR + "Login já existente no banco! Tente novamente.");
            credenciais = cadastroPessoa();
        }

        return credenciais;
    }

    public ArrayList<String> createCobranca(ArrayList<Cobranca> cobranca) throws InterruptedException{

        ArrayList<String> logins = new ArrayList<String>(cobranca.size());
        for(Cobranca cbrnc : cobranca){
            logins.add(cbrnc.login);
        }
        ArrayList<String> credenciais = cadastroPessoa();
        while(!(validaLogin(credenciais.get(1), logins))){
            System.out.println(CLEAR + "Login já existente no banco! Tente novamente.");
            credenciais = cadastroPessoa();
        }

        return credenciais;
    }

    public ArrayList<String> createObrigatoria(ArrayList<Obrigatoria> obrigatorias) throws InterruptedException{
        Scanner scannew = new Scanner(System.in);
        ArrayList<String> codigos = new ArrayList<String>(obrigatorias.size());
        for(Obrigatoria o : obrigatorias){
            codigos.add(o.codigo);
        }

        String nome = "";
        String cargaHoraria = "0";
        String codigo = "";

        while(nome == ""){
            System.out.println("Nome: ");
            nome = scannew.nextLine();
            if(nome == ""){
                System.out.println(CLEAR + " Nome inválido. Tente novamente.");
                TimeUnit.SECONDS.sleep(3);
            }
        }
        while(codigo == "" || codigo.length() != 3){
            System.out.println("Código (3 dígitos): ");
            codigo = scannew.nextLine();
            if(codigo == ""){
                System.out.println(CLEAR + "O Código deve ter 3 digitos. Tente novamente.");
                TimeUnit.SECONDS.sleep(3);
            }
        }
        while(cargaHoraria != "0"){
            System.out.println("Carga horária em horas: ");
            cargaHoraria = scannew.nextLine();
            if(cargaHoraria == "" || cargaHoraria == "0"){
                System.out.println(CLEAR + "A disciplina não pode ter carga zero. Tente novamente.");
                TimeUnit.SECONDS.sleep(3);
            }
        }
        
        ArrayList<String> credenciais = new ArrayList<String>(3);
        credenciais.add(nome);
        credenciais.add(codigo);
        credenciais.add(cargaHoraria);

        return credenciais;
    }

    public ArrayList<String> createOptativa(ArrayList<Optativa> optativas) throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> codigos = new ArrayList<String>(optativas.size());
        for(Optativa o : optativas){
            codigos.add(o.codigo);
        }

        String nome = "";
        String cargaHoraria = "0";
        String codigo = "";

        while(nome == ""){
            System.out.println("Nome: ");
            nome = scanner.nextLine();
            TimeUnit.SECONDS.sleep(3);
            if(nome == ""){
                System.out.println(CLEAR + " Nome inválido. Tente novamente.");
                TimeUnit.SECONDS.sleep(3);
            }
        }
        while(codigo == "" || codigo.length() != 3){
            System.out.println("Código (3 dígitos): ");
            codigo = scanner.nextLine();
            if(codigo == ""){
                System.out.println(CLEAR + "O Código deve ter 3 digitos. Tente novamente.");
                TimeUnit.SECONDS.sleep(3);
            }
        }
        while(cargaHoraria != "0"){
            System.out.println("Carga horária em horas: ");
            cargaHoraria = scanner.nextLine();
            if(cargaHoraria == "" || cargaHoraria == "0"){
                System.out.println(CLEAR + "A disciplina não pode ter carga zero. Tente novamente.");
                TimeUnit.SECONDS.sleep(3);
            }
        }
        
        ArrayList<String> credenciais = new ArrayList<String>(3);
        credenciais.add(nome);
        credenciais.add(codigo);
        credenciais.add(cargaHoraria);

        return credenciais;
    }

    @Override
    public int verMenu() {
        int opcao;
        System.out.println(CLEAR);
        System.out.println("1 - Cadastrar aluno");
        System.out.println("2 - Cadastrar professor");
        System.out.println("3 - Cadastrar administrador");
        System.out.println("4 - Cadastrar funcionario de cobranca");
        System.out.println("5 - Cadastrar disciplina optativa");
        System.out.println("6 - Cadastrar disciplina obrigatoria");
        System.out.println("7 - Alterar senha");
        System.out.println("8 - Gerar ofertas");
        System.out.println("9 - Sair");
        opcao = scan.nextInt();
        return opcao;
    }

    @Override
    public ArrayList<String> cadastroPessoa() throws InterruptedException{

        Scanner scanEXTRA = new Scanner(System.in);

        String nomes = ""; 
        String login =  "";
        String senha = "";

        ArrayList<String> cadastro = new ArrayList<String>(3);

        while(nomes == ""){
            System.out.println(CLEAR + "Nome: ");
            nomes = scanEXTRA.nextLine();
            // nomes = scan.nextLine();
            if(nomes == ""){
                System.out.println(CLEAR + " Nome inválido. Tente novamente.");
                TimeUnit.SECONDS.sleep(3);
            }
        }
        cadastro.add(nomes);

        while(login == ""){
            login = scanEXTRA.nextLine();
            if(login == "" || login.length() != 6){
                System.out.println("O login deve ter obrigatóriamente 6 caracteres. Tente novamente");
                login = "";
            }
        }
        cadastro.add(login);

        while(senha == ""){
            System.out.println(CLEAR +"Senha: ");
            senha = scanEXTRA.nextLine();
            if(senha == "" || senha.length() < 6){
                System.out.println(CLEAR + "A senha deve ter no minimo 6 caracteres. Tente novamente");
                TimeUnit.SECONDS.sleep(3);
            }
        }
        cadastro.add(senha);
        return cadastro;
    }

    public ArrayList<String> gerarOfertas(ArrayList<Obrigatoria> obrigatorias, ArrayList<Optativa> optativas){
        ArrayList<String> ofertas = new ArrayList<String>();
        for (Optativa optativa : optativas) {
            ofertas.add(optativa.gerarOferta());
        }
        for (Obrigatoria o : obrigatorias) {
            ofertas.add(o.gerarOferta());
        }

        for(String oferta : ofertas){
            System.out.println(oferta);
        }
        return ofertas;
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
