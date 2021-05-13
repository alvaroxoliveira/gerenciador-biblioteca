package Estado;

public class Livre implements EstadoLivro{
    @Override
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
    }
}
