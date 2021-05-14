package Estado;

import Livro.Livro;

public class SingletonEmprestado implements EstadoLivro {
    private SingletonEmprestado() {}

    public static SingletonEmprestado instance;

    public static SingletonEmprestado getInstance() {
        if(instance == null) {
            synchronized(SingletonEmprestado.class) {
                if(instance == null) {
                    instance = new SingletonEmprestado();
                }
            }
        }
        return instance;
    }

    @Override
    public void devolverLivro(Livro livro) {
        livro.mudarEstado(SingletonDisponivel.getInstance());
        System.out.println("Devolução concluída com sucesso.");
    }

    @Override
    public void emprestarLivro(Livro livro) {
        System.out.println("Não é possível fazer empréstimo de um livro emprestado.");
    }

    @Override
    public void reservarLivro(Livro livro) {
        System.out.println("Não é possível fazer reserva de um livro emprestado.");
    }
}
