package MensagensConsole;

public class MensagensSingletonDisponivel {
    public static void mensagemEmprestimoDoLivroFeito(String nomeUser, String titulo) {
        System.out.println("O usuário " + nomeUser + " fez empréstimo do livro " + titulo + ".");
    }

    public static void mensagemNaoDevolverPoqueEstaDisponivel() {
        System.out.println("Você não pode devolver um exemplar que está disponível.");
    }
}
