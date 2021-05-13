package Estado;

import Livro.Livro;

public class Emprestado implements EstadoLivro{

    @Override
    public void emprestarLivro(Livro livro) {
        System.out.println("Não é possível fazer empréstimo de um livro emprestado.");
    }

    @Override
    public void devolverLivro(Livro livro) {
        System.out.println("Devolução concluída com sucesso");
    }

    @Override
    public void reservarLivro(Livro livro) {
        System.out.println("Não é possível fazer reserva de um livro emprestado.");
    }
}
