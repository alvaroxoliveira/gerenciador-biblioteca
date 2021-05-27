package Usuario.Estado;

import Livro.Livro;
import MensagensConsole.MensagensProfessor;
import Observer.Observer;
import Usuario.User;

public class Professor implements IEstadoUsuario, Observer {
    private Professor() {}
    public static Professor instance; //cada livro só vai ter uma instancia de cada estado
    public static Professor getInstance() { //se não existir instancia, cria uma
        if(instance == null) {
            synchronized(Professor.class) {
                if(instance == null) {
                    instance = new Professor();
                }
            }
        }
        return instance;
    }

    @Override
    public void pegarLivroEmprestado(Livro livro, User user) {
        livro.pegarLivroEmprestado(user);
    }

    @Override
    public void devolverLivroEmprestado(Livro livro, User user) {
        livro.devolverLivroEmprestado(user);
    }

    @Override
    public void reservarLivro(Livro livro, User user) { //Caio
        MetodosGeraisDeUsuarios.reservaParaUsuario(livro, user);
    }

    //metodo polimorfico para saber a qtd de dia de cada tipo de usuario
    @Override
    public int diasParaEntrega() {
        return 7;
    }

    private void notificarReservasSimultaneas() {
        MensagensProfessor.mensagemDeReservasSimultaneas();
    }

    @Override
    public void avisarReservasSimultaneas() {
        this.notificarReservasSimultaneas();
    }
}
