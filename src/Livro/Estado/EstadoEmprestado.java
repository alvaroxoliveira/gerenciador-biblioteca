package Livro.Estado;

import Livro.Exemplar;
import MensagensConsole.MensagensSingletonEmprestado;
import Transacoes.TransacaoEmprestimo;
import Usuario.User;

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

    @Override
    public void emprestarLivro(Exemplar exemplar, User user) {
        MensagensSingletonEmprestado.mensagemLivroJaFoiEmprestado();
    }

    @Override
    public void devolverLivro(Exemplar exemplar, User user) {
        // Fazer a lógica para verificar se o usuario passa a ser devedor
        // Lógica para tornar o usuário devedor caso entrega for numa data posterior à prevista
        if(LocalDate.now().isAfter(TransacaoEmprestimo.encontrarTransacaoEmprestimoAtuais(exemplar).getData().plusDays(user.getEstadoUsuario().diasParaEntrega()))) {
            user.setDevedor(true);
        }
        user.removeDaListaDeEmprestados(exemplar);
        exemplar.mudaEstado(EstadoDisponivel.getInstance());
        TransacaoEmprestimo.FinalizarEmprestimo(exemplar);
        MensagensSingletonEmprestado.mensagemDevolucaoDoLivro(user.getNome(), exemplar.getLivro().getTitulo());
    }

    //método para imprimir o estado na consulta
    @Override
    public String imprimirEstado() {
        return "Emprestado";
    }
}
