package Usuario.Estado;

import Livro.Livro;
import Usuario.Usuario;

public class AlunoGraduacao implements IEstadoUsuario {
    private AlunoGraduacao() {}
    private final int quantidadeDeLivrosMaximaEmprestimo = 3;
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
    public void pegarLivroEmprestado(Livro livro, Usuario usuario) {
        MetodosGeraisDeUsuarios.emprestimoParaAlunos(livro, usuario, this.getQuantidadeDeLivrosMaximaEmprestimo()); // Metodo chamado está em Metodos em comum
    }

    @Override
    public void devolverLivroEmprestado(Livro livro, Usuario usuario) {
        livro.devolverLivroEmprestado(usuario);
    }

    //faz a reserva de um livro passando o código e o usuário que vai a fazer
    @Override
    public void reservarLivro(Livro livro, Usuario usuario) { //Caio
        MetodosGeraisDeUsuarios.reservaParaUsuario(livro, usuario);
    }

    //metodo polimorfico para saber a qtd de dia de cada tipo de usuario
    @Override
    public int diasParaEntrega() {
        return 3;
    }

    public int getQuantidadeDeLivrosMaximaEmprestimo() {
        return quantidadeDeLivrosMaximaEmprestimo;
    }
}
