package Comando;

import java.util.ArrayList;

//Classe fachada que é um Singleton (motivo da instancia) e possui os métodos para realizar as ações
//Precisa implementar o que cada ação faz!
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

    private boolean verificarQuantidadeDeParametros(ArrayList<String> parametroParaExecutar) {
        if(parametroParaExecutar.size() != 2) {
            System.out.println(parametroParaExecutar.size());
            System.out.println("Erro na quantidade de parametros");
            return false;
        }
        return true;
    }

    public void realizarEmprestimo(ArrayList<String> parametroParaExecutar) {
        if(!verificarQuantidadeDeParametros(parametroParaExecutar)) {
            return;
        }
        System.out.println("Operação de Empréstimo.");

        String identificadorUsuario = parametroParaExecutar.get(0);
        String identificadorLivro = parametroParaExecutar.get(1);
        // FAZER O USUÁRIO PEGAR EMPRESTADO ELE MESMO
        BuscaUsuario.getUsuario(identificadorUsuario).realizaEmprestimo(identificadorLivro);
    }

    public void realizarDevolucao(ArrayList<String> parametroParaExecutar) {
        if(!verificarQuantidadeDeParametros(parametroParaExecutar)) {
            return;
        }
        System.out.println("Realizando devolução");

        String identificadorUsuario = parametroParaExecutar.get(0);
        String identificadorLivro = parametroParaExecutar.get(1);

        BuscaUsuario.getUsuario(identificadorUsuario).realizaDevolucao(identificadorLivro);

    }

    public void realizarReserva(ArrayList<String> parametroParaExecutar) {
        if(verificarQuantidadeDeParametros(parametroParaExecutar)) {
            return;
        }
        System.out.println("Realizando reserva");
    }

    public void realizarConsultaLivro(ArrayList<String> parametroParaExecutar) {
        System.out.println("Consultando dados do livro: ");
    }

    public void realizarObservacao(ArrayList<String> parametroParaExecutar) {
        System.out.println("Observando dados do livro: ");
    }

    public void realizarConsultaUsuario(ArrayList<String> parametroParaExecutar){
        System.out.println("Consultando a lista de empréstimo do usuário: ");
    }

    public void realizarConsultaProfessor(ArrayList<String> parametroParaExecutar){
        System.out.println("Quantidade de vezes que o professor foi notificado: ");
    }
}
