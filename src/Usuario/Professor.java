package Usuario;

public class Professor extends User implements IUsuario {
    public Professor(int identificador, String nome) {
        super(identificador, nome);
    }
    private static final int tempoMaximoDeEmprestimoEmDias = 7;

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
