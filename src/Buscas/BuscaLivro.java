package Buscas;

import Livro.CarregaLivros;
import Livro.Livro;

public class BuscaLivro {
    //Busca pelo id do livro na lista de livroe e compara com o id passado
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

    public static Livro getLivro(String identificacaoLivro) {
        int indexDoLivro = buscaIndexDoLivro(identificacaoLivro);
        return CarregaLivros.getLivrosDoSistema().get(indexDoLivro);
    }
}
