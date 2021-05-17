package Comando;

import Livro.Livro;
import Usuario.CarregaUsuarios;
import Livro.CarregaLivros;
import Usuario.User;

import java.util.ArrayList;

public class FachadaBiblioteca {

    public static FachadaBiblioteca instance; //cada livro só vai ter uma instancia de cada estado

    private FachadaBiblioteca() {}

    public static FachadaBiblioteca getInstance() { //se não existir instancia, cria uma
        if(instance == null) {
            synchronized(FachadaBiblioteca.class) {
                if(instance == null) {
                    instance = new FachadaBiblioteca();
                }
            }
        }
        return instance;
    }

    private boolean usuarioExiste(String identificacaoUsuario) {
        boolean existe = false;
        for(User user: CarregaUsuarios.getUsuariosDoSistema()) {
            if(identificacaoUsuario.equals(user.getIdentificador())) {
                existe = true;
            }
        }
        return existe;
    }

    private boolean livroExiste(String identificacaoLivro) {
        boolean existe = false;
        for(Livro livro: CarregaLivros.getLivrosDoSistema()) {
            if(identificacaoLivro.equals(livro.getId())) {
                existe = true;
            }
        }
        return existe;
    }

    public void realizarEmprestimo(ArrayList<String> parametroParaExecutar) {
        String identificadorUsuario = parametroParaExecutar.get(0);
        String identificadorLivro = parametroParaExecutar.get(1);
        System.out.println("Realizando Emprestimo");
        if(usuarioExiste(identificadorUsuario)) {

        } else {
            System.out.println("Erro ao realizar operação: Usuário não está cadastrado no sistema.");
        }
    }

    public void realizarDevolucao(ArrayList<String> parametroParaExecutar) {
        System.out.println("Realizando Devolução");
    }

    public void realizarReserva(ArrayList<String> parametroParaExecutar) {
        System.out.println("Realizando reserva");
    }

    public void realizarConsultaLivro(ArrayList<String> parametroParaExecutar) {
        System.out.println("Consultando dados do livro: ");
    }

    public void realizarObservacao(ArrayList<String> parametroParaExecutar) {
        System.out.println("Observando dados do livro: ");
    }
}
