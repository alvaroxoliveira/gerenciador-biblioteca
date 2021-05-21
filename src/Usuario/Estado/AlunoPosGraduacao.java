package Usuario.Estado;

import Comando.BuscaLivro;
import Livro.Estado.IEstadoLivro;
import Livro.Livro;
import Usuario.User;

public class AlunoPosGraduacao implements IEstadoUsuario {
    private AlunoPosGraduacao() {}

    public static AlunoPosGraduacao instance; //cada aluno só vai ter uma instancia de cada estado

    public static AlunoPosGraduacao getInstance() { //se não existir instancia, cria uma
        if(instance == null) {
            synchronized(AlunoPosGraduacao.class) {
                if(instance == null) {
                    instance = new AlunoPosGraduacao();
                }
            }
        }
        return instance;
    }

    @Override
    public void pegarLivroEmprestado(String codigoDoLivro, User thisUser) {
        if(thisUser.getListaDeLivrosEmprestados().size() < 4) {
            BuscaLivro.getLivro(codigoDoLivro).pegarExemplarEmprestado(thisUser);
        } else {
            System.out.println("Usuário ja tem a quantidade máxima de livros emprestados");
            return;
        }
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

    //metodo polimorfico para saber a qtd de dia de cada tipo de usuario
    @Override
    public int diasParaEntrega() {
        return 4;
    }
}
