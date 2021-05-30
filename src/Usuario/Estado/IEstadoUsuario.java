package Usuario.Estado;

import Livro.Livro;
import Usuario.Usuario;

public interface IEstadoUsuario {
    public void pegarLivroEmprestado(Livro livro, Usuario usuario);
    public void devolverLivroEmprestado(Livro livro, Usuario usuario);
    public void reservarLivro(Livro livro, Usuario usuario);
    public int diasParaEntrega(); //metodo polimorfico para saber a qtd de dia de cada tipo de usuario
//    public void consultarLivro(int codigoDoLivro);
//    public void observarLivro(int codigoDoLivro);
}
