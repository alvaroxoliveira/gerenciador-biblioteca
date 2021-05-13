package Estado;

public class Emprestado implements EstadoLivro{
    @Override
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
    }
}
