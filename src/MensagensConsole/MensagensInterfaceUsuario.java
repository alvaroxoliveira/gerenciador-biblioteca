package MensagensConsole;

public class MensagensInterfaceUsuario {
    /*
    * Mensagem impressa no loop de entrada que pede ao Usuário para digitar um comando.
    * */
    public static void mensagemDigiteComando() {
        System.out.println();
        System.out.println("Digite o comando: ");
    }

    /*
    * Mensagem de erro na quantidade de parâmetros da interface do usuário.
    * */
    public static void mensagemErroQuantidadeDeParametros() {
        System.out.println("Erro na quantidade de parametros");
    }
}
