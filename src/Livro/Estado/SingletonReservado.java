package Livro.Estado;

import Livro.Livro;

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
    public void emprestarLivro(Livro livro) {
        System.out.println("Não é possível devolver um livro reservado. Pegue-o Emprestado primeiro");
    }

    @Override
    public void reservarLivro(Livro livro) {
        //livro.mudarEstado(SingletonReservado.getInstance()); //livro pode ser reservado por mais de 1 pessoa?
        System.out.println("Reserva concluída com sucesso.");
    }

    // Verificar se a devolução no caso de reserva faz sentido
    @Override
    public void devolverLivro(Livro livro) {
        livro.mudarEstado(SingletonDisponivel.getInstance());
        System.out.println("Empréstimo concluído com sucesso.");
    }
}
