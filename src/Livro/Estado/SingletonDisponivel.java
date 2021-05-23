package Livro.Estado;

import Comando.BuscaLivro;
import Transacoes.TransacaoEmprestimo;
import Livro.Exemplar;
import Transacoes.TransacaoReserva;
import Usuario.User;

public class SingletonDisponivel implements IEstadoLivro {
    private SingletonDisponivel() {}

    public static SingletonDisponivel instance; //cada livro só vai ter uma instancia de cada estado

    public static SingletonDisponivel getInstance() { //se não existir instancia, cria uma
        if(instance == null) {
            synchronized(SingletonDisponivel.class) {
                if(instance == null) {
                    instance = new SingletonDisponivel();
                }
            }
        }
        return instance;
    }

    @Override
    public void emprestarLivro(Exemplar exemplar, User user) {
        user.adicionaNaListaDeEmprestados(exemplar);
        if(user.verificaSeJaTemOLivroReservado(exemplar.getCodigoDoLivro())){ //caso o usuario tenha o livro reservado
            user.removeDaListaDeReservados(BuscaLivro.getLivro(exemplar.getCodigoDoLivro())); //remove o livro a partir do exemplar da lista de reservados
            TransacaoReserva.FinalizarReserva(BuscaLivro.getLivro(exemplar.getCodigoDoLivro()), user); //chama o método de remover da lista de transacoes (reserva)
        }
        exemplar.mudaEstado(SingletonEmprestado.getInstance());
        TransacaoEmprestimo.adicionarEmprestimoAtual(exemplar, user);
        System.out.println("O usuário " + user.getNome() + " fez empréstimo do livro " + exemplar.getTitulo() + ".");
    }

    @Override
    public void devolverLivro(Exemplar exemplar, User user) {
        System.out.println("Você não pode devolver um exemplar que está disponível.");
    }

    //método para imprimir o estado na consulta
    @Override
    public String imprimirEstado() {
        return "Disponivel.";
    }
}
