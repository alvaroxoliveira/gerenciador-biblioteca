package Usuario;

//Classe que guarda todos os usuários do sistema

import java.util.ArrayList;

public class UsuariosDoSistema {
    private static ArrayList<User> usuariosDoSistema = new ArrayList<User>();

    // Cadastrar um usuário
    public static void cadastrarUsuarioNoSistema(User usuario) {
        UsuariosDoSistema.usuariosDoSistema.add(usuario);
    }

    // Descadastrar um usuário
    public static void descadastrarUsuarioNoSistema(int i) {
        UsuariosDoSistema.usuariosDoSistema.remove(i);
    }
}
