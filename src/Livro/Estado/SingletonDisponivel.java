package Livro.Estado;

import Livro.Livro;
import Livro.Exemplar;
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
    public boolean emprestarLivro(Exemplar exemplar, User user) {
        user.adicionaNaListaDeEmprestados(exemplar);
        exemplar.mudaEstado(SingletonEmprestado.getInstance());
        System.out.println("Livro Emprestado com sucesso");
        return true;
    }

    @Override
    public boolean devolverLivro(Exemplar exemplar, User user) {
        System.out.println("Você não pode devolver um exemplar que está disponível.");
        return false;
    }

    @Override
    public boolean reservarLivro(Exemplar exemplar, User user) {
        user.adicionaNaListaDeEmprestados(exemplar);
        exemplar.mudaEstado(SingletonReservado.getInstance());
        System.out.println("Livro Adicionado na Lista de Reservados do usuário.");
        return true;
    }
}
