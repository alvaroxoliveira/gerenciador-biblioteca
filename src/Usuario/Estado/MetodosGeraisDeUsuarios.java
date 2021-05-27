package Usuario.Estado;

import Livro.Livro;
import MensagensConsole.MensagensUsuariosGerais;
import Usuario.User;

public class MetodosGeraisDeUsuarios {

    public static void reservaParaUsuario(Livro livro, User user) {
        if(user.getListaDeReservados().size() < 3) { //caso o usuario tenha menos que 3 livros reservados
            livro.reservarLivro(user); //reservar livro
        } else {
            MensagensUsuariosGerais.mensagemDeQuantidadeMaximaDeReservasFeitas(user.getNome());
            return;
        }
    }

    public static void emprestimoParaAlunos(Livro livro, User user, int quantidadeMaxima) {
        if(user.getListaDeLivrosEmprestados().size() >= quantidadeMaxima){
            MensagensUsuariosGerais.mensagemDeQuantidadeMaximaDeReservasFeitas(user.getNome());
        }
        //se a quantidade de reservas for maior ou igual a quantidade de exemplares
        else{
            livro.pegarLivroEmprestado(user);
        }
    }
}
