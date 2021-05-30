package Transacoes;

/*
* Classe que cria e guarda uma transação de empréstimo de um exemplar de livro para um usuário.
* */

import Livro.Exemplar;
import Usuario.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;

public class TransacaoEmprestimo {
    private Exemplar exemplar;
    private Usuario usuario;
    private LocalDate data;
    private boolean estaFinalizado;

    private static ArrayList<TransacaoEmprestimo> emprestimosAtuais = new ArrayList<>();
    private static ArrayList<TransacaoEmprestimo> emprestimosFinalizados = new ArrayList<>();

    public TransacaoEmprestimo(Exemplar exemplar, Usuario usuario){
        this.exemplar = exemplar;
        this.usuario = usuario;
        this.estaFinalizado = false;
        this.data = LocalDate.now();
    }

    /*
    * Método público de criação e adição em lista de uma Transação de Empréstimo.
    * */
    public static void adicionarEmprestimoAtual(Exemplar exemplar, Usuario usuario) {
        TransacaoEmprestimo.emprestimosAtuais.add(new TransacaoEmprestimo(exemplar, usuario));
    }

    /*
    * Método Público de finalização de uma Transação de Empréstimo.
    * Adiciona na lista de finalizados e remove na dos atuais.
    * */
    public static void FinalizarEmprestimo(Exemplar exemplar) {
        encontrarTransacaoEmprestimoAtuais(exemplar).setEstaFinalizado(true);
        TransacaoEmprestimo.emprestimosFinalizados.add(encontrarTransacaoEmprestimoAtuais(exemplar));
        TransacaoEmprestimo.emprestimosAtuais.remove(encontrarTransacaoEmprestimoAtuais(exemplar));
    }

    /*
    * Método público que retorna a quantidade de empréstimos finalizados.
    * */
    public static int quantidadeEmprestimosFinalizados(Usuario usuario){
        int qtd = 0;
        for(TransacaoEmprestimo transacaoEmprestimo : TransacaoEmprestimo.emprestimosFinalizados){
            if(transacaoEmprestimo.getUsuario().equals(usuario)){
                qtd++;
            }
        }
        return qtd;
    }

    /*
    * Método público de busca de uma Transação de um Empréstimo Atual.
    * Verificações anteriores garantem que nunca será null.
    * */
    public static TransacaoEmprestimo encontrarTransacaoEmprestimoAtuais(Exemplar exemplar){
        for(TransacaoEmprestimo transacaoEmprestimo : TransacaoEmprestimo.emprestimosAtuais) {
            if(transacaoEmprestimo.exemplar.equals(exemplar)){
                return transacaoEmprestimo;
            }
        }
        return null;
    }

    /*
    * Getters/Setters.
    * */

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public static ArrayList<TransacaoEmprestimo> getEmprestimosAtuais() {
        return emprestimosAtuais;
    }

    public static ArrayList<TransacaoEmprestimo> getEmprestimosFinalizados() {
        return emprestimosFinalizados;
    }

    public LocalDate getData() {
        return data;
    }

    public boolean isEstaFinalizado() {
        return estaFinalizado;
    }

    public void setEstaFinalizado(boolean estaFinalizado) {
        this.estaFinalizado = estaFinalizado;
    }
}
