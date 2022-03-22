package com.grupo05.matriculas;

import java.util.ArrayList;

public interface ICadastroDisciplina {
    public ArrayList<String> createObrigatoria(ArrayList<Obrigatoria> obrigatorias)throws InterruptedException;
    public ArrayList<String> createOptativa(ArrayList<Optativa> optativas)throws InterruptedException;
}
