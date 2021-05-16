package Usuario.Estado;

import Livro.Livro;

public interface IEstadoUsuario {
    public void pegarLivroEmprestado(int codigoDoLivro);
    public void devolverLivroEmprestado(int codigoDoLivro);
    public void reservarLivro(int codigoDoLivro);
    public void consultarLivro(int codigoDoLivro);
}
