package Estado;

import Livro.Livro;

public class Livre implements EstadoLivro{
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
        System.out.println("Empréstimo concluído com sucesso.");
    }

    @Override
    public void devolverLivro() {
        System.out.println("Não é possível devolver um livro disponível.");
    }

    @Override
    public void reservarLivro() {
        System.out.println("Reserva concluída com sucesso.");
>>>>>>> 1989cd3fdce27e20aaf5f82118d7574d3cd24f52
    }
}
