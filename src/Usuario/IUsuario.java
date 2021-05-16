package Usuario;

import Livro.Livro;
import Usuario.Estado.IEstadoUsuario;

import java.util.ArrayList;

public interface IUsuario {
    public void setTipoDeUsuario(IEstadoUsuario estadoUsuario);
    public void adionaNaListaDeEmprestados(Livro livro);
    public void removeDaListaDeEmprestados(Livro livro);
    public String getIdentificador();
    public void setIdentificador(String identificador);
    public String getNome();
    public void setNome(String nome);
    public ArrayList<Livro> getListaDeLivrosEmprestados();
    public void setListaDeLivrosEmprestados(ArrayList<Livro> listaDeLivrosEmprestimo);
}
