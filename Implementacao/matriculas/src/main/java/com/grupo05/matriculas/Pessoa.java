package com.grupo05.matriculas;

import java.io.Serializable;

public abstract class Pessoa implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public String nome;
    public String codigoPessoa;
    public String login;
    public String senha;

}