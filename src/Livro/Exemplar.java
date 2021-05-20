package Livro;

import Livro.Estado.IEstadoLivro;

public class Exemplar {
    private String codigoDoLivro;
    private String codigoExemplar;
    private IEstadoLivro estadoExemplar;

    public Exemplar(String codigoDoLivro, String codigoExemplar, IEstadoLivro estadoInicial) {
        this.codigoDoLivro = codigoDoLivro;
        this.codigoExemplar = codigoExemplar;
        this.estadoExemplar = estadoInicial;
    }

    // Muda estado do exemplar
    public void mudaEstado(IEstadoLivro estadoExemplar) {
        this.estadoExemplar = estadoExemplar;
    }

    public String getCodigoDoLivro() {
        return codigoDoLivro;
    }

    public void setCodigoDoLivro(String codigoDoLivro) {
        this.codigoDoLivro = codigoDoLivro;
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
