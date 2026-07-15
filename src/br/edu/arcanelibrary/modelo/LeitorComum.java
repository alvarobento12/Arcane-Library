package br.edu.arcanelibrary.modelo;

public class LeitorComum extends Leitor{
    private static final int pontoLeitura = 1;

    public LeitorComum(String nome, int CPF, String email, int saldoPontos) {
        super(nome, CPF, email, saldoPontos);
    }


}
