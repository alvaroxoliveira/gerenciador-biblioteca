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

    public void realizarEmprestimo(String parametro1, String parametro2) {
        System.out.println("Realizando Emprestimo");
    }

    public void realizarDevolucao(String parametro1, String parametro2) {
        System.out.println("Realizando Devolução");
    }

    public void realizarReserva(String parametro1, String parametro2) {
        System.out.println("Realizando reserva");
    }

    public void realizarConsultaLivro(String parametro1, String parametro2) {
        System.out.println("Consultando dados do livro: ");
    }

    public void realizarObservacao(String parametro1, String parametro2) {
        System.out.println("Observando dados do livro: ");
    }
}
