package MensagensConsole;

import Livro.Exemplar;
import Livro.Livro;
import Transacoes.TransacaoEmprestimo;
import Transacoes.TransacaoReserva;

import java.util.ArrayList;

public class ImprimeDadosLivro {
    public static void imprimeCabecalho(Livro livro) {
        System.out.println("Título: " + livro.getTitulo());
        //passa o próprio livro e usa o vetor de reservas para saber quantos exemplares estão reservados
        System.out.println("Quantidade de reservas: " + TransacaoReserva.quantidadeReserva(livro));
    }

    public static void imprimeInformacoesDosExemplaresEmprestados(ArrayList<Exemplar> exemplares) {
        System.out.println("Exemplares: ");
        imprimeDadosDosExemplares(exemplares);
    }

    // Função para imprimir dados dos exemplares
    private static void imprimeDadosDosExemplares(ArrayList<Exemplar> exemplares) {
        for(Exemplar exemplar: exemplares){
            System.out.println("Código: " + exemplar.getCodigoExemplar());
            //usa o método polimorfico para imprimir o estado do livro
            System.out.println("Estado: " + exemplar.getEstadoExemplar().imprimirEstado());
            //commpara o exemplar atual com os exemplares na lista de emprestimos ativos
            imprimeDadosDeEmprestimos(exemplar);
        }
    }

    private static void imprimeDadosDeEmprestimos(Exemplar exemplar) {
        for(TransacaoEmprestimo transacaoEmprestimo : TransacaoEmprestimo.getEmprestimosAtuais()){
            //caso o exemplar esteja emprestado, imprime as informações
            if(exemplar.getCodigoExemplar().equals(transacaoEmprestimo.getExemplar().getCodigoExemplar())){
                System.out.println("Usuario: " + transacaoEmprestimo.getUsuario().getNome());
                System.out.println("Data de emprestimo: " + transacaoEmprestimo.getData());
                //soma a data do emprestimo com a quantidade de dias expresso no metodo polimorfico correspondente a cada usuario
                System.out.println("Data de entrega: " + transacaoEmprestimo.getData().plusDays(transacaoEmprestimo.getUsuario().getEstadoUsuario().diasParaEntrega()));
            }
        }
    }
}
