package Usuario.Estado;

import Livro.Estado.IEstadoLivro;
import Livro.Livro;

public class AlunoPosGraduacao implements IEstadoLivro {
    private AlunoPosGraduacao() {}

    public static AlunoPosGraduacao instance; //cada livro só vai ter uma instancia de cada estado

    public static AlunoPosGraduacao getInstance() { //se não existir instancia, cria uma
        if(instance == null) {
            synchronized(AlunoPosGraduacao.class) {
                if(instance == null) {
                    instance = new AlunoPosGraduacao();
                }
            }
        }
        return instance;
    }

    @Override
    public void emprestarLivro(Livro livro) {

    }

    @Override
    public void devolverLivro(Livro livro) {

    }

    @Override
    public void reservarLivro(Livro livro) {

    }
}
