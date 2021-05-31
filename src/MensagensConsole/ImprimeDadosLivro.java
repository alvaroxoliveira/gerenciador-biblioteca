package MensagensConsole;

import Livro.Exemplar;
import Livro.Livro;
import Transacoes.TransacaoEmprestimo;
import Transacoes.TransacaoReserva;

import java.util.ArrayList;

public class ImprimeDadosLivro {
    /*
    * Método público que imprime o cabeçalho da consulta do Livro.
    * */
    public static void imprimeCabecalho(Livro livro) {
        System.out.println("Título: " + livro.getTitulo());
        System.out.println("Quantidade de reservas: " + TransacaoReserva.quantidadeReserva(livro));
    }

    /*
    * Método público que tem a função a impressão das informações dos exemplares emprestado. Usa um método
    * auxiliar para imprimir os dados dos exemplares.
    * */
    public static void imprimeInformacoesDosExemplaresEmprestados(ArrayList<Exemplar> exemplares) {
        System.out.println("Exemplares: ");
        imprimeDadosDosExemplares(exemplares);
    }

    /*
    * Método privado para impressão dos dados de uma lista de Exemplares
    * */
    private static void imprimeDadosDosExemplares(ArrayList<Exemplar> exemplares) {
        for(Exemplar exemplar: exemplares){
            System.out.println("Código: " + exemplar.getCodigoExemplar());
            System.out.println("Estado: " + exemplar.getEstadoExemplar().imprimirEstado());
            imprimeDadosDeEmprestimos(exemplar);
        }
    }

    /*
    * Método privado Imprime os dados dos Empréstimos em andamento. É um método auxiliar chamado para
    * imprimir os dados dos empréstimos em curso do Exemplar.
    * */
    private static void imprimeDadosDeEmprestimos(Exemplar exemplar) {
        for(TransacaoEmprestimo transacaoEmprestimo : TransacaoEmprestimo.getEmprestimosAtuais()){
            if(exemplar.getCodigoExemplar().equals(transacaoEmprestimo.getExemplar().getCodigoExemplar())){
                System.out.println("Usuario: " + transacaoEmprestimo.getUsuario().getNome());
                System.out.println("Data de emprestimo: " + transacaoEmprestimo.getData());
                System.out.println("Data de entrega: " + transacaoEmprestimo.getData()
                        .plusDays(transacaoEmprestimo.getUsuario().getEstadoUsuario().diasParaEntrega()));
            }
        }
    }
}
