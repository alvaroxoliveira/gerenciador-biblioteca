package Usuario.Estado;

/*
* Singleton de definição do Usuário do Tipo Professor, tendo como base o Padrão de Projeto State aprendido em aula.
* */

import Livro.Livro;
import MensagensConsole.MensagensProfessor;
import Observer.Observer;
import Usuario.Usuario;

public class Professor implements IEstadoUsuario, Observer {
    private Professor() {}
    public static Professor instance;
    public static Professor getInstance() {
        if(instance == null) {
            synchronized(Professor.class) {
                if(instance == null) {
                    instance = new Professor();
                }
            }
        }
        return instance;
    }

    /*
    * Método público que tem a função de chamar o método de pegar um livro emprestado no objeto livro.
    * */
    @Override
    public void pegarLivroEmprestado(Livro livro, Usuario usuario) {
        livro.pegarLivroEmprestado(usuario);
    }

    /*
    * Método publico que tem a função de chamar o método do objeto livro para devolver um livro emprestado.
    * */
    @Override
    public void devolverLivroEmprestado(Livro livro, Usuario usuario) {
        livro.devolverLivroEmprestado(usuario);
    }

    /*
    * Método publico que chama a reserva de um livro para cada usuário na classe auxiliar MetodosGeraisDeUsuarios
    * */
    @Override
    public void reservarLivro(Livro livro, Usuario usuario) { //Caio
        MetodosGeraisDeUsuarios.reservaParaUsuario(livro, usuario);
    }

    /*
    * Método público que retorna a quantidade de dias de entrega referente a cada tipo de usuário
    * */
    @Override
    public int diasParaEntrega() {
        return 7;
    }

    /*
    * Método privado que serve para notificar reservas simultaneas do usuário do tipo professor.
    * Tem como base o Padrão de Projeto Observer aprendido em aula.
    * */
    private void notificarReservasSimultaneas() {
        MensagensProfessor.mensagemDeReservasSimultaneas();
    }

    /*
    * Método publico que tem como objetivo avisar o professor sobre as reservas simultâneas, chamando o método de
    * notificação. Tem como base o Padrão de Projeto Observer aprendido em aula.
    * */
    @Override
    public void avisarReservasSimultaneas() {
        this.notificarReservasSimultaneas();
    }
}
