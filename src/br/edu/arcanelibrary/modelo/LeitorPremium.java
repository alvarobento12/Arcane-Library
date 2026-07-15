package br.edu.arcanelibrary.modelo;

public class LeitorPremium extends Leitor {
    private static final int pontoLeitura = 2;

    public LeitorPremium(String nome, int CPF, String email, int saldoPontos) {
        super(nome, CPF, email, saldoPontos);
    }
}
