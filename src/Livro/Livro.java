package Livro;

/*
* Classe de Definição do Livro.
* */

import MensagensConsole.ImprimeDadosLivro;
import MensagensConsole.MensagensLivro;
import Observer.Observer;
import Observer.Subject;
import Transacoes.TransacaoReserva;
import Usuario.Usuario;

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

    /*
    * Método que adiciona um exemplar na lista de exemplares.
    * */
    public void adicionaExemplar(Exemplar exemplar) {
        this.exemplares.add(exemplar);
    }

    /*
    * Método privado que retorna o exemplar que estiver disponível.
    * */
    private Exemplar obterExemplarDisponivel() {
        for(Exemplar exemplar: this.exemplares) {
            if(exemplar.getEstadoExemplar().imprimirEstado().equals("EstadoDisponivel.")){
                return exemplar;
            }
        }
        return null;
    }

    /*
    * Método público que tem como função obter um exemplar disponível e permtir o empréstimo.
    * Caso possível adiciona o empréstimo na lista de Transações no sistema.
    * Caso não haja disponibilidade retorna um erro.
    * */
    public void pegarLivroEmprestado(Usuario usuario){
        if(TransacaoReserva.quantidadeReserva(this) >= this.getQuantidadeExemplares()){
            if(!usuario.verificaSeJaTemOLivroReservado(this)){ //não tem reserva
                MensagensLivro.mensagemPossuiMaisReservasQueExemplares(this.getTitulo(), usuario.getNome());
            } else{
                this.obterExemplarDisponivel().getEstadoExemplar().emprestarLivro(this.obterExemplarDisponivel(), usuario);
            }
        } else {
            if(obterExemplarDisponivel() != null) {
                this.obterExemplarDisponivel().getEstadoExemplar().emprestarLivro(this.obterExemplarDisponivel(), usuario);
            } else {
                MensagensLivro.mensagemNaoHaExemplaresDisponiveis();
            }
        }
    }

    /*
    * Método públic que permite a devolução de um Exemplar do livro que está emprestado.
    * Chama o estado para verificar se é possível a devolução do livro e as especificações.
    * */
    public void devolverLivroEmprestado(Usuario usuario) {
        for(Exemplar exemplarDoLivro: this.exemplares) {
            for (Exemplar exemplarEmprestado: usuario.getListaDeLivrosEmprestados()) {
                if(exemplarDoLivro.getCodigoExemplar().equals(exemplarEmprestado.getCodigoExemplar())) {
                    exemplarDoLivro.getEstadoExemplar().devolverLivro(exemplarDoLivro, usuario);
                    return;
                }
            }
        }
    }

    /*
    * Método público de reserva de um Exemplar do livro.
    * Caso haja mais de 2 reservas em curso notifica o Observer.
    * */
    public void reservarLivro(Usuario usuario) {
        TransacaoReserva.adicionarReserva(this, usuario);
        usuario.getListaDeReservados().add(this);
        MensagensLivro.mensagemReservaDoLivroFeitaPeloUsuario(this.getTitulo(), usuario.getNome());
        if (TransacaoReserva.quantidadeReserva(this) >= 3) { //se passou de 2 reservas, notifica o professor
            this.notificarObserver();
        }
    }

    /*
    * Método público de consulta do livro.
    * Busca nas Transações de Reserva e de Empréstimo e imprime os dados.
    * */
    public void consultarLivro() {
        ImprimeDadosLivro.imprimeCabecalho(this);
        if(TransacaoReserva.quantidadeReserva(this) > 0){
            //chama o método para imprimir os usuários e os exemplares reservados por esses
            TransacaoReserva.imprimirUsuariosReserva(this);
        }
        ImprimeDadosLivro.imprimeInformacoesDosExemplaresEmprestados(this.exemplares);
    }

    /*
    * Método público de adição de um Observador do livro.
    * O Observador é um Usuário do Tipo Professor.
    * */
    public void adicionarObserver(Observer observer, String nomeUser) {
        this.observadores.add(observer);
        MensagensLivro.mensagemAdicaoDeLivroNaListaDeObservador(this.getTitulo(), nomeUser);
    }

    /*
    * Método público de notificação dos observadores.
    * Notifica as reservas simultâneas (mais de 2) do livro para os observadores do livro.
    * */
    public void notificarObserver() {
        for(Observer observer: this.observadores) {
            observer.avisarReservasSimultaneas();
        }
    }

    /*
    * Método público que retorna a quantidade de exemplares do livro.
    * */
    public int getQuantidadeExemplares(){
        return this.exemplares.size();
    }

    /*
    * Getters/Setters.
    * */

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