package Comando;

import java.util.ArrayList;

public class Consulta implements Comando {
    @Override
    public void executar(ArrayList<String> parametroParaExecutar) {
        FachadaBiblioteca.getInstance().realizarConsultaLivro(parametroParaExecutar);
    }
}
