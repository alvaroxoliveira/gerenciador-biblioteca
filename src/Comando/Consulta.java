package Comando;

public class Consulta implements Comando {
    @Override
    public void executar() {
        FachadaBiblioteca.getInstance().realizarConsultaLivro();
    }
}
