package MensagensConsole;

import Livro.Livro;
import Usuario.Usuario;

public class MensagensLivro {
    /*
    * Mensagem de aviso que o livro possui mais reservas do que exemplares.
    * */
    public static void mensagemPossuiMaisReservasQueExemplares(Livro livro, Usuario usuario) {
        System.out.println("O livro " + livro.getTitulo() + " possui mais reservas do que exemplares " +
                "e o usuário " + usuario.getNome() + " não possui reserva.");
    }

    /*
    * Mensagem de aviso que o usuário fez a reserva do livro com sucesso.
    * */
    public static void mensagemReservaDoLivroFeitaPeloUsuario(Livro livro, Usuario usuario) {
        System.out.println("O usuário " + usuario.getNome() + " fez a reserva do livro " + livro.getTitulo()
                + ".");
    }

    /*
    * Mensagem de adição de exemplar na lista de observador.
    * */
    public static void mensagemAdicaoDeLivroNaListaDeObservador(Livro livro, Usuario usuario) {
        System.out.println("O professor " + usuario.getNome() + " adicionou o livro " + livro.getTitulo() + " na sua lista de observados.");
    }

    /*
    * Mensagem de aviso que não há exemplares disponíveis.
    * */
    public static void mensagemNaoHaExemplaresDisponiveis() {
        System.out.println("Não há exemplares Disponíveis");
    }
}
