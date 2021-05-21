package Livro.Estado;

import Livro.Transacao;
import Livro.Livro;
import Livro.Exemplar;
import Usuario.User;

import java.util.concurrent.ThreadLocalRandom;

public class SingletonReservado implements IEstadoLivro {
    private SingletonReservado() {}

    public static SingletonReservado instance;

    public static SingletonReservado getInstance() {
        if(instance == null) {
            synchronized(SingletonReservado.class) {
                if(instance == null) {
                    instance = new SingletonReservado();
                }
            }
        }
        return instance;
    }

    @Override
    public void emprestarLivro(Exemplar exemplar, User user) {
        user.adicionaNaListaDeEmprestados(exemplar);
        exemplar.mudaEstado(SingletonEmprestado.getInstance());

        Transacao.adicionarEmprestimoAtual(exemplar, user);
        Transacao.FinalizarReserva(exemplar);

        System.out.println("Livro Emprestado com sucesso");
    }

    @Override
    public void devolverLivro(Exemplar exemplar, User user) {
        System.out.println("Não há como devolver um livro reservado.");
    }

    @Override
    public void reservarLivro(Exemplar exemplar, User user) {
        System.out.println("Não da pra reservar um livro que já está reservado.");
    }

    //método para imprimir o estado na consulta
    @Override
    public String imprimirEstado() {
        return "Disponivel"; //como os estados são impressos como emprestado ou disponivel, aqui fica assim
    }
}
