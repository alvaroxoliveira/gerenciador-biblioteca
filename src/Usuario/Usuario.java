package Usuario;

/*
* Classe de definição de Usuário
* */

import Livro.Exemplar;
import Livro.Livro;
import MensagensConsole.ImprimirDadosOperacoes;
import MensagensConsole.MensagensUser;
import Transacoes.TransacaoEmprestimo;
import Transacoes.TransacaoReserva;
import Usuario.Estado.IEstadoUsuario;

import java.util.ArrayList;

public class Usuario implements IUsuario {
    private String identificador;
    private String nome;
    private boolean isDevedor;
    private IEstadoUsuario estadoUsuario;
    private int quantidadeDeNotificacoes;

    /*
    * Listas que contém os livros emprestados e os livros reservados (respectivamente) pelo usuário em curso.
    * */
    private ArrayList<Exemplar> listaDeLivrosEmprestados;
    private ArrayList<Livro> listaDeReservados;

    /*
    * Construtor da classe. Inicia todos os usuários, como não devedores.
    * */
    public Usuario(String identificador, String nome) {
        this.identificador = identificador;
        this.nome = nome;
        this.quantidadeDeNotificacoes = 0;
        this.listaDeLivrosEmprestados = new ArrayList<Exemplar>();
        this.listaDeReservados = new ArrayList<Livro>();
        this.isDevedor = false;
    }

    /*
    * Método privado que retorna verdadeiro se o Usuário tem o livro emprestado
    * e falso caso o contrário.
    * */
    private boolean verificaSeJaTemOLivroEmprestado(Livro livro) {
        for(Exemplar exemplar: this.listaDeLivrosEmprestados) {
            if(exemplar.getLivro().getId().equals(livro.getId())) {
                return true;
            }
        }
        return false;
    }

    /*
    * Método privado que retorna verdadeiro se o usuário tem o livro reservado
    * e falso caso contrário.
    * */
    public boolean verificaSeJaTemOLivroReservado(Livro livro) {
        for(Livro livroReservado: this.listaDeReservados) {
            if(livroReservado.getId().equals(livro.getId())) {
                return true;
            }
        }
        return false;
    }

    /*
    * Método publico de realização de empréstimo pelo usuário.
    * Caso não houver impedimento o usuário aciona o método pegarEmprestado de cada tipo de usuário (Estado).
    * */
    @Override
    public void realizaEmprestimo(Livro livro) {
        if(livro.getQuantidadeExemplares() == 0){
            MensagensUser.mensagemDeNaoExistenciaDeExemplar(livro);
        } else if(verificaSeJaTemOLivroEmprestado(livro)) {
            MensagensUser.mensagemOperacaoJaFeitaComLivro(livro, this, "Emprestado");
        } else if(this.isDevedor) {
            MensagensUser.mensagemDeInadimplencia(this);
        } else {
            this.estadoUsuario.pegarLivroEmprestado(livro, this);
        }
    }


    /*
    * Método público de realização de devolução de um livro pelo usuário
    * Caso usuáio tenha o livro emprestado, o método devolverLivroEmprestado de cada tipo de usuário (estado).
    * */
    @Override
    public void realizaDevolucao(Livro livro) {
        if(this.listaDeLivrosEmprestados.size() == 0) {
            MensagensUser.mensagemNaoHaLivroParaDevolver(this);
        } else if(!this.verificaSeJaTemOLivroEmprestado(livro)) {
            MensagensUser.mensagemLivroNaoEstaNaListaDeEmprestados(livro, this);
        } else {
            this.estadoUsuario.devolverLivroEmprestado(livro, this);
        }
    }

    /*
    * Método público de realização de reserva por um usuário
    * Caso hajam condições, chama o método de reserva para cada tipo de usuário (estado).
    * */
    @Override
    public void realizaReserva(Livro livro) {
        if(verificaSeJaTemOLivroReservado(livro)) {
            MensagensUser.mensagemOperacaoJaFeitaComLivro(livro, this," reservado.");
        } else if(this.isDevedor) {
            MensagensUser.mensagemDeInadimplencia(this);
        } else if(verificaSeJaTemOLivroEmprestado(livro)){
            MensagensUser.mensagemOperacaoJaFeitaComLivro(livro, this, " emprestado.");
        } else {
            this.estadoUsuario.reservarLivro(livro, this);
        }
    }

    /*
    * Método privado que auxilia na consultarUsuario e serve para imprimir dados de Emprestimos Ativos (Em cusro).
    * */
    private boolean isImprimirDadosDeEmprestimosAtivos(boolean interacao) {
        String estadoEmCurso = "Em curso";
        for(Exemplar exemplar: this.listaDeLivrosEmprestados){
            for(TransacaoEmprestimo transacaoEmprestimo : TransacaoEmprestimo.getEmprestimosAtuais()){
                if(exemplar.equals(transacaoEmprestimo.getExemplar())){ //caso tenha algum exemplar emprestado
                    ImprimirDadosOperacoes.imprimirDadosEmprestimos(transacaoEmprestimo);
                    interacao = true;
                }
            }
        }
        return interacao;
    }

    /*
    * Método privado que auxilia a consultarUsuario que permite imprimir os dados dos empréstimos finalizados
    * pelo usuário.
    * */
    private boolean isImprimirDadosDeEmprestimosFinalizados(boolean interacao){
        String estadoFinalizado = "Finalizado";
        for (TransacaoEmprestimo transacaoEmprestimo : TransacaoEmprestimo.getEmprestimosFinalizados()) {
            if (transacaoEmprestimo.getUsuario().equals(this)) {
                ImprimirDadosOperacoes.imprimirDadosEmprestimos(transacaoEmprestimo);
                interacao = true;
            }
        }
        return interacao;
    }

    /*
    * Método privado que auxilia consultarUsuario que permite imprimir dados das reservas do Usuário.
    * */
    private boolean isImprimirDadosDeReservas(boolean interacao) {
        for(Livro livro: this.listaDeReservados){
            for(TransacaoReserva transacaoReserva : TransacaoReserva.getReservas()) {
                if (livro.equals(transacaoReserva.getLivro())) {
                    ImprimirDadosOperacoes.imprimirDadosDeReservas(transacaoReserva);
                    interacao = true;
                }
            }
        }
        return interacao;
    }

    /*
    * Método privado que auxilia consultarUsuario e serve para verificar as condições para a impressão
    * dos dados referentes aos Empréstimos Ativos, Empréstimo em Curso e as Reservas
    * */
    private void ImprimirDadosDeEmprestimosAtivosEFinalizadosEReservas(boolean interacao) {
        if(this.listaDeLivrosEmprestados.size() > 0){
            interacao = isImprimirDadosDeEmprestimosAtivos(interacao);
        }
        if(TransacaoEmprestimo.quantidadeEmprestimosFinalizados(this) > 0){
            interacao = isImprimirDadosDeEmprestimosFinalizados(interacao);
        }
        if(this.listaDeReservados.size() > 0){
            interacao = isImprimirDadosDeReservas(interacao);
        }
        if(!interacao){
            MensagensUser.mensagemDeNaoExistenciaDeOperacoes();
        }
    }

    /*
    * Método publico em que está definida a consulta dos dados do usuário.
    * O boolean de interação controla se houve alguma transação feita pelo usuário no sistema:
    * true = sim, false = não.
    * */
    @Override
    public void consultarUsuario(){
        boolean interacao = false;
        MensagensUser.imprimirNomeUsuario(this);
        ImprimirDadosDeEmprestimosAtivosEFinalizadosEReservas(interacao);
    }

    /*
    * Método público chamado quando mais de duas reservas simultâneas são feitas.
    * Padrão Observer
    * */
    @Override
    public void avisarReservasSimultaneas() {
        this.quantidadeDeNotificacoes++;
    }

    /*
    * Método público que define o tipo de usuário
    * */
    @Override
    public void setTipoDeUsuario(IEstadoUsuario estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    /*
    * Método público que tem como função de adicionar um exemplar do livro na lista de emprestados do usuário quando
    * ocorre um empréstimo.
    * */
    @Override
    public void adicionaNaListaDeEmprestados(Exemplar exemplar) {
        this.listaDeLivrosEmprestados.add(exemplar);
    }

    /*
    * Método público que tem como função remover um exemplar da lista de empréstimos quando o empréstimo é finalizado.
    * */
    @Override
    public void removeDaListaDeEmprestados(Exemplar exemplar) {
        this.listaDeLivrosEmprestados.remove(exemplar);
    }

    /*
    * Método público que tem como função adicionar um exemplar na lista de reservados quando ocorre uma reserva do livro.
    * */
    @Override
    public void adicionaNaListaDeReservados(Livro livro) {
        this.listaDeReservados.add(livro);
    }

    /*
    * Método público que tem como função remover um livro da lista de reservados quando um livro reservado pelo usuário
    * é emprestado para o mesmo.
    * */
    @Override
    public void removeDaListaDeReservados(Livro livro) {
        this.listaDeReservados.remove(livro);
    }


    /*
    * Demais getters/setters da classe
    * */


    @Override
    public String getIdentificador() {
        return identificador;
    }

    @Override
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean isDevedor() {
        return isDevedor;
    }

    @Override
    public void setDevedor(boolean devedor) {
        isDevedor = devedor;
    }

    @Override
    public IEstadoUsuario getEstadoUsuario() {
        return estadoUsuario;
    }

    @Override
    public void setEstadoUsuario(IEstadoUsuario estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    @Override
    public int getQuantidadeDeNotificacoes() {
        return quantidadeDeNotificacoes;
    }

    @Override
    public void setQuantidadeDeNotificacoes(int quantidadeDeNotificacoes) {
        this.quantidadeDeNotificacoes = quantidadeDeNotificacoes;
    }

    @Override
    public ArrayList<Exemplar> getListaDeLivrosEmprestados() {
        return listaDeLivrosEmprestados;
    }

    @Override
    public void setListaDeLivrosEmprestados(ArrayList<Exemplar> listaDeLivrosEmprestados) {
        this.listaDeLivrosEmprestados = listaDeLivrosEmprestados;
    }


    @Override
    public ArrayList<Livro> getListaDeReservados() {
        return listaDeReservados;
    }

    @Override
    public void setListaDeReservados(ArrayList<Livro> listaDeReservados) {
        this.listaDeReservados = listaDeReservados;
    }
}
