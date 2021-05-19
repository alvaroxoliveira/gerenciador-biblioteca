package Comando;

import Livro.Livro;
import Livro.CarregaLivros;
import Usuario.CarregaUsuarios;
import Usuario.User;

public class Buscas {
    //Busca pelo id do usuário na lista de usuários e compara com o id passado
    public static int buscaIndexDoUsuario(String identificacaoUsuario) {
        int index = 0;
        for(User user: CarregaUsuarios.getUsuariosDoSistema()) {
            if(identificacaoUsuario.equals(user.getIdentificador())) {
                return index;
            }
            index++;
        }
        return -1;
    }

    //Busca pelo id do livro na lista de livroe e compara com o id passado
    public static int buscaIndexDoLivro(String identificacaoLivro) {
        int index = 0;
        for(Livro livro: CarregaLivros.getLivrosDoSistema()) {
            if(identificacaoLivro.equals(livro.getId())) {
                return index;
            }
            index++;
        }
        return -1;
    }

    //Retorna o objeto usuário (caso exista) compativel com o id passado
    public static User getUsuario(String identificacaoUsuario) {
        int indexDoUsuario = buscaIndexDoUsuario(identificacaoUsuario);
        if(indexDoUsuario != -1) {
            return CarregaUsuarios.getUsuariosDoSistema().get(indexDoUsuario);
        } else {
            System.out.println("Usuario não existe.");
        }
        return null;
    }

    //Retorna o objeto livro (caso exista) compativel com o id passado
    public static Livro getLivro(String identificacaoLivro) {
        int indexDoLivro = buscaIndexDoLivro(identificacaoLivro);
        if(indexDoLivro != -1) {
            return CarregaLivros.getLivrosDoSistema().get(indexDoLivro);
        } else {
            System.out.println("Livro não existe.");
        }
        return null;
    }
}
