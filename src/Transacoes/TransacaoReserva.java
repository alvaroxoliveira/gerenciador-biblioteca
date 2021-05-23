package Transacoes;

import Livro.Livro;
import Usuario.User;
import Livro.Exemplar;

import java.util.ArrayList;
import java.time.LocalDate;

public class TransacaoReserva {
    private Livro livro;
    private User usuario;
    private LocalDate data;

    private static ArrayList<TransacaoReserva> reservas = new ArrayList<>();

    public TransacaoReserva(Livro livro, User usuario){
        this.livro = livro;
        this.usuario = usuario;
        this.data = LocalDate.now();
    }

    //cria uma nova transação e adiciona as reservas
    public static void adicionarReserva(Livro livro, User usuario) {
        TransacaoReserva.reservas.add(new TransacaoReserva(livro, usuario));
    }

    //metodo para finalizar uma reserva
    public static void FinalizarReserva(Livro livro, User usuario){
        TransacaoReserva.reservas.remove(encontrarTransacaoReservas(livro, usuario));
    }

    //calcula quantos livros tem reservaos utilizando o codigo do livro nos exemplares
    public static int quantidadeReserva(Livro livro){
        int qtd = 0;
        for(TransacaoReserva transacaoReserva : TransacaoReserva.reservas){
            if(transacaoReserva.getLivro().getId().equals(livro.getId())){
                qtd++;
            }
        }
        return qtd;
    }

    //método para imprimir os usuários que fizeram reserva do livro passado
    public static void imprimirUsuariosReserva(Livro livro){
        for(TransacaoReserva transacaoReserva : TransacaoReserva.reservas){
            if(transacaoReserva.getLivro().getId().equals(livro.getId())){
                System.out.println("Reserva do livro " + transacaoReserva.getLivro().getId() + " feita por " + transacaoReserva.getUsuario().getNome() + ".");
            }
        }
    }

    private static TransacaoReserva encontrarTransacaoReservas(Livro livro, User usuario){
        for(TransacaoReserva transacaoReserva : TransacaoReserva.reservas) {
            //procura uma transacao onde o usuario e o livro batem
            if(transacaoReserva.getLivro().equals(livro) && transacaoReserva.getUsuario().equals(usuario)){
                return transacaoReserva;
            }
        }
        return null;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
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
