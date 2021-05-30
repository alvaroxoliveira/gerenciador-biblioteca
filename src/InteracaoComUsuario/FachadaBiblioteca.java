package InteracaoComUsuario;

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
            MensagensFachadaBiblioteca.mensagemErroNaquantidadeDeParametros();
            return false;
        }
        return true;
    }

    //verifica se foi passado apenas 1 parametro (codigo da consulta)
    private boolean verificarQuantidadeDeParametrosConsulta(ArrayList<String> parametroParaExecutar) {
        if(parametroParaExecutar.size() != 1) {
            MensagensFachadaBiblioteca.mensagemErroNaquantidadeDeParametros();
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

    //realiza reserva de um exemplar
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

    public void realizarConsultaLivro(ArrayList<String> parametroParaExecutar) { //caio
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

    // Adiciona um Usuário (que é um observer) numa lista de observadores de um determinado livro
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
                livro.adicionarObserver(usuario, usuario.getNome());
            } else {
                MensagensBuscaUsuario.mensagemUsuarioNaoEncontrado();
            }
            MensagensBuscaLivro.mensagemLivroNaoEncontrado();
        }
    }

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

    public void realizarConsultaProfessor(ArrayList<String> parametroParaExecutar){
        if(!verificarQuantidadeDeParametrosConsulta(parametroParaExecutar)) {
            return;
        }
        String identificadorUsuario = parametroParaExecutar.get(0);
        int indexDoProfessor = BuscaUsuario.buscaIndexDoUsuario(identificadorUsuario);

        if(indexDoProfessor != -1) {
            Usuario professor = CarregaUsuarios.getUsuariosDoSistema().get(indexDoProfessor);
            MensagensFachadaBiblioteca.mensagemConsultaDadosProfessor();
            professor.consultarProfessor();
        } else {
            MensagensBuscaUsuario.mensagemUsuarioNaoEncontrado();
        }
    }
}
