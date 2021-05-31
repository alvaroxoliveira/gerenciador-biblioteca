package Usuario.Estado;

/*
* Singleton de definição do Usuário do Tipo Aluno de Pós Graduação, tendo como base o Padrão de Projeto State
* aprendido em aula.
* */

import Livro.Livro;
import MensagensConsole.MensagensNaoObservers;
import Observer.Observer;
import Usuario.Usuario;

public class AlunoPosGraduacao implements IEstadoUsuario {
    private AlunoPosGraduacao() {}

    public static AlunoPosGraduacao instance;
    private final int quantidadeDeLivrosMaximaEmprestimo = 4;

    public static AlunoPosGraduacao getInstance() {
        if(instance == null) {
            synchronized(AlunoPosGraduacao.class) {
                if(instance == null) {
                    instance = new AlunoPosGraduacao();
                }
            }
        }
        return instance;
    }

    /*
     * Método público que tem a função de chamar o método de pegar um livro emprestado no objeto livro.
     * */
    @Override
    public void pegarLivroEmprestado(Livro livro, Usuario usuario) {
        MetodosGeraisDeUsuarios.emprestimoParaAlunos(livro, usuario, this.getQuantidadeDeLivrosMaximaEmprestimo());
    }

    /*
    * Método público que tem a função de chamar o método do livro de devolver o livro emprestado.
    * */
    @Override
    public void devolverLivroEmprestado(Livro livro, Usuario usuario) {
        livro.devolverLivroEmprestado(usuario);
    }

    /*
    * Método público que tem a função de chamar método de reservar um livro na Classe MétodosGeraisDeUsuarios.
    * */
    @Override
    public void reservarLivro(Livro livro, Usuario usuario) { //Caio
        MetodosGeraisDeUsuarios.reservaParaUsuario(livro, usuario);
    }

    /*
     * Método público que retorna a quantidade de dias de entrega referente a cada tipo de usuário
     * */
    @Override
    public int diasParaEntrega() {
        return 4;
    }

    /*
     * Método público que tenta adicionar um livro na lista de observer
     * */
    @Override
    public void adicionarObserver(Livro livro, Observer observer, Usuario usuario) {
        MensagensNaoObservers.mensagemErroAdicaoListaDeObservadores(livro, usuario);
    }

    /*
     * Método público de consulta específica para um usuário observer da quantidade de notificações que recebeu
     * das notificações de reservas simultâneas ( > 2) do livro.
     * */
    @Override
    public void consultarObserver(Usuario usuario) {
        MensagensNaoObservers.mensagemErroConsultaObserver(usuario);
    }

    /*
    * Método público que retorna a quantidade máximade livros que podem ser emprestados dos usuários
    * (Para Alunos de Graduação e Pós-Graduação).
    * */
    public int getQuantidadeDeLivrosMaximaEmprestimo() {
        return quantidadeDeLivrosMaximaEmprestimo;
    }
}
