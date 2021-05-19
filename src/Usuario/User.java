package Usuario;

import Livro.Livro;
import Observer.Observer;
import Usuario.Estado.IEstadoUsuario;

import java.util.ArrayList;

public class User implements IUsuario, Observer {
    private String identificador;
    private String nome;
    private IEstadoUsuario estadoUsuario;
    private int quantidadeDeNotificacoesDuplaReserva = 0;


    // Lista de livros que o usuário está no momento
    private ArrayList<Livro> listaDeLivrosEmprestados;

    public User(String identificador, String nome) {
        this.identificador = identificador;
        this.nome = nome;
        this.listaDeLivrosEmprestados = new ArrayList<Livro>();
    }

    @Override
    public void avisarReservasSimultaneas() {
        System.out.println("Dupla reserva simultânea!");
        this.quantidadeDeNotificacoesDuplaReserva++;
    }

    // Método de definição de tipo de usuário
    public void setTipoDeUsuario(IEstadoUsuario estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    // Adiciona um livro na lista de emprestimos
    public void adicionaNaListaDeEmprestados(Livro livro) {
        this.listaDeLivrosEmprestados.add(livro);
    }

    // Remove o objeto livro da lista de livros emprestados
    public void removeDaListaDeEmprestados(Livro livro) {
        this.listaDeLivrosEmprestados.remove(livro);
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Livro> getListaDeLivrosEmprestados() {
        return listaDeLivrosEmprestados;
    }

    public void setListaDeLivrosEmprestados(ArrayList<Livro> listaDeLivrosEmprestados) {
        this.listaDeLivrosEmprestados = listaDeLivrosEmprestados;
    }
}
