package Livro.Estado;

import Livro.Transacao;
import Livro.Livro;
import Livro.Exemplar;
import Usuario.User;

import java.util.concurrent.ThreadLocalRandom;

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
        exemplar.mudaEstado(SingletonEmprestado.getInstance());

        //coloca no vetor de emprestimos
        Transacao.adicionarEmprestimoAtual(exemplar, user);

        System.out.println("Livro Emprestado com sucesso");
    }

    @Override
    public void devolverLivro(Exemplar exemplar, User user) {
        System.out.println("Você não pode devolver um exemplar que está disponível.");
    }

    //faz a reserva de um exemplar, recebendo o exemplar e o usuário
    @Override
    public void reservarLivro(Exemplar exemplar, User user) {
        //adiciona o exemplar na lista de reservados do usuário
        user.adicionaNaListaDeReservados(exemplar);
        //muda o estado do livro para reservado
        exemplar.mudaEstado(SingletonReservado.getInstance());

        //coloca no vetor de reservas
        Transacao.adicionarReserva(exemplar, user);

        System.out.println("Livro Adicionado na Lista de Reservados do usuário.");
    }

    //método para imprimir o estado na consulta
    @Override
    public String imprimirEstado() {
        return "Disponivel.";
    }
}
