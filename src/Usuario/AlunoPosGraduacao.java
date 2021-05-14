package Usuario;

public class AlunoPosGraduacao extends Usuario implements IUsuario, IAlunos{

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

    // Retorna a quantidade de livros que o aluno pegou emprestado
    @Override
    public int getQuantidadeDeLivrosEmprestadosDoUsuario() {
        Usuario usuarioAlunoPosGraduacao = (Usuario) this;
        return usuarioAlunoPosGraduacao.getListaDeLivros().size();
    }
}
