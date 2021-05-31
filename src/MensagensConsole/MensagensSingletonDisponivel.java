package MensagensConsole;

import Livro.Livro;
import Usuario.Usuario;

public class MensagensSingletonDisponivel {

    /*
    * Mensagem de aviso que o empréstimo foi um sucesso.
    * */
    public static void mensagemEmprestimoDoLivroFeito(Livro livro, Usuario usuario) {
        System.out.println("O usuário " + usuario.getNome() + " fez empréstimo do livro " +
                livro.getTitulo() + ".");
    }

    /*
    * Mensagem de aviso que o usuário não pode devolver um livro que ja está disponível.
    * */
    public static void mensagemNaoDevolverPoqueEstaDisponivel() {
        System.out.println("Você não pode devolver um exemplar que está disponível.");
    }
}
