package Comando;

public class Reserva implements Comando {
    @Override
    public void executar() {
        FachadaBiblioteca.getInstance().realizarReserva();
    }
}
