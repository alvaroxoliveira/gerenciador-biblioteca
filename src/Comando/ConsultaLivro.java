package Comando;

/*
* Comando de consulta das informações de um livro
* */
import InteracaoComUsuario.FachadaBiblioteca;
import java.util.ArrayList;

public class ConsultaLivro implements Comando {
    @Override
    public void executar(ArrayList<String> parametroParaExecutar) {
        FachadaBiblioteca.getInstance().realizarConsultaLivro(parametroParaExecutar);
    }
}
