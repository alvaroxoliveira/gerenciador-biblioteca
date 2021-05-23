package Usuario;

import Livro.Exemplar;
import Transacoes.Transacao;
import Observer.Observer;
import Usuario.Estado.IEstadoUsuario;
import java.util.ArrayList;

public class User implements IUsuario, Observer {
    private String identificador;
    private String nome;
    private boolean isDevedor;
    private IEstadoUsuario estadoUsuario;
    private int quantidadeDeNotificacoes;

    // Lista de livros que o usuário está no momento
    private ArrayList<Exemplar> listaDeLivrosEmprestados;
    private ArrayList<Exemplar> listaDeReservados;

    public User(String identificador, String nome) {
        this.identificador = identificador;
        this.nome = nome;
        this.quantidadeDeNotificacoes = 0;
        this.listaDeLivrosEmprestados = new ArrayList<Exemplar>();
        this.listaDeReservados = new ArrayList<Exemplar>();
        this.isDevedor = false;
    }

    private boolean verificaSeJaTemOLivroEmprestado(String codigoDoLivro) {
        for(Exemplar exemplar: this.listaDeLivrosEmprestados) {
            if(exemplar.getCodigoDoLivro().equals(codigoDoLivro)) {
                return true;
            }
        }
        return false;
    }

    //verifica se há uma reserva do mesmo livro pelo usuárip
    private boolean verificaSeJaTemOLivroReservado(String codigoDoLivro){ //caio
        for(Exemplar exemplar: this.listaDeReservados) {
            if(exemplar.getCodigoDoLivro().equals(codigoDoLivro)) {
                return true;
            }
        }
        return false;
    }

    public void realizaEmprestimo(String codigoDoLivro) {
        if(verificaSeJaTemOLivroEmprestado(codigoDoLivro)) {
            System.out.println("Usuário ja tem um exemplar desse livro emprestado.");
            return;
        } else if(this.isDevedor == true) {
            System.out.println("O usuário é devedor na Biblioteca");
            return;
        } else {
            this.estadoUsuario.pegarLivroEmprestado(codigoDoLivro, this);
            return;
        }
    }

    // Realiza Devoluçao
    public void realizaDevolucao(String codigoDoLivro) {
        if(this.listaDeLivrosEmprestados.size() > 0) {
            this.estadoUsuario.devolverLivroEmprestado(codigoDoLivro, this);
        } else {
            System.out.println("Usuário não têm livros para devolver.");
        }
    }

    //faz a reserva de um exemplar
    public void realizaReserva(String codigoDoLivro) { //caio
        //chama o método para verificar se o usuário já reservou o mesmo livro
        if(verificaSeJaTemOLivroReservado(codigoDoLivro)) {
            System.out.println("Usuário ja tem um exemplar desse livro reservado.");
            return;
        } else if(this.isDevedor == true) { //verifica se o usuário é devedor
            System.out.println("O usuário é devedor na Biblioteca");
            return;
        } else { //caso possa chama o método de reservar livro no estado do usuário (tipo de usu)
            this.estadoUsuario.reservarLivro(codigoDoLivro, this);
            return;
        }
    }

    //método para consultar o usuário
    public void consultarUsuario(){
        boolean interacao = false; //variavel de controle para caso não haja nenhuma transacao
        System.out.println("Nome: " + this.getNome());

        //imprimir os emprestimos ativos
        if(this.listaDeLivrosEmprestados.size() > 0){
            for(Exemplar exemplar: this.listaDeLivrosEmprestados){
                for(Transacao transacao: Transacao.getEmprestimosAtuais()){
                    if(exemplar.equals(transacao.getExemplar())){ //caso tenha algum exemplar emprestado
                        System.out.println("Titulo: " + transacao.getExemplar().getTitulo());
                        System.out.println("Data do empréstimo: " + transacao.getData());
                        System.out.println("Estado: Em curso");
                        System.out.println("Data da devolução: " + transacao.getData().plusDays(this.getEstadoUsuario().diasParaEntrega()));
                        interacao = true;
                    }
                }
            }
        }
        //imprimir os emprestimos finalizados
        if(Transacao.quantidadeEmprestimosFinalizados(this) > 0){ //testa se ja teve finalizado
            Transacao.imprimirEmprestimosFinalizados(this);
            interacao = true;
        }
        //imprimir as reservas
        if(this.listaDeReservados.size() > 0){ //caso haja alguma reserva
            for(Exemplar exemplar: this.listaDeReservados){
                for(Transacao transacao: Transacao.getReservas()){
                    if(exemplar.equals(transacao.getExemplar())){ //para encontrar o exemplar
                        System.out.println("Titulo: " + transacao.getExemplar().getTitulo());
                        System.out.println("Data da reserva: " + transacao.getData()); }
                }
            }
            interacao = true;
        }
        if(!interacao){
            System.out.println("Não há empréstimos ativos, empréstimos finalizados ou reservas.");
        }
    }

    //Método para consultar professor
    public void consultarProfessor(){
        System.out.println("O professor " + this.nome + " foi notificado " + this.quantidadeDeNotificacoes + " vezes.");
    }

    // Avisa ao usuario quando mais de duas reservas simultaneas foram feitas
    @Override
    public void avisarReservasSimultaneas() {
        //System.out.println("Usuario: " + this.getNome() + ". Foram feitas mais de duas reservas simultâneas.");
        this.quantidadeDeNotificacoes++;
    }

    // Método de definição de tipo de usuário
    public void setTipoDeUsuario(IEstadoUsuario estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    // Adiciona um livro na lista de emprestimos
    public void adicionaNaListaDeEmprestados(Exemplar exemplar) {
        this.listaDeLivrosEmprestados.add(exemplar);
    }

    // Remove o objeto exemplar da lista de exemplares emprestados
    public void removeDaListaDeEmprestados(Exemplar exemplar) {
        this.listaDeLivrosEmprestados.remove(exemplar);
    }

    public void adicionaNaListaDeReservados(Exemplar exemplar) {
        this.listaDeReservados.add(exemplar);
    }
    
    public void removeDaListaDeReservados(Exemplar exemplar) {
        this.listaDeReservados.add(exemplar);
    }

    @Override
    public String getIdentificador() {
        return identificador;
    }

    @Override
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isDevedor() {
        return isDevedor;
    }

    public void setDevedor(boolean devedor) {
        isDevedor = devedor;
    }

    public IEstadoUsuario getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(IEstadoUsuario estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public int getQuantidadeDeNotificacoesDuplaReserva() {
        return quantidadeDeNotificacoes;
    }

    public void setQuantidadeDeNotificacoesDuplaReserva(int quantidadeDeNotificacoes) {
        this.quantidadeDeNotificacoes = quantidadeDeNotificacoes;
    }

    @Override
    public ArrayList<Exemplar> getListaDeLivrosEmprestados() {
        return listaDeLivrosEmprestados;
    }

    public void setListaDeLivrosEmprestados(ArrayList<Exemplar> listaDeLivrosEmprestados) {
        this.listaDeLivrosEmprestados = listaDeLivrosEmprestados;
    }


    public ArrayList<Exemplar> getListaDeReservados() {
        return listaDeReservados;
    }

    public void setListaDeReservados(ArrayList<Exemplar> listaDeReservados) {
        this.listaDeReservados = listaDeReservados;
    }
}
