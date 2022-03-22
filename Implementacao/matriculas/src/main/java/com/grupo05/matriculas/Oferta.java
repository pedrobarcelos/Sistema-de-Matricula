package com.grupo05.matriculas;

import java.io.Serializable;
import java.time.LocalDate;

public class Oferta implements Serializable {
    
    public String nome = "";
    public LocalDate localDate = LocalDate.now();
    private static final long serialVersionUID = 1L;
    public Oferta(String nome) {
        this.nome = nome;
        this.nome += " - ";
        this.nome += ""+localDate.getYear();
        if(localDate.getMonthValue() < 6){
            this.nome += " - " + "01";
        }else this.nome += " - " + "02";
    }

    public Oferta() {
    }

}
