package MensagensConsole;

import Transacoes.TransacaoReserva;

public class MensagensTransacaoReserva {

    public static void mensagemTransacaoReservaDoLivro(TransacaoReserva transacaoReserva) {
        System.out.println("Reserva do livro " + transacaoReserva.getLivro().getId() + " feita por " + transacaoReserva.getUsuario().getNome() + ".");
    }
}
