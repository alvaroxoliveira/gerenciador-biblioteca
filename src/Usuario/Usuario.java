package Usuario;

import Livro.Livro;

import java.util.ArrayList;

public abstract class Usuario {
    private int identificador;
    private String nome;
    private static ArrayList<Livro> livrosReservados = new ArrayList<Livro>();
    private static ArrayList<Livro> livrosEmprestados = new ArrayList<Livro>();

    public Usuario(int identificador, String nome) {
        this.identificador = identificador;
        this.nome = nome;
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
}
