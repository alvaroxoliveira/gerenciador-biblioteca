package Usuario;

//Classe que guarda todos os usuários do sistema

import Usuario.Estado.AlunoGraduacao;
import Usuario.Estado.AlunoPosGraduacao;
import Usuario.Estado.Professor;

import java.util.ArrayList;

public class CarregaUsuarios {
    private static ArrayList<Usuario> usuariosDoSistema = new ArrayList<Usuario>();

    /*
    * Método inicializa Usuários do sistema
    * Usuários estes definidos pelo professor na especificação do trabalho
    * O boolean de devedor é setado dentro do construtor como false para iniciar o sistema sem usuários devedores
    * */
    public static void inicializaUsuarios() {
        Usuario u1 = new Usuario("123", "João da Silva");
        u1.setTipoDeUsuario(AlunoGraduacao.getInstance());

        Usuario u2 = new Usuario("456", "Luiz Fernando Rodrigues");
        u2.setTipoDeUsuario(AlunoPosGraduacao.getInstance());

        Usuario u3 = new Usuario("789", "Pedro Paulo");
        u3.setTipoDeUsuario(AlunoGraduacao.getInstance());

        Usuario u4 = new Usuario("100", "Carlos Lucena");
        u4.setTipoDeUsuario(Professor.getInstance());

        adicionarUsuariosNoSistema(u1, u2, u3,u4);
    }

    /*
    * Adiciona os usuários criados num array contendo todos os usuários do sistema
    * */
    private static void adicionarUsuariosNoSistema(Usuario u1, Usuario u2, Usuario u3, Usuario u4) {
        CarregaUsuarios.usuariosDoSistema.add(u1);
        CarregaUsuarios.usuariosDoSistema.add(u2);
        CarregaUsuarios.usuariosDoSistema.add(u3);
        CarregaUsuarios.usuariosDoSistema.add(u4);
    }

    /*
    * Remove um usuário do sistema
    * */
    private static void removerUsuariosDoSistema(int i) {
        CarregaUsuarios.usuariosDoSistema.remove(i);
    }

    /*
    * Método para obter os usuários do sistema
    * */
    public static ArrayList<Usuario> getUsuariosDoSistema() {
        return usuariosDoSistema;
    }

    public static void setUsuariosDoSistema(ArrayList<Usuario> usuariosDoSistema) {
        CarregaUsuarios.usuariosDoSistema = usuariosDoSistema;
    }
}
