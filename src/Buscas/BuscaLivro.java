package Buscas;

import Livro.CarregaLivros;
import Livro.Livro;

public class BuscaLivro {
    /*
    * Método que busca um livro na lista de livros do sistema.
    * */
    public static int buscaIndexDoLivro(String identificacaoLivro) {
        int index = 0;
        for(Livro livro: CarregaLivros.getLivrosDoSistema()) {
            if(identificacaoLivro.equals(livro.getId())) {
                return index;
            }
            index++;
        }
        return -1;
    }
}
