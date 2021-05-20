package Comando;

import Livro.CarregaLivros;
import Livro.Exemplar;
import Livro.Livro;

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

    //verifica se foi passado apenas 1 parametro (codigo da consulta)
    private boolean verificarQuantidadeDeParametrosConsulta(ArrayList<String> parametroParaExecutar) {
        if(parametroParaExecutar.size() != 1) {
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

    //realiza reserva de um exemplar
    public void realizarReserva(ArrayList<String> parametroParaExecutar) { //caio
        //verifica se foi passado a quantidade certa de parametros
        if(!verificarQuantidadeDeParametros(parametroParaExecutar)) {
            return;
        }
        System.out.println("Operação de Reserva.");

        String identificadorUsuario = parametroParaExecutar.get(0);
        String identificadorLivro = parametroParaExecutar.get(1);

        //chama o método de realizar reserva no usuário passando o id do livro
        BuscaUsuario.getUsuario(identificadorUsuario).realizaReserva(identificadorLivro);
    }

    public void realizarConsultaLivro(ArrayList<String> parametroParaExecutar) { //caio
        if(!verificarQuantidadeDeParametrosConsulta(parametroParaExecutar)) {
            return;
        }
        System.out.println("Consultando dados do livro: ");

        String identificadorLivro = parametroParaExecutar.get(0);

        //Considerar se deve refatorar - Procurar o livro correspondente
        for(Livro livro: CarregaLivros.getLivrosDoSistema()) {
            if(livro.getId().equals(identificadorLivro)){
                livro.consultarLivro();
                return;
            }
        }
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
