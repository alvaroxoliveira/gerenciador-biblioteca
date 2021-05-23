package Mensagens;

import Transacoes.TransacaoEmprestimo;
import Transacoes.TransacaoReserva;

public class ImprimirDadosOperacoes {
    public static void imprimirDadosDeEmprestimos(TransacaoEmprestimo transacaoEmprestimo) {
        System.out.println("Titulo: " + transacaoEmprestimo.getExemplar().getTitulo());
        System.out.println("Data do empréstimo: " + transacaoEmprestimo.getData());
        System.out.println("Estado: Finalizado");
        System.out.println("Data do devolução: " + transacaoEmprestimo.getData().plusDays(transacaoEmprestimo.getUsuario().getEstadoUsuario().diasParaEntrega()));
    }

    public static void imprimirDadosDeReservas(TransacaoReserva transacaoReserva) {
        System.out.println("Titulo: " + transacaoReserva.getLivro().getTitulo());
        System.out.println("Data da reserva: " + transacaoReserva.getData());
    }
}
