package Usuario.Estado;

import Livro.Livro;
import Usuario.Usuario;

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
    public void pegarLivroEmprestado(Livro livro, Usuario usuario) {
        MetodosGeraisDeUsuarios.emprestimoParaAlunos(livro, usuario, this.getQuantidadeDeLivrosMaximaEmprestimo());
    }

    @Override
    public void devolverLivroEmprestado(Livro livro, Usuario usuario) {
        livro.devolverLivroEmprestado(usuario);
    }

    @Override
    public void reservarLivro(Livro livro, Usuario usuario) { //Caio
        MetodosGeraisDeUsuarios.reservaParaUsuario(livro, usuario);
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
