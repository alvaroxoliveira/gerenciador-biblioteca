package MensagensConsole;

import Livro.Livro;
import Usuario.Usuario;

public class MensagensUser {

    /*
    * Imprime o nome do usuário
    * */
    public static void imprimirNomeUsuario(Usuario usuario) {
        System.out.println(usuario.getNome());
    }

    /*
    * Mensagem de aviso de não existência do livro.
    * */
    public static void mensagemDeNaoExistenciaDeExemplar(Livro livro) {
        System.out.println("Não existe exemplar do livro "+ livro.getTitulo() + ".");
    }

    /*
    * Mensagem de aviso que o usuário ja tem um livro com um determinado estado.
    * Quando for reservar o método que usa essa mensagem verifica se o usuário ja tem o livro reservado
    * e se ja o tiver essa mensagem é exibida.
    * Quando for pegar emprestado verifica se o usuário ja tem o livro emprestado e se ja o tiver essa
    * mensagem é exibida.
    * */
    public static void mensagemOperacaoJaFeitaComLivro(Livro livro, Usuario usuario, String estado) {
        System.out.println("Usuário " + usuario.getNome() + " ja tem um exemplar do livro " + livro.getTitulo() + " " + estado);
    }

    /*
    * Mensagem de aviso que o usuário está inadimplente com a biblioteca.
    * */
    public static void mensagemDeInadimplencia(Usuario usuario) {
        System.out.println("O usuário " + usuario.getNome() + " é devedor na Biblioteca");
    }

    /*
    * Mensagem que informa erro quando o Usuário quer devolver um livro mas este não tem um livro na sua
    * lista de empréstimos.
    * */
    public static void mensagemNaoHaLivroParaDevolver(Usuario usuario) {
        System.out.println("Usuário " + usuario.getNome() + " não têm livros para devolver.");
    }

    /*
    * Mensagem que informa que o livro passado não está na lista de livros emprestado pelo usuário.
    * Ocorre quando na entrada do usuário, este passa um livro conhecido pelo sistema mas por sua vez
    * o usuário não tem um exemplar na sua lista de empréstimos.
    * */
    public static void mensagemLivroNaoEstaNaListaDeEmprestados(Livro livro, Usuario usuario) {
        System.out.println("O livro " + livro.getTitulo() + " não está na lista de emprestados do usuário " + usuario.getNome() + ".");
    }

    /*
    * Mensagem de aviso quando não houve nenhuma operação feita com livros no sistema, nem emprétimos e nem
    * reservas.
    * */
    public static void mensagemDeNaoExistenciaDeOperacoes() {
        System.out.println("Não há empréstimos ativos, empréstimos finalizados ou reservas.");
    }
}
