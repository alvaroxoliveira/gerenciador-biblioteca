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
    public void pegarLivroEmprestado(String codigoDoLivro, User thisUser) {
        if(thisUser.getListaDeLivrosEmprestados().size() < 3) {
            BuscaLivro.getLivro(codigoDoLivro).pegarExemplarEmprestado(thisUser);
        } else {
            System.out.println("Usuário ja tem a quantidade máxima de livros emprestados");
            return;
        }
    }
}
