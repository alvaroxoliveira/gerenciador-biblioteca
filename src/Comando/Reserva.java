package Comando;

/*
* Comando de reserva de um livro por um usuário.
* */

import InteracaoComUsuario.FachadaBiblioteca;

import java.util.ArrayList;

public class Reserva implements Comando {
    @Override
    public void executar(ArrayList<String> parametroParaExecutar) {
        //chama a função de realizar reserva na fachada
        FachadaBiblioteca.getInstance().realizarReserva(parametroParaExecutar);
    }
}
