package Livro.Estado;

/*
* Classe que especifíca o Estado do Livro como Disponível de acordo com o Padrão de Projeto State aprendido em aula.
* Esta classe é um Singleton, ou seja, pode ter apenas umas instância.
* */

import Livro.Exemplar;
import MensagensConsole.MensagensSingletonDisponivel;
import Transacoes.TransacaoEmprestimo;
import Transacoes.TransacaoReserva;
import Usuario.Usuario;

public class EstadoDisponivel implements IEstadoLivro {
    private EstadoDisponivel() {}

    public static EstadoDisponivel instance;

    public static EstadoDisponivel getInstance() {
        if(instance == null) {
            synchronized(EstadoDisponivel.class) {
                if(instance == null) {
                    instance = new EstadoDisponivel();
                }
            }
        }
        return instance;
    }

    /*
    * Método público para empréstimo de um Exemplar do Livro.
    * Adiciona uma transação de empréstimo contendo o Exemplar e o usuário.
    * */
    @Override
    public void emprestarLivro(Exemplar exemplar, Usuario usuario) {
        usuario.adicionaNaListaDeEmprestados(exemplar);
        if(usuario.verificaSeJaTemOLivroReservado(exemplar.getLivro())){
            usuario.removeDaListaDeReservados(exemplar.getLivro());
            TransacaoReserva.FinalizarReserva(exemplar.getLivro(), usuario);
        }
        exemplar.mudaEstado(EstadoEmprestado.getInstance());
        TransacaoEmprestimo.adicionarEmprestimoAtual(exemplar, usuario);
        MensagensSingletonDisponivel.mensagemEmprestimoDoLivroFeito(usuario.getNome(), exemplar.getLivro().getTitulo());
    }

    /*
    * Método público para devolução de um Exemplar do Livro.
    * Como o Exemplar está com estado Disponível não há como devolver, então mostra uma mensagem de erro.
    * */
    @Override
    public void devolverLivro(Exemplar exemplar, Usuario usuario) {
        MensagensSingletonDisponivel.mensagemNaoDevolverPoqueEstaDisponivel();
    }

    /*
    * Método para imprimir o estado, se consultado.
    * */
    @Override
    public String imprimirEstado() {
        return "Disponivel.";
    }
}
