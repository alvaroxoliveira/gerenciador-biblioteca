package Comando;

import java.util.ArrayList;

//A interface command onde cada classe vai ser um comando concreto que vai representar uma sigla(string)
//de comando referente ao sistema
public interface Comando {
    public void executar(ArrayList<String> parametros);
}
