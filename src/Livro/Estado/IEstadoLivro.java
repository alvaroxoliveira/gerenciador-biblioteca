package Livro.Estado;

import Livro.Livro;

public interface IEstadoLivro {
    public void emprestarLivro(Livro livro);
    public void devolverLivro(Livro livro);
    public void reservarLivro(Livro livro);
}
