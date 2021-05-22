package Transacoes;

import Livro.Livro;
import Usuario.User;
import Livro.Exemplar;

import java.util.ArrayList;
import java.time.LocalDate;

public class Transacao {
    private Exemplar exemplar;
    private User usuario;
    private LocalDate data;

    private static ArrayList<Transacao> reservas = new ArrayList<>();
    private static ArrayList<Transacao> emprestimosAtuais = new ArrayList<>();
    private static ArrayList<Transacao> emprestimosFinalizados = new ArrayList<>();

    public Transacao(Exemplar exemplar, User usuario){
        this.exemplar = exemplar;
        this.usuario = usuario;
        this.data = LocalDate.now();
    }

    public Transacao(){};

    //cria uma nova transação e adiciona as reservas
    public static void adicionarReserva(Exemplar exemplar, User usuario) {
        Transacao.reservas.add(new Transacao(exemplar, usuario));
    }

    //cria uma nova transação e adiciona aos emprestimos ativos
    public static void adicionarEmprestimoAtual(Exemplar exemplar, User usuario) {
        Transacao.emprestimosAtuais.add(new Transacao(exemplar, usuario));
    }

    //metodo para finalizar uma reserva
    public static void FinalizarReserva(Exemplar exemplar){
        Transacao.reservas.remove(encontrarTransacaoReservas(exemplar));
    }

    //metodo para finalizar emprestimo (retira da lista de ativos e adiciona nos finalizados)
    public static void FinalizarEmprestimo(Exemplar exemplar) {
        Transacao.emprestimosFinalizados.add(encontrarTransacaoEmprestimoAtuais(exemplar));
        Transacao.emprestimosAtuais.remove(encontrarTransacaoEmprestimoAtuais(exemplar));
    }

    //calcula quantos livros tem reservaos utilizando o codigo do livro nos exemplares
    public static int quantidadeReserva(Livro livro){
        int qtd = 0;
        for(Transacao transacao: Transacao.reservas){
            if(transacao.getExemplar().getCodigoDoLivro().equals(livro.getId())){
                qtd++;
            }
        }
        return qtd;
    }

    //método para imprimir os usuários que fizeram reserva do livro passado
    public static void imprimirUsuariosReserva(Livro livro){
        for(Transacao transacao: Transacao.reservas){
            if(transacao.getExemplar().getCodigoDoLivro().equals(livro.getId())){
                System.out.println("Reserva do exemplar " + transacao.getExemplar().getCodigoExemplar() + " feita por " + transacao.getUsuario().getNome() + ".");
            }
        }
    }

    public static int quantidadeEmprestimosFinalizados(User usuario){
        int qtd = 0;
        for(Transacao transacao: Transacao.emprestimosFinalizados){
            if(transacao.getUsuario().equals(usuario)){
                qtd++;
            }
        }
        return qtd;
    }

    //metodo para imprimir os emprestimos finalizados do usuario passado
    public static void imprimirEmprestimosFinalizados(User usuario){
        for(Transacao transacao: Transacao.emprestimosFinalizados){
            if(transacao.getUsuario().equals(usuario)){
                System.out.println("Titulo: " + transacao.getExemplar().getTitulo());
                System.out.println("Data do empréstimo: " + transacao.getData());
                System.out.println("Estado: Finalizado");
                System.out.println("Data do devolução: " + transacao.getData().plusDays(transacao.getUsuario().getEstadoUsuario().diasParaEntrega()));
            }
        }
    }

    private static Transacao encontrarTransacaoEmprestimoAtuais(Exemplar exemplar){
        for(Transacao transacao: Transacao.emprestimosAtuais) {
            if(transacao.exemplar.equals(exemplar)){
                return transacao;
            }
        }
        return null;
    }

    private static Transacao encontrarTransacaoReservas(Exemplar exemplar){
        for(Transacao transacao: Transacao.reservas) {
            if(transacao.exemplar.equals(exemplar)){
                return transacao;
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

    public static ArrayList<Transacao> getEmprestimosAtuais() {
        return emprestimosAtuais;
    }

    public static ArrayList<Transacao> getReservas() {
        return reservas;
    }

    public static ArrayList<Transacao> getEmprestimosFinalizados() {
        return emprestimosFinalizados;
    }

    public LocalDate getData() {
        return data;
    }
}