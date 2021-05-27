package Livro.Estado;

import Livro.Exemplar;
import MensagensConsole.MensagensSingletonEmprestado;
import Transacoes.TransacaoEmprestimo;
import Usuario.User;

import java.time.LocalDate;

public class SingletonEmprestado implements IEstadoLivro {
    private SingletonEmprestado() {}

    public static SingletonEmprestado instance;

    public static SingletonEmprestado getInstance() {
        if(instance == null) {
            synchronized(SingletonEmprestado.class) {
                if(instance == null) {
                    instance = new SingletonEmprestado();
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
        exemplar.mudaEstado(SingletonDisponivel.getInstance());
        TransacaoEmprestimo.FinalizarEmprestimo(exemplar);
        MensagensSingletonEmprestado.mensagemDevolucaoDoLivro(user.getNome(), exemplar.getLivro().getTitulo());
    }

    //método para imprimir o estado na consulta
    @Override
    public String imprimirEstado() {
        return "Emprestado";
    }
}
