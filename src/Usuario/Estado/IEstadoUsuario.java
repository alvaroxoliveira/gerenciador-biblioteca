package Usuario.Estado;

import Usuario.User;

public interface IEstadoUsuario {
    public void pegarLivroEmprestado(String codigoDoLivro, User user);
    public void devolverLivroEmprestado(String codigoDoLivro, User user);
    public void reservarLivro(String codigoDoLivro, User user);
    public int diasParaEntrega(); //metodo polimorfico para saber a qtd de dia de cada tipo de usuario
//    public void consultarLivro(int codigoDoLivro);
//    public void observarLivro(int codigoDoLivro);
}
