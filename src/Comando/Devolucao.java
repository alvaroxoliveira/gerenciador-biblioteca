package Comando;

public class Devolucao implements Comando {
    @Override
    public void executar() {
        FachadaBiblioteca.getInstance().realizarDevolucao();
    }
}
