package MensagensConsole;

public class MensagensNaoObservers {
    public static void mensagemErroAdicaoListaDeObservadores(String titulo, String nomeUser) {
        System.out.println("O usuário " + nomeUser + " não tem permissão para adicionar o livro " + titulo + " na sua lista de observados.");
    }

    public static void mensagemErroConsultaObserver(String nomeUser) {
        System.out.println("O usuário " + nomeUser + " não tem permissão para para observar, logo não pode ser notificado.");
    }
}
