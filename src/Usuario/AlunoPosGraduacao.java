package Usuario;

public class AlunoPosGraduacao extends Usuario implements IUsuario{

    public AlunoPosGraduacao(int identificador, String nome) {
        super(identificador, nome);
    }

    private static final int tempoMaximoDeEmprestimoEmDias = 4;
    private static final int quantidadeMaximaDeEmprestimosAlunosPosGraduacao = 4;

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
