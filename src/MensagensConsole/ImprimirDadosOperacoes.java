package MensagensConsole;

import Transacoes.TransacaoEmprestimo;
import Transacoes.TransacaoReserva;

public class ImprimirDadosOperacoes {

    /*
    * Método privado que define o estado de acordo com o estado da transação chamado ao imprimir dados de
    * empréstimos.
    * */
    private static String retornaStringDeEstado(TransacaoEmprestimo transacaoEmprestimo) {
        if(transacaoEmprestimo.isEstaFinalizado()) {
            return "Finalizado";
        }
        return "Em curso";
    }

    /*
    * Método público que imprime os dados de empréstimos ao fazer consultas.
    * */
    public static void imprimirDadosEmprestimos(TransacaoEmprestimo transacaoEmprestimo) {
        String estadoDaTransacao = retornaStringDeEstado(transacaoEmprestimo);
        System.out.println("Titulo: " + transacaoEmprestimo.getExemplar().getLivro().getTitulo());
        System.out.println("Data do empréstimo: " + transacaoEmprestimo.getData());
        System.out.println("Estado: " + estadoDaTransacao);
        System.out.println("Data de devolução: " + transacaoEmprestimo.getData().plusDays(transacaoEmprestimo.getUsuario().getEstadoUsuario().diasParaEntrega()));
    }

    /*
    * Método público que imprime dados de reservas ao fazer consultas.
    * */
    public static void imprimirDadosDeReservas(TransacaoReserva transacaoReserva) {
        System.out.println("Titulo: " + transacaoReserva.getLivro().getTitulo());
        System.out.println("Data da reserva: " + transacaoReserva.getData());
    }
}
