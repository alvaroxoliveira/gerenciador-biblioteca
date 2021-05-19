package Comando;

import java.util.ArrayList;

//comando concreto de devolução
public class Devolucao implements Comando {
    @Override
    public void executar(ArrayList<String> parametroParaExecutar) {
        FachadaBiblioteca.getInstance().realizarDevolucao(parametroParaExecutar);
    }
}
