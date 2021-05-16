package Usuario.Estado;

import Livro.Estado.IEstadoLivro;
import Livro.Livro;

public class Professor implements IEstadoUsuario {
    private Professor() {}

    public static Professor instance; //cada livro só vai ter uma instancia de cada estado

    public static Professor getInstance() { //se não existir instancia, cria uma
        if(instance == null) {
            synchronized(Professor.class) {
                if(instance == null) {
                    instance = new Professor();
                }
            }
        }
        return instance;
    }
}
