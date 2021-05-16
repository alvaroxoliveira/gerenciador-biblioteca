package Usuario.Estado;

import Livro.Estado.IEstadoLivro;
import Livro.Estado.SingletonDisponivel;
import Livro.Estado.SingletonEmprestado;
import Livro.Estado.SingletonReservado;
import Livro.Livro;

public class AlunoGraduacao implements IEstadoUsuario {
    private AlunoGraduacao() {}

    public static AlunoGraduacao instance; //cada livro só vai ter uma instancia de cada estado

    public static AlunoGraduacao getInstance() { //se não existir instancia, cria uma
        if(instance == null) {
            synchronized(AlunoGraduacao.class) {
                if(instance == null) {
                    instance = new AlunoGraduacao();
                }
            }
        }
        return instance;
    }
}
