package Livro;

import java.util.ArrayList;

public class Transacoes {
    private static String codigoExemplar;
    private static String identificador;

    private ArrayList<Transacoes> reservas = new ArrayList<>();
    private ArrayList<Transacoes> emprestimosAtuais = new ArrayList<>();
    private ArrayList<Transacoes> emprestimosFinalizados = new ArrayList<>();
}
