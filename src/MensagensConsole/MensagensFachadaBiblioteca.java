package MensagensConsole;

public class MensagensFachadaBiblioteca {

    /*
    * Mensagem de erro que avisa que houve um erro na quantidade de parâmetros que foram passados no console
    * pelo usuário.
    * */
    public static void mensagemErroNaquantidadeDeParametros() {
        System.out.println("Erro na quantidade de parametros");
    }

    /*
    * Mensagem que avisa que está havendo uma operação de empréstimo.
    * */
    public static void mensagemOperacaoEmprestimo() {
        System.out.println("Operação de Empréstimo.");
    }

    /*
    * Mensagem que avisa que está havendo uma operação de devolução.
    * */
    public static void mensagemOperacaoDevolucao() {
        System.out.println("Realizando devolução");
    }

    /*
    * Mensagem que avisa que está havendo uma operação de reserva.
    * */
    public static void mensagemOperacaoReserva() {
        System.out.println("Realizando Reserva.");
    }

    /*
    * Mensagem que avisa que está havendo uma consulta a dados do Livro.
    * */
    public static void mensagemConsultaDadosLivro() {
        System.out.println("Consultando dados do livro: ");
    }

    /*
    * Mensagem que avisa que está havendo uma consulta de dados do Usuário.
    * */
    public static void mensagemConsultaDadosUsuario() {
        System.out.println("Consultando dados do usuário: ");
    }

    /*
    * Mensagem que avisa que está havendo uma consulta a dados do professor (Notificações).
    * */
    public static void mensagemConsultaDadosProfessor() {
        System.out.println("Consultando o profesor: ");
    }
}
