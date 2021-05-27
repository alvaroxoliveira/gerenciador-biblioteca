package Buscas;

import Livro.CarregaLivros;
import Livro.Livro;
import MensagensConsole.MensagensBuscaLivro;

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
        return CarregaLivros.getLivrosDoSistema().get(indexDoLivro);
//        if(indexDoLivro != -1) {
//            return CarregaLivros.getLivrosDoSistema().get(indexDoLivro);
//        }
//        /*else {
//            System.out.println("Livro não existe.");
//        }*/
//        // verificar se tem que tratar esse retorno de null
//        return null;
    }

    //Testa se o id do livro passado esta na lista de livros
    public static boolean testeLivro(String identificadorLivro){
        for(Livro livro: CarregaLivros.getLivrosDoSistema()) {
            if (livro.getId().equals(identificadorLivro)) {
                return true;
            }
        }
        MensagensBuscaLivro.mensagemLivroNaoEncontrado();
        return false;
    }
}
