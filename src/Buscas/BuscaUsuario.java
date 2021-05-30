package Buscas;

import Usuario.CarregaUsuarios;
import Usuario.Usuario;

public class BuscaUsuario {
    //Busca pelo id do usuário na lista de usuários e compara com o id passado
    public static int buscaIndexDoUsuario(String identificacaoUsuario) {
        int index = 0;
        for(Usuario usuario : CarregaUsuarios.getUsuariosDoSistema()) {
            if(identificacaoUsuario.equals(usuario.getIdentificador())) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static Usuario getUsuario(String identificacaoUsuario) {
        int indexDoUsuario = buscaIndexDoUsuario(identificacaoUsuario);
        return CarregaUsuarios.getUsuariosDoSistema().get(indexDoUsuario);
    }
}
