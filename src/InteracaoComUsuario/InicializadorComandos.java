package Comando;

import java.util.HashMap;

public class InicializadorComandos {

    //Método para inicializar os comandos existentes no sistema
    public static HashMap<String, Comando> inicializarComandos() {
        HashMap<String, Comando> comandos = new HashMap<String, Comando>();
        comandos.put("emp", new Emprestimo());
        comandos.put("res", new Reserva());
        comandos.put("dev", new Devolucao());
        comandos.put("obs", new Observacao());
        comandos.put("liv", new ConsultaLivro());
        comandos.put("usu", new ConsultaUsuario());
        comandos.put("ntf", new ConsultaProfessor());
        return comandos;
    }
}
