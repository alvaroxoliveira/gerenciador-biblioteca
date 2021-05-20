package Livro.Estado;

import Livro.Livro;
import Livro.Exemplar;
import Usuario.User;

public interface IEstadoLivro {
    boolean emprestarLivro(Exemplar exemplar, User user);
    boolean devolverLivro(Exemplar exemplar, User user);
    boolean reservarLivro(Exemplar exemplar, User user);
}
