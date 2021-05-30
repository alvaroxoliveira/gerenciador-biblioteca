package Livro;

/*
* Classe de Definição de um Exemplar de um Livro.
* */

import Livro.Estado.IEstadoLivro;

public class Exemplar {
    private Livro livro;
    private String codigoExemplar;
    private IEstadoLivro estadoExemplar;

    public Exemplar(Livro livro, String codigoExemplar, IEstadoLivro estadoInicial) {
        this.livro = livro;
        this.codigoExemplar = codigoExemplar;
        this.estadoExemplar = estadoInicial;
    }

    /*
    * Método público que permite o Exemplar mudar de estado (Disponível/Emprestado).
    * */
    public void mudaEstado(IEstadoLivro estadoExemplar) {
        this.estadoExemplar = estadoExemplar;
    }

    /*
    * Getters/Setters.
    * */

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getCodigoExemplar() {
        return codigoExemplar;
    }

    public void setCodigoExemplar(String codigoExemplar) {
        this.codigoExemplar = codigoExemplar;
    }

    public IEstadoLivro getEstadoExemplar() {
        return estadoExemplar;
    }

    public void setEstadoExemplar(IEstadoLivro estadoExemplar) {
        this.estadoExemplar = estadoExemplar;
    }
}
