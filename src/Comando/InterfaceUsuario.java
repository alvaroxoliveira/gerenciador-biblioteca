package Comando;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class InterfaceUsuario {

    private HashMap<String, Comando> comandos;

    private String obterComandoConsoie() throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println("Digite o comando: ");
        return teclado.readLine();
    }

    //Faz uma chamada polimórfica para executar o comando específico passado pela interação com o usuário
    private void executarComando(String tipoDeComando[]) {
        Comando comando = comandos.get(tipoDeComando[0]);
        comando.executar(tipoDeComando[1], tipoDeComando[2]);
    }

    public void fazerLoopEntrada() throws IOException {
        comandos = InicializadorComandos.inicializarComandos();

        String stringComando = obterComandoConsoie();
        String divisaoComando[] = stringComando.split(" ");

        System.out.println(divisaoComando[0]);
        System.out.println(divisaoComando[1]);
        System.out.println(divisaoComando[2]);

        while (!stringComando.equals("sai")) {
            executarComando(divisaoComando);
            stringComando = obterComandoConsoie();
        }
    }
}
