package com.grupo05.matriculas;

import java.util.ArrayList;

public class Alunx extends Pessoa{

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public String turno;
    public String curso;
    public String periodo;

    public Alunx(ArrayList<String> cadastro) {
        this.nome = cadastro.get(0);
        this.codigoPessoa = cadastro.get(1);
        this.senha = cadastro.get(2);
        this.curso = cadastro.get(3);
        this.turno = cadastro.get(4);
        this.periodo = cadastro.get(5);
    }

    @Override
    public String toString() {
        return "\nALUNX INFOS:\nNome do aluno: " + this.nome + "\nCodigo de pessoa: " + this.codigoPessoa + "\nSenha: " + this.senha + "\nCurso: " + this.curso + "\nTurno: " + this.turno + "\nPeriodo: " + this.periodo;
    }
}