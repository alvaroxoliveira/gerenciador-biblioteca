package Comando;

public class Emprestimo implements Comando {

    @Override
    public void executar(String parametro1, String parametro2) {
        FachadaBiblioteca.getInstance().realizarEmprestimo(parametro1, parametro2);
    }
}
