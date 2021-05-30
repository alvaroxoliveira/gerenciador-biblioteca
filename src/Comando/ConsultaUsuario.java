package Comando;

/*
* Comando de consulta de empréstimos feitos pelo usuário.
* */

import InteracaoComUsuario.FachadaBiblioteca;
import java.util.ArrayList;

public class ConsultaUsuario implements Comando{
    @Override
    public void executar(ArrayList<String> parametroParaExecutar) {
        FachadaBiblioteca.getInstance().realizarConsultaUsuario(parametroParaExecutar);
    }
}
