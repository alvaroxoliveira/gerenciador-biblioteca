package Livro;

import java.util.ArrayList;

public class CarregaLivros {
    // Lista de todos os livros que existem do sistema
    private static ArrayList<Livro> livrosDoSistema = new ArrayList<Livro>();

    public void carregarLivrosSistema() {
        Livro u1 = new Livro(100, "Engenharia de Software", "AddisonWesley", "Ian Sommervile"
                , "6ª", 2000);

        Livro u2 = new Livro(101, "UML - Guia do Usuário", "Campus",
                "Grady Booch, James Rumbaugh, Ivar Jacobson", "7ª", 2000);

        Livro u3 = new Livro(200, "Code Complete", "Microsoft Press", "Steve McConnel",
                "2ª", 2014);

        Livro u4 = new Livro(201, "Agile Software Development, Principles, Patterns and pratices",
                "Prentice Hall", "Robert Martin", "1ª", 2002);

        Livro u5 = new Livro(300, "Refactoring: Improving the Design of Existing Code",
                "Addison-Wesley Professional", "Martin Fowler", "1ª", 1999);

        Livro u6 = new Livro(301, "Software Metrics: A Rigorous and pratical approach",
                "CRC Press", "Norman Fenton, James Bieman", "3ª", 2014);

        Livro u7 = new Livro(400, "Design Patterns: Elements of Reusable Object-Oriented Software",
                "Addison-Wesley Professional", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides",
                "1ª", 1994);

        Livro u8 = new Livro(401, "UML Distilled: A Brief Guide to the Standard Object Modeling Language",
                "Addison-Wesley Professional", "Martin Fowler", "3ª", 20003);

        this.adicionaLivroNoSistema(u1);
        this.adicionaLivroNoSistema(u2);
        this.adicionaLivroNoSistema(u3);
        this.adicionaLivroNoSistema(u4);
        this.adicionaLivroNoSistema(u5);
        this.adicionaLivroNoSistema(u6);
        this.adicionaLivroNoSistema(u7);
        this.adicionaLivroNoSistema(u8);
    }

    // Cadastra um livro no sistema
    private void adicionaLivroNoSistema(Livro livro) {
        CarregaLivros.livrosDoSistema.add(livro);
    }

    // Da baixa em algum livro do sistema
    private void removeLivroNoSistema(int i) {
        CarregaLivros.livrosDoSistema.remove(i);
    }
}
