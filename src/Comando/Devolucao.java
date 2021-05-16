package Comando;

public class Devolucao implements Comando {
    @Override
    public void executar(String parametro1, String parametro2) {
        FachadaBiblioteca.getInstance().realizarDevolucao(parametro1, parametro2);
    }
}
