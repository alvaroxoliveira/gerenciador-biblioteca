/*
* Universidade Federal da Bahia
* Aluno 1: Álvaro Souza Oliveira
* Aluno 2: Caio Nery Matos Santos
* Trabalho Prático de MATA62 - T02 - Engenharia de Software
* Professor: Carlos Nogueira Sant'Anna
* */

import InteracaoComUsuario.InterfaceUsuario;
import Livro.CarregaLivros;
import Usuario.CarregaUsuarios;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CarregaUsuarios.inicializaUsuarios();
        CarregaLivros.carregarLivrosSistema();
        InterfaceUsuario.getInstance().fazerLoopEntrada();
    }
}
