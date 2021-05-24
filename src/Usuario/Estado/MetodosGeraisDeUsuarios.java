package Usuario.Estado;

import Comando.BuscaLivro;
import MensagensConsole.MensagensUsuariosGerais;
import Usuario.User;

public class MetodosGeraisDeUsuarios {

    public static void reservaParaUsuario(String codigoDoLivro, User user) {
        if(user.getListaDeReservados().size() < 3) { //caso o usuario tenha menos que 3 livros reservados
            BuscaLivro.getLivro(codigoDoLivro).reservarLivro(user); //reservar livro
            MensagensUsuariosGerais.mensagemDeReservaFeita(codigoDoLivro, user.getNome()); // Mensagem de reserva quando é feita
        } else {
            MensagensUsuariosGerais.mensagemDeQuantidadeMaximaDeReservasFeitas(user.getNome());
            return;
        }
    }

    public static void emprestimoParaAlunos(String codigoDoLivro, User user, int quantidadeMaxima) {
        if(user.getListaDeLivrosEmprestados().size() >= quantidadeMaxima){
            MensagensUsuariosGerais.mensagemDeQuantidadeMaximaDeReservasFeitas(user.getNome());
        }
        //se a quantidade de reservas for maior ou igual a quantidade de exemplares
        else{
            BuscaLivro.getLivro(codigoDoLivro).pegarLivroEmprestado(user);
        }
    }
}
