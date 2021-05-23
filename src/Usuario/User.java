package Usuario;

import Comando.BuscaLivro;
import Livro.Exemplar;
import Transacoes.TransacaoEmprestimo;
import Observer.Observer;
import Transacoes.TransacaoReserva;
import Usuario.Estado.IEstadoUsuario;
import Livro.Livro;

import java.util.ArrayList;

public class User implements IUsuario, Observer {
    private String identificador;
    private String nome;
    private boolean isDevedor;
    private IEstadoUsuario estadoUsuario;
    private int quantidadeDeNotificacoes;

    // Lista de livros que o usuário está no momento
    private ArrayList<Exemplar> listaDeLivrosEmprestados;
    private ArrayList<Livro> listaDeReservados;

    public User(String identificador, String nome) {
        this.identificador = identificador;
        this.nome = nome;
        this.quantidadeDeNotificacoes = 0;
        this.listaDeLivrosEmprestados = new ArrayList<Exemplar>();
        this.listaDeReservados = new ArrayList<Livro>();
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
    public boolean verificaSeJaTemOLivroReservado(String codigoDoLivro){ //caio
        for(Livro livro: this.listaDeReservados) {
            if(livro.getId().equals(codigoDoLivro)) {
                return true;
            }
        }
        return false;
    }

    public void realizaEmprestimo(String codigoDoLivro) {
        //testa se existe algum exemplar do livro
        if(BuscaLivro.getLivro(codigoDoLivro).getQuantidadeExemplares() == 0){
            System.out.println("Não existe exemplar do livro " + BuscaLivro.getLivro(codigoDoLivro).getTitulo() + ".");
            return;
        }
        //chama o método para verificar se o usuário já fez emprestimo do mesmo livro
        else if(verificaSeJaTemOLivroEmprestado(codigoDoLivro)) { //perguntar na aula
            System.out.println("Usuário " + this.getNome() + " ja tem um exemplar do livro " + BuscaLivro.getLivro(codigoDoLivro).getTitulo() + " emprestado.");
            return;
        }
        else if(this.isDevedor == true) { //verifica se o usuário é devedor
            System.out.println("O usuário " + this.getNome() + " é devedor na Biblioteca");
            return;
        }
        else { //chama o método do estado do usuario para a reserva do livro
            this.estadoUsuario.pegarLivroEmprestado(codigoDoLivro, this);
            return;
        }
    }

    // Realiza Devoluçao
    public void realizaDevolucao(String codigoDoLivro) {
        if(this.listaDeLivrosEmprestados.size() > 0) {
            this.estadoUsuario.devolverLivroEmprestado(codigoDoLivro, this);
        } else {
            System.out.println("Usuário " + this.getNome() + " não têm livros para devolver.");
        }
    }

    //faz a reserva de um exemplar
    public void realizaReserva(String codigoDoLivro) { //caio
        //chama o método para verificar se o usuário já reservou o mesmo livro
        if(verificaSeJaTemOLivroReservado(codigoDoLivro)) {
            System.out.println("Usuário " + this.getNome() + " ja tem um exemplar do livro " + BuscaLivro.getLivro(codigoDoLivro).getTitulo() + " reservado.");
            return;
        } else if(this.isDevedor == true) { //verifica se o usuário é devedor
            System.out.println("O usuário " + this.getNome() + " é devedor na Biblioteca");
            return;
        } else { //chama o método do estado do usuario para a reserva do livro
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
                for(TransacaoEmprestimo transacaoEmprestimo : TransacaoEmprestimo.getEmprestimosAtuais()){
                    if(exemplar.equals(transacaoEmprestimo.getExemplar())){ //caso tenha algum exemplar emprestado
                        System.out.println("Titulo: " + transacaoEmprestimo.getExemplar().getTitulo());
                        System.out.println("Data do empréstimo: " + transacaoEmprestimo.getData());
                        System.out.println("Estado: Em curso");
                        System.out.println("Data da devolução: " + transacaoEmprestimo.getData().plusDays(this.getEstadoUsuario().diasParaEntrega()));
                        interacao = true;
                    }
                }
            }
        }
        //imprimir os emprestimos finalizados
        if(TransacaoEmprestimo.quantidadeEmprestimosFinalizados(this) > 0){ //testa se ja teve finalizado
            TransacaoEmprestimo.imprimirEmprestimosFinalizados(this);
            interacao = true;
        }
        //imprimir as reservas
        if(this.listaDeReservados.size() > 0){ //caso haja alguma reserva
            System.out.println("Teste" + this.listaDeReservados.size());
            for(Livro livro: this.listaDeReservados){
                for(TransacaoReserva transacaoReserva : TransacaoReserva.getReservas()){
                    if(livro.equals(transacaoReserva.getLivro())){ //para encontrar o exemplar
                        System.out.println("Titulo: " + transacaoReserva.getLivro().getTitulo());
                        System.out.println("Data da reserva: " + transacaoReserva.getData()); }
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

    public void adicionaNaListaDeReservados(Livro livro) {
        this.listaDeReservados.add(livro);
    }
    
    public void removeDaListaDeReservados(Livro livro) {
        this.listaDeReservados.remove(livro);
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


    public ArrayList<Livro> getListaDeReservados() {
        return listaDeReservados;
    }

    public void setListaDeReservados(ArrayList<Livro> listaDeReservados) {
        this.listaDeReservados = listaDeReservados;
    }
}
