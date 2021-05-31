package MensagensConsole;

import Livro.Livro;

public class MensagensUser {
    public static void imprimirNomeUsuario(String nomeUser) {
        System.out.println(nomeUser);
    }

    public static void mensagemDeNaoExistenciaDeExemplar(String titulo) {
        System.out.println("Não existe exemplar do livro "+ titulo + ".");
    }

    public static void mensagemOperacaoJaFeitaComLivro(Livro livro, String nomeUser, String estado) {
        System.out.println("Usuário " + nomeUser + " ja tem um exemplar do livro " + livro.getTitulo() + " " + estado);
    }

    public static void mensagemDeInadimplencia(String nomeUser) {
        System.out.println("O usuário " + nomeUser + " é devedor na Biblioteca");
    }

    public static void mensagemNaoHaLivroParaDevolver(String nomeUser) {
        System.out.println("Usuário " + nomeUser + " não têm livros para devolver.");
    }

    public static void mensagemLivroNaoEstaNaListaDeEmprestados(String nomeUser, String titulo) {
        System.out.println("O livro " + titulo + " não está na lista de emprestados do usuário " + nomeUser + ".");
    }

    public static void mensagemDeNaoExistenciaDeOperacoes() {
        System.out.println("Não há empréstimos ativos, empréstimos finalizados ou reservas.");
    }

}
