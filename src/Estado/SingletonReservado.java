package Estado;

import Livro.Livro;

public class SingletonReservado implements EstadoLivro {
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
        System.out.println("Não é possível devolver um livro disponível.");
    }

    @Override
    public void reservarLivro(Livro livro) {
        livro.mudarEstado(SingletonReservado.getInstance());
        System.out.println("Reserva concluída com sucesso.");
    }

    // Verificar se a devolução no caso de reserva faz sentido
    @Override
    public void devolverLivro(Livro livro) {
        livro.mudarEstado(SingletonDisponivel.getInstance());
        System.out.println("Empréstimo concluído com sucesso.");
    }
}
