package Estado;

import Livro.Livro;

public class Emprestado implements EstadoLivro{

    @Override
<<<<<<< HEAD
    public void emprestarLivro(Livro livro) {

    }

    @Override
    public void devolverLivro(Livro livro) {

    }

    @Override
    public void reservarLivro(Livro livro) {

=======
    public void emprestarLivro() {
        System.out.println("Não é possível fazer empréstimo de um livro emprestado.");
    }

    @Override
    public void devolverLivro() {
        System.out.println("Devolução concluída com sucesso");
    }

    @Override
    public void reservarLivro() {
        System.out.println("Não é possível fazer reserva de um livro emprestado.");
>>>>>>> 1989cd3fdce27e20aaf5f82118d7574d3cd24f52
    }
}
