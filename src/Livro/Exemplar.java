package Livro;

import Livro.Estado.IEstadoLivro;

public class Exemplar {
    private String codigoExemplar;
    private IEstadoLivro estadoExemplar;

    public Exemplar(String codigoExemplar, IEstadoLivro estadoInicial) {
        this.codigoExemplar = codigoExemplar;
        this.estadoExemplar = estadoInicial;
    }

    // Muda estado do exemplar
    public void mudaEstado(IEstadoLivro estadoExemplar) {
        this.estadoExemplar = estadoExemplar;
    }

    public String getCodigoExemplar() {
        return codigoExemplar;
    }

    public void setCodigoExemplar(String codigoExemplar) {
        this.codigoExemplar = codigoExemplar;
    }
}
