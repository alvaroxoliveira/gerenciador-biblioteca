package Livro;

import Livro.Estado.IEstadoLivro; //pra importar de outro pacote
import Livro.Estado.SingletonDisponivel;
import Observer.Observer;
import Observer.Subject;

import java.util.ArrayList;

public class Livro implements Subject {
    private String id;
    private String titulo;
    private String editora;
    private String autores;
    private String edicao;
    private int anoDePublicacao;
    private IEstadoLivro estadoLivro; //estado do livro usado no singleton
    private ArrayList<Observer> observadores = new ArrayList<Observer>();

    public Livro(IEstadoLivro estadoInicial) {
        this.estadoLivro = estadoInicial;
    }

    public Livro(String id, String titulo, String editora, String autores, String edicao, int anoDePublicacao) {
        this.id = id;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoDePublicacao = anoDePublicacao;
        this.estadoLivro = SingletonDisponivel.getInstance();
    }

    public void emprestarLivro(){
        estadoLivro.emprestarLivro(this);
    }

    public void devolverLivro(){
        estadoLivro.devolverLivro(this);
    }

    public void reservarLivro(){
        estadoLivro.reservarLivro(this);
    }

    // Mudança de estado como manda  o padrão state implementado na aplicação
    public void mudarEstado(IEstadoLivro estadoLivro) {
        this.estadoLivro = estadoLivro;
    }

    @Override
    public void adicionarObserver(Observer observer) {
        this.observadores.add(observer);
    }

    @Override
    public void notificarObserver() {
        for(Observer observer: this.observadores) {
            observer.avisarReservasSimultaneas();
        }
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

    public IEstadoLivro getEstadoLivro() {
        return estadoLivro;
    }

    public void setEstadoLivro(IEstadoLivro estadoLivro) {
        this.estadoLivro = estadoLivro;
    }
}
