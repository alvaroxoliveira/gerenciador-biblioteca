package Usuario;

public class Professor extends Usuario implements IUsuario {
    public Professor(int identificador, String nome) {
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
