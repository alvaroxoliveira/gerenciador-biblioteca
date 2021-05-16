package Usuario.Estado;

import Livro.Livro;

public interface IEstadoUsuario {
    public void pegarLivroEmprestado(Livro livro);
    public void devolverLivroEmprestado(Livro livro);
    public void reservarLivro(Livro livro);
}
