package Comando;

import Livro.CarregaLivros;
import Livro.Exemplar;
import Livro.Livro;
import Usuario.CarregaUsuarios;
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

        String identificadorUsuario = parametroParaExecutar.get(0);
        String identificadorLivro = parametroParaExecutar.get(1);


        //testa se o id é compativel com o de algum livro no sistema
        if(BuscaLivro.testeLivro(identificadorLivro)){
            //testa se o id é compativel com o de algum usuario no sistema
            if(BuscaUsuario.testeUsuario(identificadorUsuario)){
                System.out.println("Operação de Empréstimo.");
                BuscaUsuario.getUsuario(identificadorUsuario).realizaEmprestimo(identificadorLivro);
                return;
            }
            //System.out.println("Usuario não encontrado.");
            return;
        }
        //System.out.println("Livro não encontrado.");
    }

    public void realizarDevolucao(ArrayList<String> parametroParaExecutar) {
        if(!verificarQuantidadeDeParametros(parametroParaExecutar)) {
            return;
        }

        String identificadorUsuario = parametroParaExecutar.get(0);
        String identificadorLivro = parametroParaExecutar.get(1);

        //testa se o id é compativel com o de algum livro no sistema
        if(BuscaLivro.testeLivro(identificadorLivro)){
            //testa se o id é compativel com o de algum usuario no sistema
            if(BuscaUsuario.testeUsuario(identificadorUsuario)){
                System.out.println("Realizando devolução");
                BuscaUsuario.getUsuario(identificadorUsuario).realizaDevolucao(identificadorLivro);
                return;
            }
            //System.out.println("Usuario não encontrado.");
            return;
        }
        //System.out.println("Livro não encontrado.");
    }

    //realiza reserva de um exemplar
    public void realizarReserva(ArrayList<String> parametroParaExecutar) { //caio
        //verifica se foi passado a quantidade certa de parametros
        if(!verificarQuantidadeDeParametros(parametroParaExecutar)) {
            return;
        }

        String identificadorUsuario = parametroParaExecutar.get(0);
        String identificadorLivro = parametroParaExecutar.get(1);

        //testa se o id é compativel com o de algum livro no sistema
        if(BuscaLivro.testeLivro(identificadorLivro)){
            //testa se o id é compativel com o de algum usuario no sistema
            if(BuscaUsuario.testeUsuario(identificadorUsuario)){
                System.out.println("Realizando Reserva.");
                //chama o método de realizar reserva no usuário passando o id do livro
                BuscaUsuario.getUsuario(identificadorUsuario).realizaReserva(identificadorLivro);
                return;
            }
            //System.out.println("Usuario não encontrado.");
            return;
        }
        //System.out.println("Livro não encontrado.");
    }

    public void realizarConsultaLivro(ArrayList<String> parametroParaExecutar) { //caio
        if(!verificarQuantidadeDeParametrosConsulta(parametroParaExecutar)) {
            return;
        }

        String identificadorLivro = parametroParaExecutar.get(0);

        //Testa se existe o livro no sistema, se tiver faz a consulta
        if(BuscaLivro.testeLivro(identificadorLivro)){
            System.out.println("Consultando dados do livro: ");
            BuscaLivro.getLivro(identificadorLivro).consultarLivro();
            return;
        }
    }

    // Adiciona um Usuário (que é um observer) numa lista de observadores de um determinado livro
    public void realizarObservacao(ArrayList<String> parametroParaExecutar) {
        System.out.println("Cadastrando professor como observador do livro: ");
        String identificadorUsuario = parametroParaExecutar.get(0);
        String identificadorLivro = parametroParaExecutar.get(1);

        BuscaLivro.getLivro(identificadorLivro).adicionarObserver(BuscaUsuario.getUsuario(identificadorUsuario));
    }

    public void realizarConsultaUsuario(ArrayList<String> parametroParaExecutar){
        if(!verificarQuantidadeDeParametrosConsulta(parametroParaExecutar)) {
            return;
        }

        String identificadorUsuario = parametroParaExecutar.get(0);

        //Testa se existe o usuario no sistema, se tiver faz a consulta
        if(BuscaUsuario.testeUsuario(identificadorUsuario)){
            System.out.println("Consultando dados do usuário: ");
            BuscaUsuario.getUsuario(identificadorUsuario).consultarUsuario();
            return;
        }
    }

    public void realizarConsultaProfessor(ArrayList<String> parametroParaExecutar){
        System.out.println("Quantidade de vezes que o professor foi notificado: ");
    }
}
