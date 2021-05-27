package Usuario.Estado;

import Livro.Livro;
import Usuario.User;

public interface IEstadoUsuario {
    public void pegarLivroEmprestado(Livro livro, User user);
    public void devolverLivroEmprestado(Livro livro, User user);
    public void reservarLivro(Livro livro, User user);
    public int diasParaEntrega(); //metodo polimorfico para saber a qtd de dia de cada tipo de usuario
//    public void consultarLivro(int codigoDoLivro);
//    public void observarLivro(int codigoDoLivro);
}
