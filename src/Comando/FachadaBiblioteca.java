package Comando;

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

    public void realizarEmprestimo() {
        System.out.println("Realizando Emprestimo");


    }

    public void realizarDevolucao() {
        System.out.println("Realizando Devolução");

    }

    public void realizarReserva() {
        System.out.println("Realizando reservao");
    }

    public void realizarConsultaLivro() {
        System.out.println("Consultando dados do livro: ");
    }

    public void realizarObservacao() {
        System.out.println("Observando dados do livro: ");
    }
}
