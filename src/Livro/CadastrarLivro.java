package Livro;

import java.util.ArrayList;

public class CadastrarLivro {
    // Lista de todos os livros que existem do sistema
    private static ArrayList<Livro> livrosDoSistema = new ArrayList<Livro>();

    // Cadastra um livro no sistema
    public static void cadastrarUmLivroNoSistema(Livro livro) {
        CadastrarLivro.livrosDoSistema.add(livro);
    }

    // Da baixa em algum livro do sistema
    public static void descadastrarLivroNoSistema(int i) {
        CadastrarLivro.livrosDoSistema.remove(i);
    }
}
