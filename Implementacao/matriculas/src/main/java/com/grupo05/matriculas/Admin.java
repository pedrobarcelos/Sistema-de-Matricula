package com.grupo05.matriculas;

import java.io.Serializable;

public class Admin implements Serializable{
    
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public String login = "admin";
    public String senha = "admin";

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin [login=" + login + ", senha=" + senha + "]";
    }
}
