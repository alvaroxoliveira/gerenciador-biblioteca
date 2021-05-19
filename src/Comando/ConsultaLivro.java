package Comando;

import java.util.ArrayList;

//comando concreto de consulta info de livro
public class ConsultaLivro implements Comando {
    @Override
    public void executar(ArrayList<String> parametroParaExecutar) {
        FachadaBiblioteca.getInstance().realizarConsultaLivro(parametroParaExecutar);
    }
}
