package Usuario.Estado;
import Comando.BuscaLivro;
import Comando.BuscaUsuario;
import Livro.Livro;
import Transacoes.TransacaoEmprestimo;
import Transacoes.TransacaoReserva;
import Usuario.User;
import Livro.Exemplar;

import javax.swing.plaf.basic.BasicButtonUI;

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

    @Override
    public void pegarLivroEmprestado(String codigoDoLivro, User user) {
        if(user.getListaDeLivrosEmprestados().size() >= 3){
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

    //faz a reserva de um livro passando o código e o usuário que vai a fazer
    @Override
    public void reservarLivro(String codigoDoLivro, User user) { //Caio
        if(user.getListaDeReservados().size() < 3) { //caso o usuario tenha menos que 3 livros reservados
            BuscaLivro.getLivro(codigoDoLivro).reservarLivro(user); //reservar livro
        } else {
            System.out.println("Usuário " + user.getNome() + " ja tem a quantidade máxima de livros reservados.");
            return;
        }
    }

    //metodo polimorfico para saber a qtd de dia de cada tipo de usuario
    @Override
    public int diasParaEntrega() {
        return 3;
    }

}
