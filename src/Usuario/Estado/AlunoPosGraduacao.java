package Usuario.Estado;

import Livro.Estado.IEstadoLivro;
import Livro.Livro;

public class AlunoPosGraduacao implements IEstadoUsuario {
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
    public void pegarLivroEmprestado(int codigoDoLivro) {

    }

    @Override
    public void devolverLivroEmprestado(int codigoDoLivro) {

    }

    @Override
    public void reservarLivro(int codigoDoLivro) {

    }

    @Override
    public void consultarLivro(int codigoDoLivro) {

    }
}
