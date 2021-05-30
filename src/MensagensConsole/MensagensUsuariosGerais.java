package MensagensConsole;

public class MensagensUsuariosGerais {
    public static void mensagemDeQuantidadeMaximaDeReservasFeitas(String nomeUser, String titulo) {
        System.out.println("Usuário " + nomeUser + " não pode reservar o livro" + titulo +
                " ja tem a quantidade máxima de livros reservados.");
    }
}
