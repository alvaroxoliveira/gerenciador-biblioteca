package Usuario.Estado;

import Comando.BuscaLivro;
import Mensagens.MensagensUsuariosGerais;
import Transacoes.TransacaoReserva;
import Usuario.User;

public class MetodosEmComum {

    public static void reservaParaUsuario(String codigoDoLivro, User user) {
        if(user.getListaDeReservados().size() < 3) { //caso o usuario tenha menos que 3 livros reservados
            TransacaoReserva.adicionarReserva(BuscaLivro.getLivro(codigoDoLivro), user);
            user.getListaDeReservados().add(BuscaLivro.getLivro(codigoDoLivro));
            MensagensUsuariosGerais.mensagemDeReservaFeita(codigoDoLivro, user.getNome()); // Mensagem de reserva quando é feita
            //if(TransacaoReserva.quantidadeReserva(BuscaLivro.getLivro(codigoDoLivro)) == 3) // tava com esse erro
            if(TransacaoReserva.quantidadeReserva(BuscaLivro.getLivro(codigoDoLivro)) > 2){ //se passou de 2 reservas, notifica o professor
                user.avisarReservasSimultaneas(); //notifica o professor
            }
        } else {
            MensagensUsuariosGerais.mensagemDeQuantidadeMaximaDeReservasFeitas(user.getNome()); // Mensagem de maxima de reservas feitas
        }
    }

    public static void emprestimoParaAlunos(String codigoDoLivro, User user, int quantidadeMaxima) {
        if(user.getListaDeLivrosEmprestados().size() >= quantidadeMaxima){
            System.out.println("Usuário " + user.getNome() + " ja tem a quantidade máxima de livros emprestados.");
        }
        //se a quantidade de reservas for maior ou igual a quantidade de exemplares
        else{
            BuscaLivro.getLivro(codigoDoLivro).pegarLivroEmprestado(user);
        }
    }
}
