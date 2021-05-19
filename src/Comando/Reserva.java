package Comando;

import java.util.ArrayList;

//comando concreto de reserva
public class Reserva implements Comando {
    @Override
    public void executar(ArrayList<String> parametroParaExecutar) {
        FachadaBiblioteca.getInstance().realizarReserva(parametroParaExecutar);
    }
}
