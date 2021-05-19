package Comando;

import Livro.Livro;
import Usuario.CarregaUsuarios;
import Livro.CarregaLivros;
import Usuario.User;

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

    public void realizarEmprestimo(ArrayList<String> parametroParaExecutar) {
        if(parametroParaExecutar.size() != 2) {
            System.out.println("Erro na quantidade de parametros");
            return;
        }
        String identificadorUsuario = parametroParaExecutar.get(0);
        String identificadorLivro = parametroParaExecutar.get(1);
        System.out.println("Realizando Emprestimo.");

    }

    public void realizarDevolucao(ArrayList<String> parametroParaExecutar) {
        System.out.println("Realizando devolução");
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

    public void realizarConsultaUsuario(ArrayList<String> parametroParaExecutar){
        System.out.println("Consultando a lista de empréstimo do usuário: ");
    }

    public void realizarConsultaProfessor(ArrayList<String> parametroParaExecutar){
        System.out.println("Quantidade de vezes que o professor foi notificado: ");
    }
}
