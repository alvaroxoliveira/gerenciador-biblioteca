package Livro.Estado;

import Livro.Exemplar;
import MensagensConsole.MensagensSingletonDisponivel;
import Transacoes.TransacaoEmprestimo;
import Transacoes.TransacaoReserva;
import Usuario.User;

public class SingletonDisponivel implements IEstadoLivro {
    private SingletonDisponivel() {}

    public static SingletonDisponivel instance; //cada livro só vai ter uma instancia de cada estado

    public static SingletonDisponivel getInstance() { //se não existir instancia, cria uma
        if(instance == null) {
            synchronized(SingletonDisponivel.class) {
                if(instance == null) {
                    instance = new SingletonDisponivel();
                }
            }
        }
        return instance;
    }

    @Override
    public void emprestarLivro(Exemplar exemplar, User user) {
        user.adicionaNaListaDeEmprestados(exemplar);
        if(user.verificaSeJaTemOLivroReservado(exemplar.getLivro())){ //caso o usuario tenha o livro reservado
            user.removeDaListaDeReservados(exemplar.getLivro()); //remove o livro a partir do exemplar da lista de reservados
            TransacaoReserva.FinalizarReserva(exemplar.getLivro(), user); //chama o método de remover da lista de transacoes (reserva)
        }
        exemplar.mudaEstado(SingletonEmprestado.getInstance());
        TransacaoEmprestimo.adicionarEmprestimoAtual(exemplar, user);
        MensagensSingletonDisponivel.mensagemEmprestimoDoLivroFeito(user.getNome(), exemplar.getLivro().getTitulo());
    }

    @Override
    public void devolverLivro(Exemplar exemplar, User user) {
        MensagensSingletonDisponivel.mensagemNaoDevolverPoqueEstaDisponivel();
    }

    //método para imprimir o estado na consulta
    @Override
    public String imprimirEstado() {
        return "Disponivel.";
    }
}
