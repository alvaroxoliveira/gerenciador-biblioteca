package Usuario.Estado;

import Livro.Livro;
import Usuario.User;

public interface IEstadoUsuario {
    public void pegarLivroEmprestado(String codigoDoLivro, User user);
//    public void devolverLivroEmprestado(int codigoDoLivro);
//    public void reservarLivro(int codigoDoLivro);
//    public void consultarLivro(int codigoDoLivro);
//    public void observarLivro(int codigoDoLivro);
}
