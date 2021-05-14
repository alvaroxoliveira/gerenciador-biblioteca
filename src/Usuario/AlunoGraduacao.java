package Usuario;

public class AlunoGraduacao extends Usuario implements IUsuario, IAlunos{
    private static final int tempoMaximoDeEmprestimoEmDias = 4;

    private static final int quantidadeMaximaDeEmprestimosAlunoGraduacao = 3;

    public AlunoGraduacao(int identificador, String nome) {
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

    // Retorna a quantidade de livros que o aluno pegou emprestado
    @Override
    public int getQuantidadeDeLivrosEmprestadosDoUsuario() {
        Usuario usuarioAlunoGraduacao = (Usuario) this;
        return usuarioAlunoGraduacao.getListaDeLivros().size();
    }
}
