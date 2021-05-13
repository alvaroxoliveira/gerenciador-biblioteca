package Livro;

import Estado.EstadoLivro;
import Estado.SingletonDisponivel;

import java.util.ArrayList;

public class Livro {
    private int id;
    private String titulo;
    private String editora;
    private String autores;
    private String edicao;
    private int anoDePublicacao;
    private EstadoLivro estadoLivro;

    public Livro(int id, String titulo, String editora, String autores, String edicao, int anoDePublicacao) {
        this.id = id;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoDePublicacao = anoDePublicacao;
        this.estadoLivro = SingletonDisponivel.getInstance();
    }

    private static ArrayList<Livro> todosOsLivros = new ArrayList<Livro>();

    // Mudança de estado como manda  o padrão state implementado na aplicação
    public void mudarEstado(EstadoLivro estadoLivro) {
        this.estadoLivro = estadoLivro;
    }

    public static ArrayList<Livro> getTodosOsLivros() {
        return todosOsLivros;
    }

    public static void setTodosOsLivros(ArrayList<Livro> todosOsLivros) {
        Livro.todosOsLivros = todosOsLivros;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public void setAnoDePublicacao(int anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }
}
