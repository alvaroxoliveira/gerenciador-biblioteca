package Livro;

import Observer.Observer;
import Observer.Subject;
import Usuario.User;

import java.util.ArrayList;

public interface ILivro extends Subject {
    void adicionaExemplar(Exemplar exemplar);

    // Retorna o exemplar da lista de exemplares do livro que estiver disponível
    Exemplar obterExemplarDisponivel();

    void pegarLivroEmprestado(User user);

    void devolverLivroEmprestado(User user);

    void reservarLivro(User user);

    void consultarLivro();

    // Additional um observer a uma lista de observadores que no caso são os usuários com status de Professores
    void adicionarObserver(Observer observer, String nomeUser);

    // Notifica uma lista de observadores
    void notificarObserver();

    //método para retonar a quantidade de exemplares
    int getQuantidadeExemplares();

    ArrayList<Exemplar> getExemplares();

    void setExemplares(ArrayList<Exemplar> exemplares);

    ArrayList<Observer> getObservadores();

    String getId();

    void setId(String id);

    String getTitulo();

    void setTitulo(String titulo);

    String getEditora();

    void setEditora(String editora);

    String getAutores();

    void setAutores(String autores);

    String getEdicao();

    void setEdicao(String edicao);

    int getAnoDePublicacao();

    void setAnoDePublicacao(int anoDePublicacao);
}
