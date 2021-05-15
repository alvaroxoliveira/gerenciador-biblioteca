package Livro;

import Estado.EstadoLivro; //pra importar de outro pacote
import Estado.SingletonDisponivel;

public class Livro {
    private int id;
    private String titulo;
    private String editora;
    private String autores;
    private String edicao;
    private int anoDePublicacao;
    private EstadoLivro estadoLivro; //estado do livro usado no singleton

    public Livro(EstadoLivro estadoInicial) {
        this.estadoLivro = estadoInicial;
    }

    public Livro(int id, String titulo, String editora, String autores, String edicao, int anoDePublicacao) {
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
    public void mudarEstado(EstadoLivro estadoLivro) {
        this.estadoLivro = estadoLivro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
