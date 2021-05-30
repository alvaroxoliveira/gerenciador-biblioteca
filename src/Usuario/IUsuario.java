package Usuario;

import Livro.Livro;
import Observer.Observer;
import Usuario.Estado.IEstadoUsuario;
import Livro.Exemplar;
import java.util.ArrayList;

public interface IUsuario extends Observer {
    /*
     * Método publico de realização de empréstimo pelo usuário.
     * Caso não houver impedimento o usuário aciona o método pegarEmprestado de cada tipo de usuário (Estado).
     * */
    void realizaEmprestimo(Livro livro);

    /*
     * Método público de realização de devolução de um livro pelo usuário
     * Caso usuáio tenha o livro emprestado, o método devolverLivroEmprestado de cada tipo de usuário (estado).
     * */
    void realizaDevolucao(Livro livro);

    /*
     * Método público de realização de reserva por um usuário
     * Caso hajam condições, chama o método de reserva para cada tipo de usuário (estado).
     * */
    void realizaReserva(Livro livro);

    /*
     * Método publico em que está definida a consulta dos dados do usuário.
     * O boolean de interação controla se houve alguma transação feita pelo usuário no sistema:
     * true = sim, false = não.
     * */
    void consultarUsuario();

    /*
     * Método público de consulta específica para um usuário professor da quantidade de notificações que recebeu
     * das notificações de reservas simultâneas ( > 2) do livro.
     * */
    void consultarProfessor();

    /*
     * Método público chamado quando mais de duas reservas simultâneas são feitas.
     * Padrão Observer
     * */
    void avisarReservasSimultaneas();

    /*
     * Método público que define o tipo de usuário
     * */
    void setTipoDeUsuario(IEstadoUsuario estadoUsuario);

    /*
     * Método público que tem como função de adicionar um exemplar do livro na lista de emprestados do usuário quando
     * ocorre um empréstimo.
     * */
    void adicionaNaListaDeEmprestados(Exemplar exemplar);

    /*
     * Método público que tem como função remover um exemplar da lista de empréstimos quando o empréstimo é finalizado.
     * */
    void removeDaListaDeEmprestados(Exemplar exemplar);

    /*
     * Método público que tem como função adicionar um exemplar na lista de reservados quando ocorre uma reserva do livro.
     * */
    void adicionaNaListaDeReservados(Livro livro);

    /*
     * Método público que tem como função remover um livro da lista de reservados quando um livro reservado pelo usuário
     * é emprestado para o mesmo.
     * */
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
