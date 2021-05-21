package Livro.Estado;

import Livro.Livro;
import Livro.Exemplar;
import Usuario.User;

public interface IEstadoLivro {
    void emprestarLivro(Exemplar exemplar, User user);
    void devolverLivro(Exemplar exemplar, User user);
    void reservarLivro(Exemplar exemplar, User user);
    String imprimirEstado(); //conferir se deve ficar aqui - método para imprimir o estado na consulta
}
