package Comando;

public class Consulta implements Comando {
    @Override
    public void executar(String parametro1, String parametro2) {
        FachadaBiblioteca.getInstance().realizarConsultaLivro(parametro1, parametro2);
    }
}
