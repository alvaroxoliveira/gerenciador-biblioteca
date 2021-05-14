package Usuario;

public class AlunoGraduacao extends Usuario implements IUsuario{

    public AlunoGraduacao(int identificador, String nome) {
        super(identificador, nome);
    }

    private static final int tempoMaximoDeEmprestimoEmDias = 4;
    private static final int quantidadeMaximaDeEmprestimosAlunoGraduacao = 3;

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
