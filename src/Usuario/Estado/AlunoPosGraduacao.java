package Usuario.Estado;

import Comando.BuscaLivro;
import Livro.Estado.IEstadoLivro;
import Livro.Livro;
import Transacoes.TransacaoEmprestimo;
import Transacoes.TransacaoReserva;
import Usuario.User;

public class AlunoPosGraduacao implements IEstadoUsuario {
    private AlunoPosGraduacao() {}

    public static AlunoPosGraduacao instance; //cada aluno só vai ter uma instancia de cada estado

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
    public void pegarLivroEmprestado(String codigoDoLivro, User user) {
        if(user.getListaDeLivrosEmprestados().size() >= 4){
            System.out.println("Usuário " + user.getNome() + " ja tem a quantidade máxima de livros emprestados.");
        }
        //se a quantidade de reservas for maior ou igual a quantidade de exemplares
        else{
            BuscaLivro.getLivro(codigoDoLivro).pegarLivroEmprestado(user);
        }
    }

    @Override
    public void devolverLivroEmprestado(String codigoDoLivro, User user) {
        BuscaLivro.getLivro(codigoDoLivro).devolverLivroEmprestado(user);
    }

    @Override
    public void reservarLivro(String codigoDoLivro, User user) { //Caio
        if(user.getListaDeReservados().size() < 3) { //caso o usuario tenha menos que 3 livros reservados
            TransacaoReserva.adicionarReserva(BuscaLivro.getLivro(codigoDoLivro), user);
            user.getListaDeReservados().add(BuscaLivro.getLivro(codigoDoLivro));
            System.out.println("O usuário " + user.getNome() + " fez a reserva do livro " + BuscaLivro.getLivro(codigoDoLivro).getTitulo() + ".");
            if(TransacaoReserva.quantidadeReserva(BuscaLivro.getLivro(codigoDoLivro)) == 3) { //se passou de 2 reservas, notifica o professor
                user.avisarReservasSimultaneas(); //notifica o professor
            }
        } else {
            System.out.println("Usuário " + user.getNome() + " ja tem a quantidade máxima de livros reservados.");
            return;
        }
    }

    //metodo polimorfico para saber a qtd de dia de cada tipo de usuario
    @Override
    public int diasParaEntrega() {
        return 4;
    }
}
