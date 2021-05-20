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

    // Retorna a quantidade de exemplares disponíveis
    public Exemplar obterExemplarDisponivel() {
        for(Exemplar exemplar: this.exemplares) {
            if(exemplar.getEstadoExemplar() == SingletonDisponivel.getInstance()) {
                return exemplar;
            }
        }
        return null;
    }

    public void pegarExemplarEmprestado(User user) {
        for(Exemplar exemplar: this.exemplares) {
            if(exemplar.getEstadoExemplar().emprestarLivro(exemplar, user)) {
                System.out.println("Exemplar adicionado na lista de empréstimo do usuário.");
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