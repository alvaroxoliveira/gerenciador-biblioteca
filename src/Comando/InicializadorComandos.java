package Comando;

import java.util.HashMap;

public class InicializadorComandos {

    public static HashMap<String, Comando> inicializarComandos() {
        HashMap<String, Comando> comandos = new HashMap<String, Comando>();
        comandos.put("emp", new Emprestimo());
        comandos.put("res", new Reserva());
        comandos.put("dev", new Devolucao());
        comandos.put("obs", new Observacao());
        comandos.put("liv", new RealizarConsultaLivro());
        return comandos;
    }
}
