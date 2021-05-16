package Livro;

import java.util.ArrayList;

public class CarregaLivros {
    // Lista de todos os livros que existem do sistema
    private static ArrayList<Livro> livrosDoSistema = new ArrayList<Livro>();

    public void carregarLivrosSistema() {
        Livro l1 = new Livro(100, "Engenharia de Software", "AddisonWesley", "Ian Sommervile"
                , "6ª", 2000);

        Livro l2 = new Livro(101, "UML - Guia do Usuário", "Campus",
                "Grady Booch, James Rumbaugh, Ivar Jacobson", "7ª", 2000);

        Livro l3 = new Livro(200, "Code Complete", "Microsoft Press", "Steve McConnel",
                "2ª", 2014);

        Livro l4 = new Livro(201, "Agile Software Development, Principles, Patterns and pratices",
                "Prentice Hall", "Robert Martin", "1ª", 2002);

        Livro l5 = new Livro(300, "Refactoring: Improving the Design of Existing Code",
                "Addison-Wesley Professional", "Martin Fowler", "1ª", 1999);

        Livro l6 = new Livro(301, "Software Metrics: A Rigorous and pratical approach",
                "CRC Press", "Norman Fenton, James Bieman", "3ª", 2014);

        Livro l7 = new Livro(400, "Design Patterns: Elements of Reusable Object-Oriented Software",
                "Addison-Wesley Professional", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides",
                "1ª", 1994);

        Livro l8 = new Livro(401, "UML Distilled: A Brief Guide to the Standard Object Modeling Language",
                "Addison-Wesley Professional", "Martin Fowler", "3ª", 20003);

        this.adicionaLivroNoSistema(l1);
        this.adicionaLivroNoSistema(l2);
        this.adicionaLivroNoSistema(l3);
        this.adicionaLivroNoSistema(l4);
        this.adicionaLivroNoSistema(l5);
        this.adicionaLivroNoSistema(l6);
        this.adicionaLivroNoSistema(l7);
        this.adicionaLivroNoSistema(l8);
    }

    // Cadastra um livro no sistema
    private void adicionaLivroNoSistema(Livro livro) {
        CarregaLivros.livrosDoSistema.add(livro);
    }

    // Da baixa em algum livro do sistema
    private void removeLivroNoSistema(int i) {
        CarregaLivros.livrosDoSistema.remove(i);
    }

    public static ArrayList<Livro> getLivrosDoSistema() {
        return livrosDoSistema;
    }

    public static void setLivrosDoSistema(ArrayList<Livro> livrosDoSistema) {
        CarregaLivros.livrosDoSistema = livrosDoSistema;
    }
}
