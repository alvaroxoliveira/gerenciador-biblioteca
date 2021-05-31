package MensagensConsole;

import Livro.Livro;
import Usuario.Usuario;

public class MensagensUsuariosGerais {

    /*
    * Mensagem de aviso que o usuário ja fez a quantidade máxima de reservas feitas, que são 3.
    * */
    public static void mensagemDeQuantidadeMaximaDeReservasFeitas(Livro livro, Usuario usuario) {
        System.out.println("Usuário " + usuario.getNome() + " não pode reservar o livro" + livro.getTitulo() +
                " ja tem a quantidade máxima de livros reservados.");
    }
}
