package Usuario;

import Livro.Exemplar;
import Livro.Livro;
import Usuario.Estado.IEstadoUsuario;

import java.util.ArrayList;

public interface IUser {
    //verifica se há uma reserva do mesmo livro pelo usuárip
    boolean verificaSeJaTemOLivroReservado(String codigoDoLivro);

    void realizaEmprestimo(String codigoDoLivro);

    // Realiza Devoluçao
    void realizaDevolucao(String codigoDoLivro);

    // Faz a reserva de um exemplar
    void realizaReserva(String codigoDoLivro);

    //método para consultar o usuário
    void consultarUsuario();

    //Método para consultar professor
    void consultarProfessor();

    // Avisa ao usuario quando mais de duas reservas simultaneas foram feitas
    void avisarReservasSimultaneas();

    // Método de definição de tipo de usuário
    void setTipoDeUsuario(IEstadoUsuario estadoUsuario);

    // Adiciona um livro na lista de emprestimos
    void adicionaNaListaDeEmprestados(Exemplar exemplar);

    // Remove o objeto exemplar da lista de exemplares emprestados
    void removeDaListaDeEmprestados(Exemplar exemplar);

    void adicionaNaListaDeReservados(Livro livro);

    void removeDaListaDeReservados(Livro livro);

    String getIdentificador();

    void setIdentificador(String identificador);

    String getNome();

    void setNome(String nome);

    boolean isDevedor();

    void setDevedor(boolean devedor);

    IEstadoUsuario getEstadoUsuario();

    void setEstadoUsuario(IEstadoUsuario estadoUsuario);

    int getQuantidadeDeNotificacoes();

    void setQuantidadeDeNotificacoes(int quantidadeDeNotificacoes);

    ArrayList<Exemplar> getListaDeLivrosEmprestados();

    void setListaDeLivrosEmprestados(ArrayList<Exemplar> listaDeLivrosEmprestados);

    ArrayList<Livro> getListaDeReservados();

    void setListaDeReservados(ArrayList<Livro> listaDeReservados);
}
