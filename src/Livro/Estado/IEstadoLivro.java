package Livro.Estado;

import Livro.Livro;

public interface IEstadoLivro {
    void emprestarLivro(Livro livro);
    void devolverLivro(Livro livro);
    void reservarLivro(Livro livro);
}
