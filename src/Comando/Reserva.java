package Comando;

import InteracaoComUsuario.FachadaBiblioteca;

import java.util.ArrayList;

//comando concreto de reserva
public class Reserva implements Comando {
    @Override
    public void executar(ArrayList<String> parametroParaExecutar) {
        //chama a função de realizar reserva na fachada
        FachadaBiblioteca.getInstance().realizarReserva(parametroParaExecutar);
    }
}
