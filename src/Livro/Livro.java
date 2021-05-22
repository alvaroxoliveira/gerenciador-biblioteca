package Livro;

import Livro.Estado.SingletonDisponivel;
import Observer.Observer;
import Observer.Subject;
import Usuario.User;
import Transacoes.Transacao;

import java.util.ArrayList;

public class Livro implements Subject {
    private String id;
    private String titulo;
    private String editora;
    private String autores;
    private String edicao;
    private int anoDePublicacao;

    private ArrayList<Exemplar> exemplares = new ArrayList<Exemplar>();
    private final ArrayList<Observer> observadores = new ArrayList<Observer>();

    public Livro(String id, String titulo, String editora, String autores, String edicao, int anoDePublicacao) {
        this.id = id;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoDePublicacao = anoDePublicacao;
    }

    public void adicionaExemplar(Exemplar exemplar) {
        this.exemplares.add(exemplar);
    }

    // Retorna o exemplar da lista de exemplares do livro que estiver disponível
    public Exemplar obterExemplarDisponivel() {
        for(Exemplar exemplar: this.exemplares) {
            if(exemplar.getEstadoExemplar() == SingletonDisponivel.getInstance()) {
                return exemplar;
            }
        }
        return null;
    }

    public void pegarExemplarEmprestado(User user) {
        // Vai verificar se existe um exemplar do livro reservado
        for(Exemplar exemplarDoLivro: this.exemplares) {
            for (Exemplar reservado: user.getListaDeReservados()) {
                if(exemplarDoLivro.getCodigoExemplar().equals(reservado.getCodigoExemplar())) {
                    exemplarDoLivro.getEstadoExemplar().emprestarLivro(exemplarDoLivro, user);
                    user.removeDaListaDeReservados(reservado);
                    System.out.println("Exemplar reservado adicionado na lista de empréstimo do usuário.");
                    return;
                }
            }
        }

        // Esse trecho acontece se o usuário não ja estiver com o livro reservado
        for(Exemplar exemplar: this.exemplares) {
            exemplar.getEstadoExemplar().emprestarLivro(exemplar, user);
            return;
        }
        System.out.println("Não existe exemplar Disponível");
    }

    public void devolverLivroEmprestado(User user) {
        for(Exemplar exemplarDoLivro: this.exemplares) {
            for (Exemplar exemplarEmprestado: user.getListaDeLivrosEmprestados()) {
                if(exemplarDoLivro.getCodigoExemplar().equals(exemplarEmprestado.getCodigoExemplar())) {
                    exemplarDoLivro.getEstadoExemplar().devolverLivro(exemplarDoLivro, user);
                    return;
                }
            }
        }
    }

    //faz a reserva de um exemplar recebendo o usuário que a vai fazer
    public void reservarExemplar(User user) { //Caio
        // Vai verificar se existe um exemplar do livro reservado
        for(Exemplar exemplarDoLivro: this.exemplares) {
            for (Exemplar reservados: user.getListaDeReservados()) {
                //caso o usuário tenha um exemplar reservado ele não reserva outro
                if(exemplarDoLivro.getCodigoExemplar().equals(reservados.getCodigoExemplar())) {
                    System.out.println("Já existe um exemplar reservado.");
                    return;
                }
            }
        }

        //Procura um exemplar que não tenha sido reservado (que não esteja na lista de reserva) e chama o método
        //de reserver livro do estado do exemplar
        if(Transacao.quantidadeReserva(this) > 0){ //caso haja reserva, testa se o exemplar foi reservado
            for(Exemplar exemplar: this.exemplares) {
                for(Transacao reserva: Transacao.getReservas()){
                    //se existir algum exemplar do livro que não foi reservado
                    if(reserva.getExemplar().getCodigoDoLivro().equals(exemplar.getCodigoDoLivro()) && !reserva.getExemplar().equals(exemplar)){
                        exemplar.getEstadoExemplar().reservarLivro(exemplar, user);
                        return;
                    }
                }
            }
        }
        else{ //caso não haja reserva
            for(Exemplar exemplar: this.exemplares) {
                exemplar.getEstadoExemplar().reservarLivro(exemplar, user);
                return;
            }
        }

        System.out.println("Não existe exemplar Disponível");
    }

    public void consultarLivro() {
        System.out.println("Título: " + this.titulo);

        //passa o próprio livro e usa o vetor de reservad os para saber quantos exemplares estão reservados
        System.out.println("Quantidade de reservas: " + Transacao.quantidadeReserva(this));
        if(Transacao.quantidadeReserva(this) > 0){
            //chama o método para imprimir os usuários e os exemplares reservados por esses
            Transacao.imprimirUsuariosReserva(this);
        }

        //imprime cada exemplar e caso esteja emprestado imprime outras informações
        System.out.println("Exemplares: ");
        for(Exemplar exemplar: this.exemplares){
            System.out.println("Código: " + exemplar.getCodigoExemplar());
            //usa o método polimorfico para impimir o estado do livro
            System.out.println("Estado: " + exemplar.getEstadoExemplar().imprimirEstado());
            //commpara o exemplar atual com os exemplares na lista de emprestimos ativos
            for(Transacao transacao: Transacao.getEmprestimosAtuais()){
                //caso o exemplar esteja emprestado, imprime as informações
                if(exemplar.getCodigoExemplar().equals(transacao.getExemplar().getCodigoExemplar())){
                    System.out.println("Usuario: " + transacao.getUsuario().getNome());
                    System.out.println("Data de emprestimo: " + transacao.getData());
                    //soma a data do emprestimo com a quantidade de dias expresso no metodo polimorfico correspondente a cada usuario
                    System.out.println("Data de entrega: " + transacao.getData().plusDays(transacao.getUsuario().getEstadoUsuario().diasParaEntrega()));
                }
            }
        }
    }

    // Adiciona um observer a uma lista de observadores que no caso são os usuários com status de Professores
    @Override
    public void adicionarObserver(Observer observer) {
        this.observadores.add(observer);
    }

    // Notifica uma lista de observadores
    @Override
    public void notificarObserver() {
        for(Observer observer: this.observadores) {
            observer.avisarReservasSimultaneas();
        }
    }

    public ArrayList<Exemplar> getExemplares() {
        return exemplares;
    }

    public void setExemplares(ArrayList<Exemplar> exemplares) {
        this.exemplares = exemplares;
    }

    public ArrayList<Observer> getObservadores() {
        return observadores;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public void setAnoDePublicacao(int anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }
}