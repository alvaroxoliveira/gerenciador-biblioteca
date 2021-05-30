package Comando;

/*
* Interface Comando que define o Padrão de Projeto Command ensinado em aula.
* O comando executar recebe parametros, que são as siglas para cada operação e as informações
* referentes aos usuários e aos livros, cada uma com suas particularidades.
* */

import java.util.ArrayList;

public interface Comando {
    public void executar(ArrayList<String> parametros);
}
