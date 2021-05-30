package Buscas;

import Usuario.CarregaUsuarios;
import Usuario.Usuario;

public class BuscaUsuario {
    /*
     * Método que busca um usuário na lista de usuários do sistema.
     * */
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
}
