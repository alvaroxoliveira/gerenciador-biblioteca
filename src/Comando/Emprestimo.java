package Comando;

/*
* Comando de empréstimo de um livro por um usuário.
* */

import InteracaoComUsuario.FachadaBiblioteca;

import java.util.ArrayList;

public class Emprestimo implements Comando {
    @Override
    public void executar(ArrayList<String> parametroParaExecutar) {
        FachadaBiblioteca.getInstance().realizarEmprestimo(parametroParaExecutar);
    }
}
