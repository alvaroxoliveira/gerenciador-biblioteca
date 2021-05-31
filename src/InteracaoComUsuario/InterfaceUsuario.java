package InteracaoComUsuario;

/*
* Classe que tem a responsabilidade de fazer o papel de interface do usuário, fazendo a leitura dos comandos
* digitados no console designando para as operações.
* É um Singleton porque faz sentido ser apenas uma interface para o programa, então só podemos ter
* uma instância desta classe.
* */

import Comando.Comando;
import MensagensConsole.MensagensInterfaceUsuario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class InterfaceUsuario {
    /*
    * Constante que define o comando de saída do programa, interrompendo o seu funcionamento.
    * Serve para comparação.
    * */
    public final String comandoDeSaidaDoPrograma = "sai";

    /*
    * Relaciona a InterfaceUsuario com o comando (abstrato).
    * */
    private HashMap<String, Comando> comandos;

    public static InterfaceUsuario instance;
    private InterfaceUsuario() {}

    public static InterfaceUsuario getInstance() {
        if(instance == null) {
            synchronized(InterfaceUsuario.class) {
                if(instance == null) {
                    instance = new InterfaceUsuario();
                }
            }
        }
        return instance;
    }

    /*
    * Método que obtem o comando a partir da entrada do console.
    * O comando é a primeira parte do split feito na string passada pelo usuário.
    * */
    private String obterComandoConsoie() throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        MensagensInterfaceUsuario.mensagemDigiteComando();
        return teclado.readLine();
    }

    /*
    * Método que por meio do polimorfismo executa o comando específico para cada comando passado pela
    * interação com o usuário.
    * */
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

        Comando comando = comandos.get(tipoDeComando[0]);
        if(comando != null) {
            comando.executar(parametroParaExecutar);
        } else {
            MensagensInterfaceUsuario.mensagemComandoNaoEncontrado();
        }
    }

    /*
    * Método que faz o split na string dada pelo usuário na interação feita no console.
    * */
    private String[] obterEntradaDividida() throws IOException {
        String stringComando = obterComandoConsoie(); //lê e retorna a string
        String divisaoComando[] = stringComando.split(" ");
        return divisaoComando;
    }

    /*
    * Método que faz com que o programa funcione enquanto não digitar o comando "sai".
    * */
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
