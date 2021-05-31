package MensagensConsole;

import Livro.Livro;
import Usuario.Usuario;

public class MensagensNaoObservers {

    /*
    * Mensagem de aviso de erro quando um usuário que não pode ser observador tenta ser observador.
    * */
    public static void mensagemErroAdicaoListaDeObservadores(Livro livro, Usuario usuario) {
        System.out.println("O usuário " + usuario.getNome() + " não tem permissão para adicionar o livro "
                + livro.getTitulo() + " na sua lista de observados.");
    }

    /*
    * Mensagem de erro quando um usuário que não pode ser observador tenta observar um livro.
    * */
    public static void mensagemErroConsultaObserver(Usuario usuario) {
        System.out.println("O usuário " + usuario.getNome() + " não tem permissão para para observar, logo não pode ser notificado.");
    }
}
