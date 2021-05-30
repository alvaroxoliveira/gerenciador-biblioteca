package Livro.Estado;

/*
* Interface que define as funções específicas implementadas pelos estados.
* Base do Padrão de Projeto State, ensinado em aula.
* */

import Livro.Exemplar;
import Usuario.Usuario;

public interface IEstadoLivro {
    void emprestarLivro(Exemplar exemplar, Usuario usuario);
    void devolverLivro(Exemplar exemplar, Usuario usuario);
    String imprimirEstado();
}
