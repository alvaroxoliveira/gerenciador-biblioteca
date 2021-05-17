package Usuario;

//Classe que guarda todos os usuários do sistema

import Usuario.Estado.AlunoGraduacao;
import Usuario.Estado.AlunoPosGraduacao;
import Usuario.Estado.Professor;

import java.util.ArrayList;

public class CarregaUsuarios {
    private static ArrayList<User> usuariosDoSistema = new ArrayList<User>();

    public static void inicializaUsuarios() {
        User u1 = new User("123", "João da Silva");
        u1.setTipoDeUsuario(AlunoGraduacao.getInstance());

        User u2 = new User("456", "Luiz Fernando Rodrigues");
        u2.setTipoDeUsuario(AlunoPosGraduacao.getInstance());

        User u3 = new User("789", "Pedro Paulo");
        u3.setTipoDeUsuario(AlunoGraduacao.getInstance());

        User u4 = new User("100", "Carlos Lucena");
        u4.setTipoDeUsuario(Professor.getInstance());

        carregarUsuariosNoSistema(u1);
        carregarUsuariosNoSistema(u2);
        carregarUsuariosNoSistema(u3);
        carregarUsuariosNoSistema(u4);
    }

    // Cadastrar um usuário
    private static void carregarUsuariosNoSistema(User usuario) {
        CarregaUsuarios.usuariosDoSistema.add(usuario);
    }

    // Descadastrar um usuário
    private static void removerUsuariosDoSistema(int i) {
        CarregaUsuarios.usuariosDoSistema.remove(i);
    }

    public static ArrayList<User> getUsuariosDoSistema() {
        return usuariosDoSistema;
    }

    public static void setUsuariosDoSistema(ArrayList<User> usuariosDoSistema) {
        CarregaUsuarios.usuariosDoSistema = usuariosDoSistema;
    }
}
