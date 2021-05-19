package Comando;

import java.util.ArrayList;

//comando concreto de consulta qtd de notificacoes
public class ConsultaProfessor implements Comando{
    @Override
    public void executar(ArrayList<String> parametroParaExecutar) {
        FachadaBiblioteca.getInstance().realizarConsultaProfessor(parametroParaExecutar);
    }
}
