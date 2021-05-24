package Livro.Estado;

import Livro.Exemplar;
import MensagensConsole.MensagensSingletonEmprestado;
import Transacoes.TransacaoEmprestimo;
import Usuario.User;

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
//        System.out.println("Não há como pegar emprestado um livro que já está emprestado.");
        MensagensSingletonEmprestado.mensagemLivroJaFoiEmprestado();
    }

    @Override
    public void devolverLivro(Exemplar exemplar, User user) {
        user.removeDaListaDeEmprestados(exemplar);
        exemplar.mudaEstado(SingletonDisponivel.getInstance());

        //Chama o método de finalizar empréstimo
        TransacaoEmprestimo.FinalizarEmprestimo(exemplar);

//        System.out.println("O usuário " + user.getNome() + " devolveu o livro " + exemplar.getTitulo() + ".");
        MensagensSingletonEmprestado.mensagemDevolucaoDoLivro(user.getNome(), exemplar.getTitulo());
    }

    //método para imprimir o estado na consulta
    @Override
    public String imprimirEstado() {
        return "Emprestado";
    }
}
