package MensagensConsole;

import Livro.Livro;
import Usuario.Usuario;

public class MensagensObservers {

    /*
    * Mensagem de aviso que o usuário adicionou um livro na sua lista de observadores.
    * */
    public static void mensagemAdicaoDeLivroNaListaDeObservador(Livro livro, Usuario usuario) {
        System.out.println("O usuário " + usuario.getNome() + " adicionou o livro " + livro.getTitulo() + " na sua lista de observados.");
    }

    /*
    * Mensagem de aviso que o usuário ja observa o livro.
    * */
    public static void mensagemJaObserva(Livro livro, Usuario usuario) {
        System.out.println("O usuário " + usuario.getNome() + " já observa o livro " + livro.getTitulo() + ".");
    }

    /*
    * Mensagem da quantidade de vezes que o usuário foi internamente notificado.
    * */
    public static void mensagemDeNotificacao(Usuario usuario) {
        System.out.println("O usuário " + usuario.getNome() + " foi notificado " + usuario.getQuantidadeDeNotificacoes() + " vezes.");
    }
}
