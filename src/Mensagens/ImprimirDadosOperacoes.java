package Mensagens;

import Transacoes.TransacaoEmprestimo;
import Transacoes.TransacaoReserva;
import Usuario.User;

public class ImprimirDadosOperacoes {
    public static void imprimirDadosDeEmprestimosAtuais(TransacaoEmprestimo transacaoEmprestimo) {
        System.out.println("Titulo: " + transacaoEmprestimo.getExemplar().getTitulo());
        System.out.println("Data do empréstimo: " + transacaoEmprestimo.getData());
        System.out.println("Estado: Em Curso");
        System.out.println("Data de devolução: " + transacaoEmprestimo.getData().plusDays(transacaoEmprestimo.getUsuario().getEstadoUsuario().diasParaEntrega()));
    }

    //metodo para imprimir os emprestimos finalizados do usuario passado
    public static void imprimirDadosEmprestimosFinalizados(TransacaoEmprestimo transacaoEmprestimo) {
        System.out.println("Titulo: " + transacaoEmprestimo.getExemplar().getTitulo());
        System.out.println("Data do empréstimo: " + transacaoEmprestimo.getData());
        System.out.println("Estado: Finalizado");
        System.out.println("Data de devolução: " + transacaoEmprestimo.getData().plusDays(transacaoEmprestimo.getUsuario().getEstadoUsuario().diasParaEntrega()));
        }

    public static void imprimirDadosDeReservas(TransacaoReserva transacaoReserva) {
        System.out.println("Titulo: " + transacaoReserva.getLivro().getTitulo());
        System.out.println("Data da reserva: " + transacaoReserva.getData());
    }
}
