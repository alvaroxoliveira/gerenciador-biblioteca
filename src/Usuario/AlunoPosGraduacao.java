package Usuario;

public class AlunoPosGraduacao extends Usuario implements IUsuario{

    public AlunoPosGraduacao(int identificador, String nome) {
        super(identificador, nome);
    }

    @Override
    public void emprestimo() {

    }

    @Override
    public void devolucao() {

    }

    @Override
    public void reserva() {

    }
}
