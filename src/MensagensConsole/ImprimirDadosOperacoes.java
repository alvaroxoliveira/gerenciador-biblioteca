package MensagensConsole;

import Transacoes.TransacaoEmprestimo;
import Transacoes.TransacaoReserva;

public class ImprimirDadosOperacoes {
    // 1 função para os dois casos ao invés de usar as duas de cima

    private static String retornaStringDeEstado(TransacaoEmprestimo transacaoEmprestimo) {
        if(transacaoEmprestimo.isEstaFinalizado()) {
            return "Finalizado";
        }
        return "Em curso";
    }

    public static void imprimirDadosEmprestimos(TransacaoEmprestimo transacaoEmprestimo) {
        String estadoDaTransacao = retornaStringDeEstado(transacaoEmprestimo);
        System.out.println("Titulo: " + transacaoEmprestimo.getExemplar().getLivro().getTitulo());
        System.out.println("Data do empréstimo: " + transacaoEmprestimo.getData());
        System.out.println("Estado: " + estadoDaTransacao);
        System.out.println("Data de devolução: " + transacaoEmprestimo.getData().plusDays(transacaoEmprestimo.getUsuario().getEstadoUsuario().diasParaEntrega()));
    }

    public static void imprimirDadosDeReservas(TransacaoReserva transacaoReserva) {
        System.out.println("Titulo: " + transacaoReserva.getLivro().getTitulo());
        System.out.println("Data da reserva: " + transacaoReserva.getData());
    }
}
