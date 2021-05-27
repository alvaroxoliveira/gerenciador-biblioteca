package Usuario;

import Buscas.BuscaLivro;
import Livro.Exemplar;
import Livro.Livro;
import MensagensConsole.ImprimirDadosOperacoes;
import MensagensConsole.MensagensUser;
import Observer.Observer;
import Transacoes.TransacaoEmprestimo;
import Transacoes.TransacaoReserva;
import Usuario.Estado.IEstadoUsuario;

import java.util.ArrayList;

public class User implements IUser, Observer {
    private String identificador;
    private String nome;
    private boolean isDevedor;
    private IEstadoUsuario estadoUsuario;
    private int quantidadeDeNotificacoes;

    // Lista de livros que o usuário está no momento
    private ArrayList<Exemplar> listaDeLivrosEmprestados;
    private ArrayList<Livro> listaDeReservados;

    public User(String identificador, String nome) {
        this.identificador = identificador;
        this.nome = nome;
        this.quantidadeDeNotificacoes = 0;
        this.listaDeLivrosEmprestados = new ArrayList<Exemplar>();
        this.listaDeReservados = new ArrayList<Livro>();
        this.isDevedor = false;
    }

    private boolean verificaSeJaTemOLivroEmprestado(String codigoDoLivro) {
        for(Exemplar exemplar: this.listaDeLivrosEmprestados) {
            if(exemplar.getCodigoDoLivro().equals(codigoDoLivro)) {
                return true;
            }
        }
        return false;
    }

    //verifica se há uma reserva do mesmo livro pelo usuárip
    @Override
    public boolean verificaSeJaTemOLivroReservado(String codigoDoLivro){ //caio
        for(Livro livro: this.listaDeReservados) {
            if(livro.getId().equals(codigoDoLivro)) {
                return true;
            }
        }
        return false;
    }

    // Metodo alterado para receber mensagens de uma classe responsável para imprimir mensagens somente
    // da classe usuário
    @Override
    public void realizaEmprestimo(String codigoDoLivro) {
        //testa se existe algum exemplar do livro
        if(BuscaLivro.getLivro(codigoDoLivro).getQuantidadeExemplares() == 0){
            MensagensUser
                    .mensagemDeNaoExistenciaDeExemplar
                            (BuscaLivro.getLivro(codigoDoLivro).getTitulo());
            return;
        }
        //chama o método para verificar se o usuário já fez emprestimo do mesmo livro
        else if(verificaSeJaTemOLivroEmprestado(codigoDoLivro)) { //perguntar na aula
            MensagensUser.mensagemOperacaoJaFeitaComLivro(codigoDoLivro, this.getNome(), "Emprestado");
            return;
        }
        else if(this.isDevedor == true) { //verifica se o usuário é devedor
            MensagensUser.mensagemDeInadimplencia(this.nome);
            return;
        }
        else { //chama o método do estado do usuario para a reserva do livro
            this.estadoUsuario.pegarLivroEmprestado(codigoDoLivro, this);
            return;
        }
    }


    // Realiza Devoluçao
    @Override
    public void realizaDevolucao(String codigoDoLivro) {
        if(this.listaDeLivrosEmprestados.size() > 0) {
            this.estadoUsuario.devolverLivroEmprestado(codigoDoLivro, this);
        } else {
            MensagensUser.mensagemNaoHaLivroParaDevolver(this.nome);
        }
    }

    // Faz a reserva de um exemplar
    @Override
    public void realizaReserva(String codigoDoLivro) { //caio
        //chama o método para verificar se o usuário já reservou o mesmo livro
        if(verificaSeJaTemOLivroReservado(codigoDoLivro)) {
            MensagensUser.mensagemOperacaoJaFeitaComLivro(codigoDoLivro, this.getNome()," reservado.");
            return;
        } else if(this.isDevedor == true) { //verifica se o usuário é devedor
            MensagensUser.mensagemDeInadimplencia(this.getNome());
            return;
        } else if(verificaSeJaTemOLivroEmprestado(codigoDoLivro)){ //testa se ja tem o exemplar reservado
            MensagensUser.mensagemOperacaoJaFeitaComLivro(codigoDoLivro, this.getNome(), " emprestado.");
        } else { //chama o método do estado do usuario para a reserva do livro
            this.estadoUsuario.reservarLivro(codigoDoLivro, this);
            return;
        }
    }

    // Metodo extraido do método de consultar usuário e serve para imprimir dados de Emprestimos Ativos
    private boolean isImprimirDadosDeEmprestimosAtivos(boolean interacao) {
        String estadoEmCurso = "Em curso";
        for(Exemplar exemplar: this.listaDeLivrosEmprestados){
            for(TransacaoEmprestimo transacaoEmprestimo : TransacaoEmprestimo.getEmprestimosAtuais()){
                if(exemplar.equals(transacaoEmprestimo.getExemplar())){ //caso tenha algum exemplar emprestado
//                    ImprimirDadosOperacoes.imprimirDadosDeEmprestimosAtuais(transacaoEmprestimo);
                    ImprimirDadosOperacoes.imprimirDadosEmprestimos(transacaoEmprestimo, estadoEmCurso); // Dentro da Classe ImprimirDadosOperacoes no pacote Impressoes
                    interacao = true;
                }
            }
        }
        return interacao;
    }

    private boolean isImprimirDadosDeEmprestimosFinalizados(boolean interacao){
        String estadoFinalizado = "Finalizado";
        for (TransacaoEmprestimo transacaoEmprestimo : TransacaoEmprestimo.getEmprestimosFinalizados()) {
            if (transacaoEmprestimo.getUsuario().equals(this)) {
//                ImprimirDadosOperacoes.imprimirDadosEmprestimosFinalizados(transacaoEmprestimo);
                ImprimirDadosOperacoes.imprimirDadosEmprestimos(transacaoEmprestimo, estadoFinalizado);
                interacao = true;
            }
        }
        return interacao;
    }

    // Método extraído do método de consultar usuário e serve para imprimir dados das reservas dos usuários
    private boolean isImprimirDadosDeReservas(boolean interacao) {
//        System.out.println("Teste" + this.listaDeReservados.size());
        for(Livro livro: this.listaDeReservados){
            for(TransacaoReserva transacaoReserva : TransacaoReserva.getReservas()) {
                if (livro.equals(transacaoReserva.getLivro())) { //para encontrar o exemplar
                    ImprimirDadosOperacoes.imprimirDadosDeReservas(transacaoReserva); // Método encontrado em ImprimirDadosOperacoes
                    interacao = true;
                }
            }
        }
        return interacao;
    }

    // Método Extraído da consulta de Usuário e serve para imprimir os dados dos Emprestimos ativos e finalizados e também as reservas
    private void ImprimirDadosDeEmprestimosAtivosEFinalizadosEReservas(boolean interacao) {
        //imprimir os emprestimos ativos
        if(this.listaDeLivrosEmprestados.size() > 0){
            interacao = isImprimirDadosDeEmprestimosAtivos(interacao);
        }
        //imprimir os emprestimos finalizados
        if(TransacaoEmprestimo.quantidadeEmprestimosFinalizados(this) > 0){ //testa se ja teve finalizado
            interacao = isImprimirDadosDeEmprestimosFinalizados(interacao);
        }
        //imprimir as reservas
        if(this.listaDeReservados.size() > 0){ //caso haja alguma reserva
            interacao = isImprimirDadosDeReservas(interacao);
        }
        // Não existem emprestimos ativos e/ou finalizados ou reservas
        if(!interacao){
            MensagensUser.mensagemDeNaoExistenciaDeOperacoes();
        }
    }

    //método para consultar o usuário
    @Override
    public void consultarUsuario(){
        boolean interacao = false; //variavel de controle para caso não haja nenhuma transacao
        MensagensUser.imprimirNomeUsuario(this.getNome());
        ImprimirDadosDeEmprestimosAtivosEFinalizadosEReservas(interacao);
    }

    //Método para consultar professor
    @Override
    public void consultarProfessor(){
       MensagensUser.mensagemDeNotificacaoProfessor(this.getNome(), this.getQuantidadeDeNotificacoes());
    }

    // Avisa ao usuario quando mais de duas reservas simultaneas foram feitas
    @Override
    public void avisarReservasSimultaneas() {
        //System.out.println("Usuario: " + this.getNome() + ". Foram feitas mais de duas reservas simultâneas.");
        this.quantidadeDeNotificacoes++;
    }

    // Método de definição de tipo de usuário
    @Override
    public void setTipoDeUsuario(IEstadoUsuario estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    // Adiciona um livro na lista de emprestimos
    @Override
    public void adicionaNaListaDeEmprestados(Exemplar exemplar) {
        this.listaDeLivrosEmprestados.add(exemplar);
    }

    // Remove o objeto exemplar da lista de exemplares emprestados
    @Override
    public void removeDaListaDeEmprestados(Exemplar exemplar) {
        this.listaDeLivrosEmprestados.remove(exemplar);
    }

    @Override
    public void adicionaNaListaDeReservados(Livro livro) {
        this.listaDeReservados.add(livro);
    }
    
    @Override
    public void removeDaListaDeReservados(Livro livro) {
        this.listaDeReservados.remove(livro);
    }

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
