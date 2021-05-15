package Usuario;

import Livro.Livro;

import java.util.ArrayList;

public interface IUsuario {
    public void pegaEmprestado(Livro livro);
    public void devolveLivro(int i);
    public int getIdentificador();
    public void setIdentificador(int identificador);
    public String getNome();
    public void setNome(String nome);
    public ArrayList<Livro> getListaDeLivrosEmprestados();
    public void setListaDeLivrosEmprestados(ArrayList<Livro> listaDeLivrosEmprestimo);
    public void emprestimo();
    public void devolucao();
    public void reserva();
}
