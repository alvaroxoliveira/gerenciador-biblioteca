package Usuario.Estado;
import Comando.BuscaLivro;
import Livro.Livro;
import Usuario.User;
import Livro.Exemplar;

public class AlunoGraduacao implements IEstadoUsuario {
    private AlunoGraduacao() {}

    public static AlunoGraduacao instance; //cada livro só vai ter uma instancia de cada estado

    public static AlunoGraduacao getInstance() { //se não existir instancia, cria uma
        if(instance == null) {
            synchronized(AlunoGraduacao.class) {
                if(instance == null) {
                    instance = new AlunoGraduacao();
                }
            }
        }
        return instance;
    }

    @Override
    public void pegarLivroEmprestado(String codigoDoLivro, User user) {
        if(user.getListaDeLivrosEmprestados().size() < 3) {
            BuscaLivro.getLivro(codigoDoLivro).pegarExemplarEmprestado(user);
        } else {
            System.out.println("Usuário ja tem a quantidade máxima de livros emprestados");
            return;
        }
    }

    @Override
    public void devolverLivroEmprestado(String codigoDoLivro, User user) {
        BuscaLivro.getLivro(codigoDoLivro).devolverLivroEmprestado(user);
    }

    //faz a reserva de um livro passando o código e o usuário que vai a fazer
    @Override
    public void reservarLivro(String codigoDoLivro, User user) { //Caio
        //testa se o usuário tem menos de 3 livros reservados
        if(user.getListaDeReservados().size() < 3) {
            //caso possa, chama o método de reservar exemplar na classe do livro
            BuscaLivro.getLivro(codigoDoLivro).reservarExemplar(user);
        } else {
            System.out.println("Usuário ja tem a quantidade máxima de livros reservados");
            return;
        }
    }

    //metodo polimorfico para saber a qtd de dia de cada tipo de usuario
    @Override
    public int diasParaEntrega() {
        return 3;
    }

}
