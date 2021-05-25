package MensagensConsole;

public class MensagensLivro {
    public static void mensagemPossuiMaisReservasQueExemplares(String titulo, String nomeUser) {
        System.out.println("O livro " + titulo + " possui mais reservas do que exemplares e o usuário " + nomeUser + " não possui reserva.");
    }

    public static void mensagemReservaDoLivroFeitaPeloUsuario(String titulo, String nomeUser) {
        System.out.println("O usuário " + nomeUser + " fez a reserva do livro " + titulo + ".");
    }

    public static void mensagemAdicaoDeLivroNaListaDeObservador(String titulo, String nomeUser) {
        System.out.println("O professor " + nomeUser + " adicionou o livro " + titulo + " na sua lista de observados.");
    }

    public static void mensagemNaoHaExemplaresDisponiveis() {
        System.out.println("Não há exemplares Disponíveis");
    }
}
