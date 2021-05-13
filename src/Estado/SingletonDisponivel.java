package Estado;

import Livro.Livro;

public class SingletonDisponivel implements EstadoLivro{
    private SingletonDisponivel() {}

    public static SingletonDisponivel instance;

    public static SingletonDisponivel getInstance() {
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
    public void devolverLivro(Livro livro) {
        System.out.println("Desconectando...");
        livro.mudarEstado(SingletonDisponivel.getInstance());
    }
    @Override
    public void emprestarLivro(Livro livro) {
        livro.mudarEstado(SingletonEmprestado.getInstance());
        System.out.println("Empréstimo concluído com sucesso.");
    }
    @Override
    public void reservarLivro(Livro livro) {
        livro.mudarEstado(SingletonReservado.getInstance());
        System.out.println("Reserva concluída com sucesso.");
    }
}
