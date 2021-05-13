package Estado;

import Livro.Livro;

public class Livre implements EstadoLivro{
    @Override
    public void emprestarLivro(Livro livro) {
        System.out.println("Empréstimo concluído com sucesso.");
    }

    @Override
    public void devolverLivro(Livro livro) {
        System.out.println("Não é possível devolver um livro disponível.");
    }

    @Override
    public void reservarLivro(Livro livro) {
        System.out.println("Reserva concluída com sucesso.");
    }
}
