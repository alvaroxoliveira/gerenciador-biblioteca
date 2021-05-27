package Buscas;

import Usuario.CarregaUsuarios;
import Usuario.User;

public class BuscaUsuario {
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

    public static User getUsuario(String identificacaoUsuario) {
        int indexDoUsuario = buscaIndexDoUsuario(identificacaoUsuario);
        return CarregaUsuarios.getUsuariosDoSistema().get(indexDoUsuario);
    }
}
