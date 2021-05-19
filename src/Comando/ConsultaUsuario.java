package Comando;

import java.util.ArrayList;

//comando concreto de consulta emprestimos
public class ConsultaUsuario implements Comando{
    @Override
    public void executar(ArrayList<String> parametroParaExecutar) {
        FachadaBiblioteca.getInstance().realizarConsultaUsuario(parametroParaExecutar);
    }
}
