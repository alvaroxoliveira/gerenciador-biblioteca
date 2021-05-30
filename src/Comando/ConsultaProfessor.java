package Comando;

/*
* Comando de consulta de quantidade de notificações que o professor recebeu no contexto do programa.
* */

import InteracaoComUsuario.FachadaBiblioteca;

import java.util.ArrayList;

public class ConsultaProfessor implements Comando{
    @Override
    public void executar(ArrayList<String> parametroParaExecutar) {
        FachadaBiblioteca.getInstance().realizarConsultaObserver(parametroParaExecutar);
    }
}
