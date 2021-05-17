package Comando;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        ArrayList<String> parametroParaExecutar = new ArrayList<String>();

        if(tipoDeComando.length > 2) {
            parametroParaExecutar.add(tipoDeComando[1]);
            parametroParaExecutar.add(tipoDeComando[2]);
        } else if(tipoDeComando.length == 1) {
            parametroParaExecutar.add(tipoDeComando[1]);
        } else {
            System.out.println("Erro na quantidade de parametros");
            return;
        }

        Comando comando = comandos.get(tipoDeComando[0]);
        comando.executar(parametroParaExecutar);
    }

    public void fazerLoopEntrada() throws IOException {
        comandos = InicializadorComandos.inicializarComandos();

        String stringComando = obterComandoConsoie();
        String divisaoComando[] = stringComando.split(" ");

        while (!stringComando.equals("sai")) {
            executarComando(divisaoComando);
            stringComando = obterComandoConsoie();
        }
    }
}
