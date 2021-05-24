package MensagensConsole;

public class MensagensSingletonEmprestado {
    public static void mensagemLivroJaFoiEmprestado() {
        System.out.println("Não há como pegar emprestado um livro que já está emprestado.");
    }

    public static void mensagemDevolucaoDoLivro(String nomeUser, String titulo) {
        System.out.println("O usuário " + nomeUser + " devolveu o livro " + titulo + ".");
    }
}
