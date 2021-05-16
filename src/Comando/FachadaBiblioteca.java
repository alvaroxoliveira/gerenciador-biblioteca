package Comando;

import java.util.ArrayList;

public class FachadaBiblioteca {

    public static FachadaBiblioteca instance; //cada livro só vai ter uma instancia de cada estado

    private FachadaBiblioteca() {}

    public static FachadaBiblioteca getInstance() { //se não existir instancia, cria uma
        if(instance == null) {
            synchronized(FachadaBiblioteca.class) {
                if(instance == null) {
                    instance = new FachadaBiblioteca();
                }
            }
        }
        return instance;
    }

    public void realizarEmprestimo(ArrayList<String> parametroParaExecutar) {
        System.out.println("Realizando Emprestimo");
    }

    public void realizarDevolucao(ArrayList<String> parametroParaExecutar) {
        System.out.println("Realizando Devolução");
    }

    public void realizarReserva(ArrayList<String> parametroParaExecutar) {
        System.out.println("Realizando reserva");
    }

    public void realizarConsultaLivro(ArrayList<String> parametroParaExecutar) {
        System.out.println("Consultando dados do livro: ");
    }

    public void realizarObservacao(ArrayList<String> parametroParaExecutar) {
        System.out.println("Observando dados do livro: ");
    }
}
