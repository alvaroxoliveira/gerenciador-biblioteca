package Estado;

import Livro.Livro;

public interface EstadoLivro {
    public void emprestarLivro(Livro livro);
    public void devolverLivro(Livro livro);
    public void reservarLivro(Livro livro);
}
