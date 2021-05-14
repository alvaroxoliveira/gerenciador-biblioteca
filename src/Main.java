import Usuario.*;
public class Main {

    public static void main(String[] args) {
        IAlunos p1 = new AlunoGraduacao(100, "Alvaro Souza Oliveira");
        System.out.println(p1.getQuantidadeDeLivrosEmprestadosDoUsuario());
    }
}
