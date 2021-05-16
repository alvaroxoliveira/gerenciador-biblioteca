package Comando;

public class Reserva implements Comando {
    @Override
    public void executar(String parametro1, String parametro2) {
        FachadaBiblioteca.getInstance().realizarReserva(parametro1, parametro2);
    }
}
