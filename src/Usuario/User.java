package Usuario;

import Livro.Livro;
import Livro.Exemplar;
import Observer.Observer;
import Usuario.Estado.IEstadoUsuario;

import java.util.ArrayList;

public class User implements IUsuario, Observer {
    private String identificador;
    private String nome;
    private boolean isDevedor;
    private IEstadoUsuario estadoUsuario;
    private int quantidadeDeNotificacoesDuplaReserva = 0;


    // Lista de livros que o usuário está no momento
    private ArrayList<Exemplar> listaDeLivrosEmprestados;
    private ArrayList<Exemplar> listaDeReservados;

    public User(String identificador, String nome) {
        this.identificador = identificador;
        this.nome = nome;
        this.listaDeLivrosEmprestados = new ArrayList<Exemplar>();
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

    @Override
    public void avisarReservasSimultaneas() {
        System.out.println("Dupla reserva simultânea!");
        this.quantidadeDeNotificacoesDuplaReserva++;
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
        return quantidadeDeNotificacoesDuplaReserva;
    }

    public void setQuantidadeDeNotificacoesDuplaReserva(int quantidadeDeNotificacoesDuplaReserva) {
        this.quantidadeDeNotificacoesDuplaReserva = quantidadeDeNotificacoesDuplaReserva;
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
