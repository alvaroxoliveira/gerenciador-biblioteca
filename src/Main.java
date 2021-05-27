import InteracaoComUsuario.InterfaceUsuario;
import Livro.CarregaLivros;
import Usuario.CarregaUsuarios;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        InterfaceUsuario gui = new InterfaceUsuario();

        CarregaUsuarios.inicializaUsuarios();
        CarregaLivros.carregarLivrosSistema();

        gui.fazerLoopEntrada();
    }
}
