package com.grupo05.matriculas;

import java.util.ArrayList;

public class Professorx extends Pessoa{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Professorx(ArrayList<String> cadastro) {
        this.nome = cadastro.get(0);
        this.codigoPessoa = cadastro.get(1);
        this.senha = cadastro.get(2);
    }
}