package Comando;

import Livro.Livro;
import Livro.CarregaLivros;
import Usuario.CarregaUsuarios;
import Usuario.User;

public class Buscas {
    public static boolean usuarioExiste(String identificacaoUsuario) {
        boolean existe = false;
        for(User user: CarregaUsuarios.getUsuariosDoSistema()) {
            if(identificacaoUsuario.equals(user.getIdentificador())) {
                existe = true;
            }
        }
        return existe;
    }

    public static boolean livroExiste(String identificacaoLivro) {
        boolean existe = false;
        for(Livro livro: CarregaLivros.getLivrosDoSistema()) {
            if(identificacaoLivro.equals(livro.getId())) {
                existe = true;
            }
        }
        return existe;
    }
}
