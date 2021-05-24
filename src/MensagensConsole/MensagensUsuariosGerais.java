package MensagensConsole;

import Comando.BuscaLivro;

public class MensagensUsuariosGerais {
    public static void mensagemDeReservaFeita(String codigoDoLivro, String nomeUser) {
        System.out.println("O usuário " + nomeUser + " fez a reserva do livro " + BuscaLivro.getLivro(codigoDoLivro).getTitulo() + ".");
    }

    public static void mensagemDeQuantidadeMaximaDeReservasFeitas(String nomeUser) {
        System.out.println("Usuário " + nomeUser + " ja tem a quantidade máxima de livros reservados.");
    }
}
