package Comando;

import Livro.Livro;
import Livro.CarregaLivros;

public class BuscaLivro {
    //Busca pelo id do livro na lista de livroe e compara com o id passado
    private static int buscaIndexDoLivro(String identificacaoLivro) {
        int index = 0;
        for(Livro livro: CarregaLivros.getLivrosDoSistema()) {
            if(identificacaoLivro.equals(livro.getId())) {
                return index;
            }
            index++;
        }
        return -1;
    }

    //Retorna o objeto livro (caso exista) compativel com o id passado
    public static Livro getLivro(String identificacaoLivro) {
        int indexDoLivro = buscaIndexDoLivro(identificacaoLivro);
        if(indexDoLivro != -1) {
            return CarregaLivros.getLivrosDoSistema().get(indexDoLivro);
        } else {
            System.out.println("Livro não existe.");
        }
        return null;
    }
}
