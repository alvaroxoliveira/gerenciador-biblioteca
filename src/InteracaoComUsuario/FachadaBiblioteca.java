package InteracaoComUsuario;

/*
* Classe fachada do sistema que possui os métodos que realizam as ações específicas para cada comando dado
* pelo usuário através da Classe InterfaceUsuário.
* É um Singleton, Padrão de Projeto aprendido em aula.
* */

import Buscas.BuscaLivro;
import Buscas.BuscaUsuario;
import Livro.CarregaLivros;
import Livro.Livro;
import MensagensConsole.MensagensBuscaLivro;
import MensagensConsole.MensagensBuscaUsuario;
import MensagensConsole.MensagensFachadaBiblioteca;
import Usuario.CarregaUsuarios;
import Usuario.Usuario;

import java.util.ArrayList;

public class FachadaBiblioteca {

    public static FachadaBiblioteca instance;

    private FachadaBiblioteca() {}

    public static FachadaBiblioteca getInstance() {
        if(instance == null) {
            synchronized(FachadaBiblioteca.class) {
                if(instance == null) {
                    instance = new FachadaBiblioteca();
                }
            }
        }
        return instance;
    }

    /*
    * Método privado para verificar a quantidade de parâmtros para os comandos de Empréstimo, Devolução e
    * Observação. A quantidade de parametros passados devem ser iguais a 2.
    * */
    private boolean verificarQuantidadeDeParametros(ArrayList<String> parametroParaExecutar) {
        if(parametroParaExecutar.size() != 2) {
            MensagensFachadaBiblioteca.mensagemErroNaquantidadeDeParametros();
            return false;
        }
        return true;
    }

    /*
    * Método privado para a verificação da quantiadade de parâmetros para os comandos de consulta.
    * A quantidade de parametros deve ser igual a 1.
    * */
    private boolean verificarQuantidadeDeParametrosConsulta(ArrayList<String> parametroParaExecutar) {
        if(parametroParaExecutar.size() != 1) {
            MensagensFachadaBiblioteca.mensagemErroNaquantidadeDeParametros();
            return false;
        }
        return true;
    }

    /*
    * Método de realização de Emprestimo de um Exemplar de um Livro.
    * Busca um Usuário e um Livro do Sistema para que o usuário possa pegar um exemplar emprestado, caso
    * esteja com Estado Disponível. Senão retorna um mensagem de Erro.
    * */
    public void realizarEmprestimo(ArrayList<String> parametroParaExecutar) {
        if(!verificarQuantidadeDeParametros(parametroParaExecutar)) {
            return;
        }
        String identificadorUsuario = parametroParaExecutar.get(0);
        String identificadorLivro = parametroParaExecutar.get(1);

        int indexDoLivro = BuscaLivro.buscaIndexDoLivro(identificadorLivro);
        int indexDoUsuario = BuscaUsuario.buscaIndexDoUsuario(identificadorUsuario);

        if(indexDoLivro != -1) {
            Livro livro = CarregaLivros.getLivrosDoSistema().get(indexDoLivro);
            if(indexDoUsuario != -1) {
                Usuario usuario = CarregaUsuarios.getUsuariosDoSistema().get(indexDoUsuario);
                MensagensFachadaBiblioteca.mensagemOperacaoEmprestimo();
                usuario.realizaEmprestimo(livro);
            } else {
                MensagensBuscaUsuario.mensagemUsuarioNaoEncontrado();
            }
        } else {
            MensagensBuscaLivro.mensagemLivroNaoEncontrado();
        }
    }

    /*
     * Método de realização de Devolução de um Exemplar de Livro.
     * Busca um Usuário e um Livro do Sistema para que o usuário possa devolver um exemplar emprestado,
     *  caso esteja com Estado Emprestado. Senão retorna um mensagem de Erro.
     * */
    public void realizarDevolucao(ArrayList<String> parametroParaExecutar) {
        if(!verificarQuantidadeDeParametros(parametroParaExecutar)) {
            return;
        }
        String identificadorUsuario = parametroParaExecutar.get(0);
        String identificadorLivro = parametroParaExecutar.get(1);

        int indexDoLivro = BuscaLivro.buscaIndexDoLivro(identificadorLivro);
        int indexDoUsuario = BuscaUsuario.buscaIndexDoUsuario(identificadorUsuario);

        if(indexDoLivro != -1) {
            Livro livro = CarregaLivros.getLivrosDoSistema().get(indexDoLivro);
            if(indexDoUsuario != -1) {
                Usuario usuario = CarregaUsuarios.getUsuariosDoSistema().get(indexDoUsuario);
                MensagensFachadaBiblioteca.mensagemOperacaoDevolucao();
                usuario.realizaDevolucao(livro);
            } else {
                MensagensBuscaUsuario.mensagemUsuarioNaoEncontrado();
            }
        } else {
            MensagensBuscaLivro.mensagemLivroNaoEncontrado();
        }
    }

    /*
     * Método de realização de Reserva de Exemplar de um Livro.
     * Busca um Usuário e um Livro do Sistema para que o usuário possa reservar um exemplar caso seja possível.
     * Senão retorna um mensagem de Erro.
     * */
    public void realizarReserva(ArrayList<String> parametroParaExecutar) { //caio
        if(!verificarQuantidadeDeParametros(parametroParaExecutar)) {
            return;
        }
        String identificadorUsuario = parametroParaExecutar.get(0);
        String identificadorLivro = parametroParaExecutar.get(1);
        int indexDoLivro = BuscaLivro.buscaIndexDoLivro(identificadorLivro);
        int indexDoUsuario = BuscaUsuario.buscaIndexDoUsuario(identificadorUsuario);
        if(indexDoLivro != -1) {
            Livro livro = CarregaLivros.getLivrosDoSistema().get(indexDoLivro);
            if(indexDoUsuario != -1) {
                Usuario usuario = CarregaUsuarios.getUsuariosDoSistema().get(indexDoUsuario);
                MensagensFachadaBiblioteca.mensagemOperacaoReserva();
                usuario.realizaReserva(livro);
            } else {
                MensagensBuscaUsuario.mensagemUsuarioNaoEncontrado();
            }
        } else {
            MensagensBuscaLivro.mensagemLivroNaoEncontrado();
        }
    }

    /*
    * Método que torna um Usuário Observador de um livro. Esse usuário irá receber notificações caso
    * houver reserva de mais que 2 Exemplares daquele livro. É feito por Usuários Professores.
    * Tem a Estratégia de usar o Padrão de Projeto Observer aprendido em aula.
    * */
    public void realizarObservacao(ArrayList<String> parametroParaExecutar) {
        if(!verificarQuantidadeDeParametros(parametroParaExecutar)) {
            return;
        }
        String identificadorUsuario = parametroParaExecutar.get(0);
        String identificadorLivro = parametroParaExecutar.get(1);
        int indexDoLivro = BuscaLivro.buscaIndexDoLivro(identificadorLivro);
        int indexDoUsuario = BuscaUsuario.buscaIndexDoUsuario(identificadorUsuario);
        if(indexDoLivro != -1) {
            Livro livro = CarregaLivros.getLivrosDoSistema().get(indexDoLivro);
            if(indexDoUsuario != -1) {
                Usuario usuario = CarregaUsuarios.getUsuariosDoSistema().get(indexDoUsuario);
                usuario.getEstadoUsuario().adicionarObserver(livro, usuario, usuario);
            } else {
                MensagensBuscaUsuario.mensagemUsuarioNaoEncontrado();
            }
        } else {
            MensagensBuscaLivro.mensagemLivroNaoEncontrado();
        }
    }

    /*
    * Método que realiza a consulta de um livro.
    * Imprime os dados do livro guardados nas classes de Transação.
    * Dados esses de Reservas e Empréstimos.
    * */
    public void realizarConsultaLivro(ArrayList<String> parametroParaExecutar) {
        if(!verificarQuantidadeDeParametrosConsulta(parametroParaExecutar)) {
            return;
        }
        String identificadorLivro = parametroParaExecutar.get(0);
        int indexDoLivro = BuscaLivro.buscaIndexDoLivro(identificadorLivro);
        if(indexDoLivro != -1) {
            Livro livro = CarregaLivros.getLivrosDoSistema().get(indexDoLivro);
            MensagensFachadaBiblioteca.mensagemConsultaDadosLivro();
            livro.consultarLivro();
        } else {
            MensagensBuscaLivro.mensagemLivroNaoEncontrado();
        }
    }

    /*
    * Método que realiza a consulta dos dados de um Usuário.
    * Imprime os dados das Transações feitas pelo usuário específicado pelo comando digitado no console.
    * Dados esses dos Empréstimos feitos (Ativos e Finalizados) e as reservas.
    * */
    public void realizarConsultaUsuario(ArrayList<String> parametroParaExecutar){
        if(!verificarQuantidadeDeParametrosConsulta(parametroParaExecutar)) {
            return;
        }
        String identificadorUsuario = parametroParaExecutar.get(0);
        int indexDoUsuario = BuscaUsuario.buscaIndexDoUsuario(identificadorUsuario);
        if(indexDoUsuario != -1) {
            Usuario usuario = CarregaUsuarios.getUsuariosDoSistema().get(indexDoUsuario);
            MensagensFachadaBiblioteca.mensagemConsultaDadosUsuario();
            usuario.consultarUsuario();
        } else {
            MensagensBuscaUsuario.mensagemUsuarioNaoEncontrado();
        }
    }

    /*
    * Realização de consulta de notificações de mais de 2 reservas simultâneas feitas por usuários
    * da biblioteca.
    * Imprime a quantidade de notificações.
    * */
    public void realizarConsultaObserver(ArrayList<String> parametroParaExecutar){
        if(!verificarQuantidadeDeParametrosConsulta(parametroParaExecutar)) {
            return;
        }
        String identificadorUsuario = parametroParaExecutar.get(0);
        int indexDoProfessor = BuscaUsuario.buscaIndexDoUsuario(identificadorUsuario);

        if(indexDoProfessor != -1) {
            Usuario usuario = CarregaUsuarios.getUsuariosDoSistema().get(indexDoProfessor);
            MensagensFachadaBiblioteca.mensagemConsultaDadosProfessor();
            usuario.getEstadoUsuario().consultarObserver(usuario);
        } else {
            MensagensBuscaUsuario.mensagemUsuarioNaoEncontrado();
        }
    }
}
