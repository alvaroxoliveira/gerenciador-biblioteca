package Livro;

import Livro.Estado.SingletonDisponivel;
import Observer.Observer;
import Observer.Subject;
import Usuario.User;

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

    @Override
    public void adicionarObserver(Observer observer) {
        this.observadores.add(observer);
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
            for (Exemplar reservados: user.getListaDeReservados()) {
                if(exemplarDoLivro.getCodigoExemplar().equals(reservados.getCodigoExemplar())) {
                    exemplarDoLivro.getEstadoExemplar().emprestarLivro(exemplarDoLivro, user);
                    return;
                }
            }
        }

        // Esse trecho acontece se o usuário não ja estiver com o livro reservado
        for(Exemplar exemplar: this.exemplares) {
            if(exemplar.getEstadoExemplar().emprestarLivro(exemplar, user)) {
                System.out.println("Exemplar adicionado na lista de empréstimo do usuário.");
                return;
            }
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

    public void reservarExemplar(User user) { //Caio
        // Vai verificar se existe um exemplar do livro reservado
        for(Exemplar exemplarDoLivro: this.exemplares) {
            for (Exemplar reservados: user.getListaDeReservados()) {
                if(exemplarDoLivro.getCodigoExemplar().equals(reservados.getCodigoExemplar())) {
                    System.out.println("Já existe um exemplar reservado.");
                    return;
                }
            }
        }

        //Caso não tenha exemplar reservado, ele tenta reservar um
        for(Exemplar exemplar: this.exemplares) {
            if(exemplar.getEstadoExemplar().reservarLivro(exemplar, user)) {
                System.out.println("Exemplar adicionado na lista de reservas do usuário.");
                return;
            }
        }
        System.out.println("Não existe exemplar Disponível");
    }

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