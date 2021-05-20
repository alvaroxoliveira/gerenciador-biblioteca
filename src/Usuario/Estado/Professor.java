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

    @Override
    public void devolverLivroEmprestado(String codigoDoLivro, User user) {

    }

    @Override
    public void reservarLivro(String codigoDoLivro, User user) { //Caio
        if(user.getListaDeReservados().size() < 3) {
            BuscaLivro.getLivro(codigoDoLivro).reservarExemplar(user);
        } else {
            System.out.println("Usuário ja tem a quantidade máxima de livros reservados");
            return;
        }
    }
}
