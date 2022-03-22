package com.grupo05.matriculas;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Obrigatoria extends Disciplina implements Serializable{

    private static final long serialVersionUID = 1L;

    public String codigo;
    public String nome;
    public String cargaHoraria;

    public String gerarOferta(){
        Oferta o = new Oferta(nome);
        return o.nome;
    }
    
    public Obrigatoria(ArrayList<String> credenciais) {
        this.nome = credenciais.get(0);
        this.codigo = credenciais.get(1);
        this.cargaHoraria = credenciais.get(2);
    }

    public Obrigatoria(Obrigatoria target) {
        super(target);
    }

    @Override
    public Disciplina clone() {
        return null;
    }
    
}