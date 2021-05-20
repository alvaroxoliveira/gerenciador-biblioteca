package Livro.Estado;

import Livro.Livro;
import Livro.Exemplar;
import Usuario.User;

public class SingletonEmprestado implements IEstadoLivro {
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
