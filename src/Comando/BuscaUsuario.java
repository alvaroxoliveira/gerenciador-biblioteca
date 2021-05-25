package Comando;

import MensagensConsole.MensagensBuscaUsuario;
import Usuario.CarregaUsuarios;
import Usuario.User;

public class BuscaUsuario {
    //Busca pelo id do usuário na lista de usuários e compara com o id passado
    private static int buscaIndexDoUsuario(String identificacaoUsuario) {
        int index = 0;
        for(User user: CarregaUsuarios.getUsuariosDoSistema()) {
            if(identificacaoUsuario.equals(user.getIdentificador())) {
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
        }
        /*else {
            System.out.println("Usuario não existe.");
        }*/
        // verificar se tem que tratar esse retorno de null
        return null;
    }

    //Testa se o id do usuário passado está na lista de usuários
    public static boolean testeUsuario(String identificadorUsuario){
        for(User usuario: CarregaUsuarios.getUsuariosDoSistema()){
            if(usuario.getIdentificador().equals(identificadorUsuario)){
                return true;
            }
        }
        MensagensBuscaUsuario.mensagemUsuarioNaoEncontrado();
        return false;
    }
}
