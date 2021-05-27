package Usuario.Estado;

import Buscas.BuscaLivro;
import Usuario.User;

public class AlunoPosGraduacao implements IEstadoUsuario {
    private AlunoPosGraduacao() {}

    public static AlunoPosGraduacao instance; //cada aluno só vai ter uma instancia de cada estado
    private final int quantidadeDeLivrosMaximaEmprestimo = 4;

    public static AlunoPosGraduacao getInstance() { //se não existir instancia, cria uma
        if(instance == null) {
            synchronized(AlunoPosGraduacao.class) {
                if(instance == null) {
                    instance = new AlunoPosGraduacao();
                }
            }
        }
        return instance;
    }

    @Override
    public void pegarLivroEmprestado(String codigoDoLivro, User user) {
//        if(user.getListaDeLivrosEmprestados().size() >= 4){
//            System.out.println("Usuário " + user.getNome() + " ja tem a quantidade máxima de livros emprestados.");
//        }
//        //se a quantidade de reservas for maior ou igual a quantidade de exemplares
//        else{
//            BuscaLivro.getLivro(codigoDoLivro).pegarLivroEmprestado(user);
//        }
        MetodosGeraisDeUsuarios.emprestimoParaAlunos(codigoDoLivro, user, this.getQuantidadeDeLivrosMaximaEmprestimo());
    }

    @Override
    public void devolverLivroEmprestado(String codigoDoLivro, User user) {
        BuscaLivro.getLivro(codigoDoLivro).devolverLivroEmprestado(user);
    }

    @Override
    public void reservarLivro(String codigoDoLivro, User user) { //Caio
        MetodosGeraisDeUsuarios.reservaParaUsuario(codigoDoLivro, user);
    }

    //metodo polimorfico para saber a qtd de dia de cada tipo de usuario
    @Override
    public int diasParaEntrega() {
        return 4;
    }

    public int getQuantidadeDeLivrosMaximaEmprestimo() {
        return quantidadeDeLivrosMaximaEmprestimo;
    }
}
