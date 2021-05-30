package Comando;

/*
* Comando de devolução de um livro pelo usuário.
* */

import InteracaoComUsuario.FachadaBiblioteca;
import java.util.ArrayList;

public class Devolucao implements Comando {
    @Override
    public void executar(ArrayList<String> parametroParaExecutar) {
        FachadaBiblioteca.getInstance().realizarDevolucao(parametroParaExecutar);
    }
}
