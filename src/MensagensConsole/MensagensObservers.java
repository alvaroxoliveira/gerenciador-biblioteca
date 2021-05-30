package MensagensConsole;

public class MensagensObservers {
    public static void mensagemAdicaoDeLivroNaListaDeObservador(String titulo, String nomeUser) {
        System.out.println("O usuário " + nomeUser + " adicionou o livro " + titulo + " na sua lista de observados.");
    }

    public static void mensagemJaObserva(String titulo, String nomeUser) {
        System.out.println("O usuário " + nomeUser + " já observa o livro " + titulo + ".");
    }

    public static void mensagemDeNotificacao(String nomeUser, int quantidadeDeNotificacoes) {
        System.out.println("O usuário " + nomeUser + " foi notificado " + quantidadeDeNotificacoes + " vezes.");
    }
}
