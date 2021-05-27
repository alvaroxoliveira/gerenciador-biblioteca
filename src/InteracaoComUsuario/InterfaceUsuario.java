package InteracaoComUsuario;

import Comando.Comando;
import MensagensConsole.MensagensInterfaceUsuario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

//Classe que faz interface com o usuário e faz leitura dos comandos do console
public class InterfaceUsuario {
    // Comando de saída do programa
    public final String comandoDeSaidaDoPrograma = "sai";

    //Relaciona a InterfaceUsuario com Comando (abstrato)
    private HashMap<String, Comando> comandos;

    //Obtem o comando a partir da entrada do console
    private String obterComandoConsoie() throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        MensagensInterfaceUsuario.mensagemDigiteComando();
        return teclado.readLine();
    }

    //Faz uma chamada polimórfica para executar o comando específico passado pela interação com o usuário
    private void executarComando(String tipoDeComando[]) {
        ArrayList<String> parametroParaExecutar = new ArrayList<String>();

        if(tipoDeComando.length > 2) {
            parametroParaExecutar.add(tipoDeComando[1]);
            parametroParaExecutar.add(tipoDeComando[2]);
        } else if(tipoDeComando.length == 2) {
            parametroParaExecutar.add(tipoDeComando[1]);
        } else {
            MensagensInterfaceUsuario.mensagemErroQuantidadeDeParametros();
            return;
        }

        Comando comando = comandos.get(tipoDeComando[0]); //Obtem a parte da string do comando
        comando.executar(parametroParaExecutar); //Chamada polimórfica para executar esse comando
    }

    //Fazer split da string dada pela entrada obtida no console
    private String[] obterEntradaDividida() throws IOException {
        String stringComando = obterComandoConsoie(); //lê e retorna a string
        String divisaoComando[] = stringComando.split(" ");
        return divisaoComando;
    }

    //Loop para o usuário ficar digitando os comandos
    public void fazerLoopEntrada() throws IOException {
        comandos = InicializadorComandos.inicializarComandos();
        String divisaoComando[] = obterEntradaDividida();
        //Enquanto o comando de sair não for executado, o console continua
        while (!divisaoComando[0].equals(this.comandoDeSaidaDoPrograma)) {
            executarComando(divisaoComando);
            divisaoComando = obterEntradaDividida();
        }
    }
}
