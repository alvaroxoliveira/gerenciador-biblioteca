package Comando;

import java.util.ArrayList;

public class Emprestimo implements Comando {

    @Override
    public void executar(ArrayList<String> parametroParaExecutar) {
        FachadaBiblioteca.getInstance().realizarEmprestimo(parametroParaExecutar);
    }
}
