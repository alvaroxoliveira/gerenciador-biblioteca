package Usuario;

import Livro.Livro;

import java.util.ArrayList;

public abstract class User {
    private int identificador;
    private String nome;
    
    // Lista de livros que o usuário está no momento
    private ArrayList<Livro> listaDeLivrosEmprestados;

    public User(int identificador, String nome) {
        this.identificador = identificador;
        this.nome = nome;
        this.listaDeLivrosEmprestados = new ArrayList<Livro>();
    }

    // Adiciona um livro na lista de emprestimos
    public void pegaEmprestado(Livro livro) {
        this.listaDeLivrosEmprestados.add(livro);
    }

    // Remove o objeto livro da lista de livros emprestados
    public void devolveLivro(int i) {
        this.listaDeLivrosEmprestados.remove(i);
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
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
