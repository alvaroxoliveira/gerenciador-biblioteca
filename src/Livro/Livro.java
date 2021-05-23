package Livro;

import Comando.BuscaLivro;
import Livro.Estado.SingletonDisponivel;
import Observer.Observer;
import Observer.Subject;
import Transacoes.TransacaoReserva;
import Usuario.User;
import Transacoes.TransacaoEmprestimo;

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
            /*
            for(TransacaoEmprestimo transacaoEmprestimo: TransacaoEmprestimo.getEmprestimosAtuais()){
                if(transacaoEmprestimo.getExemplar().getCodigoDoLivro().equals(exemplar.getCodigoDoLivro()) && !transacaoEmprestimo.getExemplar().equals(exemplar)){
                    return exemplar;
                }
            }
0             */
            if(exemplar.getEstadoExemplar().imprimirEstado().equals("Disponivel.")){ //testa se esta disponivel
                return exemplar;
            }
        }
        return null;
    }

    public void pegarLivroEmprestado(User user){
        if(TransacaoReserva.quantidadeReserva(this) >= this.getQuantidadeExemplares()){
            //verifica se o usuario tem o livro reservado
            if(!user.verificaSeJaTemOLivroReservado(this.id)){ //não tem reserva
                System.out.println("O livro " + this.getTitulo() + " possui mais reservas do que exemplares e o usuário " + user.getNome() + " não possui reserva.");
            }
            else{//o usuário tem reserva
                //chama o método de emprestar livro no estado disponivel do exemplar
                this.obterExemplarDisponivel().getEstadoExemplar().emprestarLivro(this.obterExemplarDisponivel(), user);
            }
        }
        else{//a quantidade de exemplares é maior que a de reservas e o usuário tem ou não reserva
            this.obterExemplarDisponivel().getEstadoExemplar().emprestarLivro(this.obterExemplarDisponivel(), user);

        }
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

    public void reservarLivro(User user) {
        TransacaoReserva.adicionarReserva(this, user);
        user.getListaDeReservados().add(this);
        System.out.println("O usuário " + user.getNome() + " fez a reserva do livro " + this.getTitulo() + ".");
        if (TransacaoReserva.quantidadeReserva(this) == 3) { //se passou de 2 reservas, notifica o professor
            this.notificarObserver(); //notifica o professor
        }
    }

    public void consultarLivro() {
        System.out.println("Título: " + this.titulo);

        //passa o próprio livro e usa o vetor de reservad os para saber quantos exemplares estão reservados
        System.out.println("Quantidade de reservas: " + TransacaoReserva.quantidadeReserva(this));
        if(TransacaoReserva.quantidadeReserva(this) > 0){
            //chama o método para imprimir os usuários e os exemplares reservados por esses
            TransacaoReserva.imprimirUsuariosReserva(this);
        }

        //imprime cada exemplar e caso esteja emprestado imprime outras informações
        System.out.println("Exemplares: ");
        for(Exemplar exemplar: this.exemplares){
            System.out.println("Código: " + exemplar.getCodigoExemplar());
            //usa o método polimorfico para impimir o estado do livro
            System.out.println("Estado: " + exemplar.getEstadoExemplar().imprimirEstado());
            //commpara o exemplar atual com os exemplares na lista de emprestimos ativos
            for(TransacaoEmprestimo transacaoEmprestimo : TransacaoEmprestimo.getEmprestimosAtuais()){
                //caso o exemplar esteja emprestado, imprime as informações
                if(exemplar.getCodigoExemplar().equals(transacaoEmprestimo.getExemplar().getCodigoExemplar())){
                    System.out.println("Usuario: " + transacaoEmprestimo.getUsuario().getNome());
                    System.out.println("Data de emprestimo: " + transacaoEmprestimo.getData());
                    //soma a data do emprestimo com a quantidade de dias expresso no metodo polimorfico correspondente a cada usuario
                    System.out.println("Data de entrega: " + transacaoEmprestimo.getData().plusDays(transacaoEmprestimo.getUsuario().getEstadoUsuario().diasParaEntrega()));
                }
            }
        }
    }

    // Adiciona um observer a uma lista de observadores que no caso são os usuários com status de Professores
    @Override
    public void adicionarObserver(Observer observer) {
        this.observadores.add(observer);
        System.out.println("O professor adicionou o livro " + this.getTitulo() + "na sua lista de observados.");
    }

    // Notifica uma lista de observadores
    @Override
    public void notificarObserver() {
        for(Observer observer: this.observadores) {
            observer.avisarReservasSimultaneas();
        }
    }

    //método para retonar a quantidade de exemplares
    public int getQuantidadeExemplares(){
        return this.exemplares.size();
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