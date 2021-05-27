package Usuario.Estado;

import Livro.Livro;
import Usuario.User;

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
    public void pegarLivroEmprestado(Livro livro, User user) {
        MetodosGeraisDeUsuarios.emprestimoParaAlunos(livro, user, this.getQuantidadeDeLivrosMaximaEmprestimo()); // Metodo chamado está em Metodos em comum
    }

    @Override
    public void devolverLivroEmprestado(Livro livro, User user) {
        livro.devolverLivroEmprestado(user);
    }

    //faz a reserva de um livro passando o código e o usuário que vai a fazer
    @Override
    public void reservarLivro(Livro livro, User user) { //Caio
        MetodosGeraisDeUsuarios.reservaParaUsuario(livro, user);
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
