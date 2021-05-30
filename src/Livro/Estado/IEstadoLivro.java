package Livro.Estado;

import Livro.Exemplar;
import Usuario.Usuario;

public interface IEstadoLivro {
    void emprestarLivro(Exemplar exemplar, Usuario usuario);
    void devolverLivro(Exemplar exemplar, Usuario usuario);
    String imprimirEstado();
}
