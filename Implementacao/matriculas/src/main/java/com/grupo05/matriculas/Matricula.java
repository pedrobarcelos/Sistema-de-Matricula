package com.grupo05.matriculas;

import java.io.Serializable;
import java.util.ArrayList;

public class Matricula implements Serializable{

    public ArrayList<String> ofertas = new ArrayList<String>();
    private static final long serialVersionUID = 1L;

    public Matricula() {
    }

    public Matricula(ArrayList<String> ofertas) {
        this.ofertas = ofertas;
    }
    
}
