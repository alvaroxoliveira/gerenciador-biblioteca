package Usuario.Estado;
import Comando.BuscaLivro;
import Usuario.User;

public class AlunoGraduacao implements IEstadoUsuario {
    private AlunoGraduacao() {}
    private final int quantidadeDeLivrosMaximaEmprestimo = 3;
    public static AlunoGraduacao instance; //cada livro só vai ter uma instancia de cada estado

    public static AlunoGraduacao getInstance() { //se não existir instancia, cria uma
        if(instance == null) {
            synchronized(AlunoGraduacao.class) {
                if(instance == null) {
                    instance = new AlunoGraduacao();
                }
            }
        }
        return instance;
    }

    @Override
    public void pegarLivroEmprestado(String codigoDoLivro, User user) {
//        if(user.getListaDeLivrosEmprestados().size() >= 3){
//            System.out.println("Usuário " + user.getNome() + " ja tem a quantidade máxima de livros emprestados.");
//        }
//        //se a quantidade de reservas for maior ou igual a quantidade de exemplares
//        else{
//            BuscaLivro.getLivro(codigoDoLivro).pegarLivroEmprestado(user);
//        }
        MetodosGeraisDeUsuarios.emprestimoParaAlunos(codigoDoLivro, user, this.getQuantidadeDeLivrosMaximaEmprestimo()); // Metodo chamado está em Metodos em comum
    }

    @Override
    public void devolverLivroEmprestado(String codigoDoLivro, User user) {
        BuscaLivro.getLivro(codigoDoLivro).devolverLivroEmprestado(user);
    }

    //faz a reserva de um livro passando o código e o usuário que vai a fazer
    @Override
    public void reservarLivro(String codigoDoLivro, User user) { //Caio
        // (Álvaro) Fiz essa alteração mas tenho que ver com Caio
//        if(user.getListaDeReservados().size() < 3) { //caso o usuario tenha menos que 3 livros reservados
//            BuscaLivro.getLivro(codigoDoLivro).reservarLivro(user); //reservar livro
//            MensagensUsuariosGerais.mensagemDeReservaFeita(codigoDoLivro, user.getNome()); // Mensagem de reserva quando é feita
//        } else {
//            MensagensUsuariosGerais.mensagemDeQuantidadeMaximaDeReservasFeitas(user.getNome());
//            return;
//        }
        MetodosGeraisDeUsuarios.reservaParaUsuario(codigoDoLivro, user);
    }

    //metodo polimorfico para saber a qtd de dia de cada tipo de usuario
    @Override
    public int diasParaEntrega() {
        return 3;
    }

    public int getQuantidadeDeLivrosMaximaEmprestimo() {
        return quantidadeDeLivrosMaximaEmprestimo;
    }
}
