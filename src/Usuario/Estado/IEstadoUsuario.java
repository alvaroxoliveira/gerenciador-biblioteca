package Usuario.Estado;

import Livro.Livro;

public interface EstadoUsuario {
    public void pegarLivroEmprestado(Livro livro);
    public void devolverLivroEmprestado(Livro livro);
    public void reservarLivro(Livro livro);
}
