package Comando;

public class Emprestimo implements Comando {

    @Override
    public void executar() {
        FachadaBiblioteca.getInstance().realizarEmprestimo();
    }
}
