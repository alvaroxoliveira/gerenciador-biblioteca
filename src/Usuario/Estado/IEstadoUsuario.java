package Usuario.Estado;

import Livro.Livro;
import Observer.Observer;
import Usuario.Usuario;

public interface IEstadoUsuario {
    public void pegarLivroEmprestado(Livro livro, Usuario usuario);
    public void devolverLivroEmprestado(Livro livro, Usuario usuario);
    public void reservarLivro(Livro livro, Usuario usuario);
    public int diasParaEntrega();
    public void adicionarObserver(Livro livro, Observer observer, String nomeUser);
    public void consultarObserver(Usuario usuario);
}
