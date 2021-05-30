package Transacoes;

/*
* Classe que cria e guarda uma transação de reserva de um exemplar de livro para um usuário.
* */

import Livro.Livro;
import MensagensConsole.MensagensTransacaoReserva;
import Usuario.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;

public class TransacaoReserva {
    private Livro livro;
    private Usuario usuario;
    private LocalDate data;

    private static ArrayList<TransacaoReserva> reservas = new ArrayList<>();

    public TransacaoReserva(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        this.data = LocalDate.now();
    }

    /*
    * Método publico que cria uma nova transação de reserva e adiciona à lista de reservas.
    * */
    public static void adicionarReserva(Livro livro, Usuario usuario) {
        TransacaoReserva.reservas.add(new TransacaoReserva(livro, usuario));
    }

    /*
    * Método privado que tem função de encontrar uma transação de reserva existente.
    * */
    private static TransacaoReserva encontrarTransacaoReservas(Livro livro, Usuario usuario) {
        for(TransacaoReserva transacaoReserva : TransacaoReserva.reservas) {
            //procura uma transacao onde o usuario e o livro batem
            if(transacaoReserva.getLivro().equals(livro) && transacaoReserva.getUsuario().equals(usuario)){
                return transacaoReserva;
            }
        }
        return null;
    }

    /*
    * Método público que finaliza uma transação de reserva removendo da lista de reservas.
    * */
    public static void FinalizarReserva(Livro livro, Usuario usuario) {
        TransacaoReserva.reservas.remove(encontrarTransacaoReservas(livro, usuario));
    }

    /*
    * Método publico que calcula e retorna a quantidade de livros reservados.
    * Verificar isso depois
    * */
    public static int quantidadeReserva(Livro livro){
        int qtd = 0;
        for(TransacaoReserva transacaoReserva : TransacaoReserva.reservas) {
            if(transacaoReserva.getLivro().getId().equals(livro.getId())) {
                qtd++;
            }
        }
        return qtd;
    }

    /*
    * Método que imprime a reserva de um livro por um usuário.
    * */
    public static void imprimirUsuariosReserva(Livro livro){
        for(TransacaoReserva transacaoReserva : TransacaoReserva.reservas) {
            if(transacaoReserva.getLivro().getId().equals(livro.getId())){
                MensagensTransacaoReserva.mensagemTransacaoReservaDoLivro(transacaoReserva);
            }
        }
    }

    /*
    * Getters/Setters
    * */

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public static ArrayList<TransacaoReserva> getReservas() {
        return reservas;
    }

    public static void setReservas(ArrayList<TransacaoReserva> reservas) {
        TransacaoReserva.reservas = reservas;
    }
}
