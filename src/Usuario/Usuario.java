package Usuario;

import Livro.Livro;

import java.util.ArrayList;

public abstract class Usuario {
    private int identificador;
    private String nome;

    private ArrayList<Livro> listaDeLivros;

    private static ArrayList<Livro> livrosReservados = new ArrayList<Livro>();
    private static ArrayList<Livro> livrosEmprestados = new ArrayList<Livro>();

    public Usuario(int identificador, String nome) {
        this.identificador = identificador;
        this.nome = nome;
        this.listaDeLivros = new ArrayList<Livro>();
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

    public ArrayList<Livro> getListaDeLivros() {
        return listaDeLivros;
    }

    public void setListaDeLivros(ArrayList<Livro> listaDeLivros) {
        this.listaDeLivros = listaDeLivros;
    }
}
