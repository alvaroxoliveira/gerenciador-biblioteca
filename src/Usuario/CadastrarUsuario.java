package Usuario;

//Classe que guarda todos os usuários do sistema

import java.util.ArrayList;

public class CadastrarUsuario {
    private static ArrayList<User> usuariosDoSistema = new ArrayList<User>();

    // Cadastrar um usuário
    public static void cadastrarUsuarioNoSistema(User usuario) {
        CadastrarUsuario.usuariosDoSistema.add(usuario);
    }

    // Descadastrar um usuário
    public static void descadastrarUsuarioNoSistema(int i) {
        CadastrarUsuario.usuariosDoSistema.remove(i);
    }
}
