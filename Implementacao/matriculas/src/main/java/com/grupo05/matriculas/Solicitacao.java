package com.grupo05.matriculas;

import java.io.Serializable;

public class Solicitacao implements Serializable{
    private static final long serialVersionUID = 1L;
    public Cobranca rementente;
    public Aluno destinatario;
    public String descricao;
    
    public Solicitacao(Cobranca rementente, Aluno destinatario, String descricao) {
        this.rementente = rementente;
        this.destinatario = destinatario;
        this.descricao = descricao;
    }

    public Solicitacao() {
    }
}
