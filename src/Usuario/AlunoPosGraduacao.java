package Usuario;

public class AlunoPosGraduacao extends User implements IUsuario, IAlunos{
    private static final int tempoMaximoDeEmprestimoEmDias = 4;
    private static final int quantidadeMaximaDeEmprestimosAlunosPosGraduacao = 4;

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

    //Retorna a quantidade de livros que o aluno pegou emprestado
    @Override
    public int getQuantidadeDeLivrosEmprestadosDoUsuario() {
        User userAlunoPosGraduacao = (User) this;
        return userAlunoPosGraduacao.getListaDeLivrosEmprestados().size();
    }
}
