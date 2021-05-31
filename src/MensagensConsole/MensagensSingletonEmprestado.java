package MensagensConsole;

import Livro.Livro;
import Usuario.Usuario;

public class MensagensSingletonEmprestado {

    /*
    * Mensagem de aviso que o livro ja está emprestado.
    * */
    public static void mensagemLivroJaFoiEmprestado() {
        System.out.println("Não há como pegar emprestado um livro que já está emprestado.");
    }

    /*
    * Mensagem de aviso de devolução do livro pelo usuário.
    * */
    public static void mensagemDevolucaoDoLivro(Livro livro, Usuario usuario) {
        System.out.println("O usuário " + usuario.getNome() + " devolveu o livro " + livro.getTitulo() + ".");
    }
}
