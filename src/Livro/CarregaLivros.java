package Livro;

import Livro.Estado.SingletonDisponivel;

import java.util.ArrayList;

public class CarregaLivros {
    // Lista de todos os livros que existem do sistema
    private static ArrayList<Livro> livrosDoSistema = new ArrayList<Livro>();

    public static void carregarLivrosSistema() {
        Livro l1 = new Livro("100", "Engenharia de Software", "AddisonWesley", "Ian Sommervile"
                , "6ª", 2000);

        Livro l2 = new Livro("101", "UML - Guia do Usuário", "Campus",
                "Grady Booch, James Rumbaugh, Ivar Jacobson", "7ª", 2000);

        Livro l3 = new Livro("200", "Code Complete", "Microsoft Press", "Steve McConnel",
                "2ª", 2014);

        Livro l4 = new Livro("201", "Agile Software Development, Principles, Patterns and pratices",
                "Prentice Hall", "Robert Martin", "1ª", 2002);

        Livro l5 = new Livro("300", "Refactoring: Improving the Design of Existing Code",
                "Addison-Wesley Professional", "Martin Fowler", "1ª", 1999);

        Livro l6 = new Livro("301", "Software Metrics: A Rigorous and pratical approach",
                "CRC Press", "Norman Fenton, James Bieman", "3ª", 2014);

        Livro l7 = new Livro("400", "Design Patterns: Elements of Reusable Object-Oriented Software",
                "Addison-Wesley Professional", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides",
                "1ª", 1994);

        Livro l8 = new Livro("401", "UML Distilled: A Brief Guide to the Standard Object Modeling Language",
                "Addison-Wesley Professional", "Martin Fowler", "3ª", 2003);

        //Adicionando exemplares no sistema
        l1.adicionaExemplar(new Exemplar(l1.getId(),"01", SingletonDisponivel.getInstance()));
        l1.adicionaExemplar(new Exemplar(l1.getId(),"02", SingletonDisponivel.getInstance()));
        l2.adicionaExemplar(new Exemplar(l2.getId(),"03", SingletonDisponivel.getInstance()));
        l3.adicionaExemplar(new Exemplar(l3.getId(),"04", SingletonDisponivel.getInstance()));
        l4.adicionaExemplar(new Exemplar(l4.getId(),"05", SingletonDisponivel.getInstance()));
        l5.adicionaExemplar(new Exemplar(l5.getId(),"06", SingletonDisponivel.getInstance()));
        l5.adicionaExemplar(new Exemplar(l5.getId(),"07", SingletonDisponivel.getInstance()));
        l7.adicionaExemplar(new Exemplar(l7.getId(),"08", SingletonDisponivel.getInstance()));
        l7.adicionaExemplar(new Exemplar(l7.getId(),"09", SingletonDisponivel.getInstance()));

        // Adiciona os livros carregados no sistema
        adicionaLivroNoSistema(l1);
        adicionaLivroNoSistema(l2);
        adicionaLivroNoSistema(l3);
        adicionaLivroNoSistema(l4);
        adicionaLivroNoSistema(l5);
        adicionaLivroNoSistema(l6);
        adicionaLivroNoSistema(l7);
        adicionaLivroNoSistema(l8);
    }

    // Cadastra um livro no sistema
    private static void adicionaLivroNoSistema(Livro livro) {
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
