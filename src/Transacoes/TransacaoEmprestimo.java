package Transacoes;

import Livro.Exemplar;
import Usuario.User;

import java.time.LocalDate;
import java.util.ArrayList;

public class TransacaoEmprestimo {
    private Exemplar exemplar;
    private User usuario;
    private LocalDate data;
    // Colocar um estado em vez de passar na função de imprimir??
    private static ArrayList<TransacaoEmprestimo> emprestimosAtuais = new ArrayList<>();
    private static ArrayList<TransacaoEmprestimo> emprestimosFinalizados = new ArrayList<>();

    public TransacaoEmprestimo(Exemplar exemplar, User usuario){
        this.exemplar = exemplar;
        this.usuario = usuario;
        this.data = LocalDate.now();
    }

    //cria uma nova transação e adiciona aos emprestimos ativos
    public static void adicionarEmprestimoAtual(Exemplar exemplar, User usuario) {
        TransacaoEmprestimo.emprestimosAtuais.add(new TransacaoEmprestimo(exemplar, usuario));
    }

    //metodo para finalizar emprestimo (retira da lista de ativos e adiciona nos finalizados)
    public static void FinalizarEmprestimo(Exemplar exemplar) {
        TransacaoEmprestimo.emprestimosFinalizados.add(encontrarTransacaoEmprestimoAtuais(exemplar));
        TransacaoEmprestimo.emprestimosAtuais.remove(encontrarTransacaoEmprestimoAtuais(exemplar));
    }

    public static int quantidadeEmprestimosFinalizados(User usuario){
        int qtd = 0;
        for(TransacaoEmprestimo transacaoEmprestimo : TransacaoEmprestimo.emprestimosFinalizados){
            if(transacaoEmprestimo.getUsuario().equals(usuario)){
                qtd++;
            }
        }
        return qtd;
    }

    private static TransacaoEmprestimo encontrarTransacaoEmprestimoAtuais(Exemplar exemplar){
        for(TransacaoEmprestimo transacaoEmprestimo : TransacaoEmprestimo.emprestimosAtuais) {
            if(transacaoEmprestimo.exemplar.equals(exemplar)){
                return transacaoEmprestimo;
            }
        }
        return null;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
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
}
