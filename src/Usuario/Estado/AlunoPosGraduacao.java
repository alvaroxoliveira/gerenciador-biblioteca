package Usuario.Estado;

import Livro.Livro;
import Usuario.User;

public class AlunoPosGraduacao implements IEstadoUsuario {
    private AlunoPosGraduacao() {}

    public static AlunoPosGraduacao instance; //cada aluno só vai ter uma instancia de cada estado
    private final int quantidadeDeLivrosMaximaEmprestimo = 4;

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
    public void pegarLivroEmprestado(Livro livro, User user) {
        MetodosGeraisDeUsuarios.emprestimoParaAlunos(livro, user, this.getQuantidadeDeLivrosMaximaEmprestimo());
    }

    @Override
    public void devolverLivroEmprestado(Livro livro, User user) {
        livro.devolverLivroEmprestado(user);
    }

    @Override
    public void reservarLivro(Livro livro, User user) { //Caio
        MetodosGeraisDeUsuarios.reservaParaUsuario(livro, user);
    }
    
    //metodo polimorfico para saber a qtd de dia de cada tipo de usuario
    @Override
    public int diasParaEntrega() {
        return 4;
    }

    public int getQuantidadeDeLivrosMaximaEmprestimo() {
        return quantidadeDeLivrosMaximaEmprestimo;
    }
}
