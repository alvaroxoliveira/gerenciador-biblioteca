package Livro.Estado;

/*
 * Classe que especifíca o Estado do Livro como Emprestado de acordo com o Padrão de Projeto State aprendido em aula.
 * Esta classe é um Singleton, ou seja, pode ter apenas umas instância.
 * */

import Livro.Exemplar;
import MensagensConsole.MensagensSingletonEmprestado;
import Transacoes.TransacaoEmprestimo;
import Usuario.Usuario;

import java.time.LocalDate;

public class EstadoEmprestado implements IEstadoLivro {
    private EstadoEmprestado() {}

    public static EstadoEmprestado instance;

    public static EstadoEmprestado getInstance() {
        if(instance == null) {
            synchronized(EstadoEmprestado.class) {
                if(instance == null) {
                    instance = new EstadoEmprestado();
                }
            }
        }
        return instance;
    }

    /*
    * Método público de empréstimo de livro.
    * Como o Estado do Exemplar é Emprestado, não há como pegar emprestado novamente antes de devolve-lo para a biblioteca.
    * Assim, retorna um erro para esse caso.
    * */
    @Override
    public void emprestarLivro(Exemplar exemplar, Usuario usuario) {
        MensagensSingletonEmprestado.mensagemLivroJaFoiEmprestado();
    }

    /*
    * Método público de devolução do Livro.
    * Guarda a data da devolução do Livro e guarda uma TransaçãoEmpréstimo finalizada.
    * */
    @Override
    public void devolverLivro(Exemplar exemplar, Usuario usuario) {
        if(LocalDate.now().isAfter(TransacaoEmprestimo.encontrarTransacaoEmprestimoAtuais(exemplar)
                .getData().plusDays(usuario.getEstadoUsuario().diasParaEntrega()))) {
            usuario.setDevedor(true);
        }
        usuario.removeDaListaDeEmprestados(exemplar);
        exemplar.mudaEstado(EstadoDisponivel.getInstance());
        TransacaoEmprestimo.FinalizarEmprestimo(exemplar);
        MensagensSingletonEmprestado.mensagemDevolucaoDoLivro(exemplar.getLivro(), usuario);
    }

    /*
    * Método público para imprimir o estado
    * */
    @Override
    public String imprimirEstado() {
        return "Emprestado";
    }
}
