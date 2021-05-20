package Usuario.Estado;

import Comando.BuscaLivro;
import Usuario.User;

public class Professor implements IEstadoUsuario {
    private Professor() {}
    public static Professor instance; //cada livro só vai ter uma instancia de cada estado
    public static Professor getInstance() { //se não existir instancia, cria uma
        if(instance == null) {
            synchronized(Professor.class) {
                if(instance == null) {
                    instance = new Professor();
                }
            }
        }
        return instance;
    }

    @Override
    public void pegarLivroEmprestado(String codigoDoLivro, User thisUser) {
        BuscaLivro.getLivro(codigoDoLivro).pegarExemplarEmprestado(thisUser);
    }
}
