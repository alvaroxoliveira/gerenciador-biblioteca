package Livro.Estado;

import Livro.Livro;
import Livro.Exemplar;
import Usuario.User;

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
    public boolean emprestarLivro(Exemplar exemplar, User user) {
        return false;
    }

    @Override
    public boolean devolverLivro(Exemplar exemplar, User user) {
        return false;
    }

    @Override
    public boolean reservarLivro(Exemplar exemplar, User user) {
        return false;
    }
}
