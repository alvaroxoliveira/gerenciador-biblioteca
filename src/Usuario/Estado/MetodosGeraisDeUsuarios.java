package Usuario.Estado;

/*
* Classe auxiliar que contem métodos estáticos e gerais para usuários usarem. Tem como objetivo fazer com que não
* escrevamos códigos repetitivos.
* */

import Livro.Livro;
import MensagensConsole.MensagensUsuariosGerais;
import Usuario.Usuario;

public class MetodosGeraisDeUsuarios {
    
    /*
    * Método público e estático que tem como objetivo verificar se o usuário pode reservar e assim chamar o método
    * do livro para assim chamar o método de reservar o livro dentro do objeto livro.
    * */
    public static void reservaParaUsuario(Livro livro, Usuario usuario) {
        if(usuario.getListaDeReservados().size() < 3) { //caso o usuario tenha menos que 3 livros reservados
            livro.reservarLivro(usuario); //reservar livro
        } else {
            MensagensUsuariosGerais.mensagemDeQuantidadeMaximaDeReservasFeitas(usuario.getNome(), livro.getTitulo());
            return;
        }
    }

    /*
    * Método público e estático que tem como objetivo verificar se o usuário pode fazer o empréstimo e assim chamar
    * o método que tem a função de pegar o livro emprestado do objeto livro.
    * */
    public static void emprestimoParaAlunos(Livro livro, Usuario usuario, int quantidadeMaxima) {
        if(usuario.getListaDeLivrosEmprestados().size() == quantidadeMaxima){
            MensagensUsuariosGerais.mensagemDeQuantidadeMaximaDeReservasFeitas(usuario.getNome(), livro.getTitulo());
        }
        else{
            livro.pegarLivroEmprestado(usuario);
        }
    }
}
