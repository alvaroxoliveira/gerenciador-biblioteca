package Comando;

import InteracaoComUsuario.FachadaBiblioteca;

import java.util.ArrayList;

//comando concreto de emprestimo
public class Emprestimo implements Comando {
    @Override
    public void executar(ArrayList<String> parametroParaExecutar) {
        FachadaBiblioteca.getInstance().realizarEmprestimo(parametroParaExecutar);
    }
}
