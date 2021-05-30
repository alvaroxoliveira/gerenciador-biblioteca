package Usuario.Estado;

import Livro.Livro;
import MensagensConsole.MensagensUsuariosGerais;
import Usuario.Usuario;

public class MetodosGeraisDeUsuarios {

    public static void reservaParaUsuario(Livro livro, Usuario usuario) {
        if(usuario.getListaDeReservados().size() < 3) { //caso o usuario tenha menos que 3 livros reservados
            livro.reservarLivro(usuario); //reservar livro
        } else {
            MensagensUsuariosGerais.mensagemDeQuantidadeMaximaDeReservasFeitas(usuario.getNome());
            return;
        }
    }

    public static void emprestimoParaAlunos(Livro livro, Usuario usuario, int quantidadeMaxima) {
        if(usuario.getListaDeLivrosEmprestados().size() >= quantidadeMaxima){
            MensagensUsuariosGerais.mensagemDeQuantidadeMaximaDeReservasFeitas(usuario.getNome());
        }
        //se a quantidade de reservas for maior ou igual a quantidade de exemplares
        else{
            livro.pegarLivroEmprestado(usuario);
        }
    }
}
