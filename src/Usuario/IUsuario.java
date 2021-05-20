package Usuario;

import Livro.Livro;
import Usuario.Estado.IEstadoUsuario;
import Livro.Exemplar;
import java.util.ArrayList;

public interface IUsuario {
    void setTipoDeUsuario(IEstadoUsuario estadoUsuario);
    void adicionaNaListaDeEmprestados(Exemplar exemplar);
    void removeDaListaDeEmprestados(Exemplar exemplar);
    String getIdentificador();
    void setIdentificador(String identificador);
    String getNome();
    void setNome(String nome);
    ArrayList<Exemplar> getListaDeLivrosEmprestados();
    void setListaDeLivrosEmprestados(ArrayList<Exemplar> listaDeLivrosEmprestimo);
}
