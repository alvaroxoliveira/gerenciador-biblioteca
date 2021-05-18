package Usuario;

import Livro.Livro;
import Usuario.Estado.IEstadoUsuario;

import java.util.ArrayList;

public interface IUsuario {
    void setTipoDeUsuario(IEstadoUsuario estadoUsuario);
    void adionaNaListaDeEmprestados(Livro livro);
    void removeDaListaDeEmprestados(Livro livro);
    String getIdentificador();
    void setIdentificador(String identificador);
    String getNome();
    void setNome(String nome);
    ArrayList<Livro> getListaDeLivrosEmprestados();
    void setListaDeLivrosEmprestados(ArrayList<Livro> listaDeLivrosEmprestimo);
}
