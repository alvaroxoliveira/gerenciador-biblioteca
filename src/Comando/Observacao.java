package Comando;

/*
* Comando de observação de um livro por um usuário (Professor).
* */

import InteracaoComUsuario.FachadaBiblioteca;

import java.util.ArrayList;

//comando concreto de observação
public class Observacao implements Comando {
    @Override
    public void executar(ArrayList<String> parametroParaExecutar) {
        FachadaBiblioteca.getInstance().realizarObservacao(parametroParaExecutar);
    }
}
