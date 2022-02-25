package com.grupo05.matriculas;
import java.util.Scanner;
import java.util.ArrayList;

public class FactoryDOptativa extends FactoryDisciplina implements ICadastro{

    public Scanner scan = new Scanner(System.in);

    @Override
    public void criarDisciplina(){
        ArrayList<String> cadastro = new ArrayList<String>(6);
        cadastro = fazerCadastro();
        disciplina = new DisciplinaOptativa(cadastro);
    }

    @Override
    public ArrayList<String> fazerCadastro() {
        ArrayList<String> cadastro = new ArrayList<String>(6);
        String nome,cargaHoraria,periodo;
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Nome da disciplina optativa: ");
        nome = scan.nextLine();
        cadastro.add(nome);
        System.out.println("Carga horaria da disciplina optativa(horas): ");
        cargaHoraria = scan.nextLine();
        cadastro.add(cargaHoraria);
        System.out.println("Periodo da disciplina optativa: "); 
        periodo = scan.nextLine();
        cadastro.add(periodo);
        return cadastro;
    }
}
