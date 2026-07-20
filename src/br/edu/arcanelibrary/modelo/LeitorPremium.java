package br.edu.arcanelibrary.modelo;

public class LeitorPremium extends Leitor {
    private static final int PONTOS_LEITURA = 2;

    public LeitorPremium(String nome, String CPF, String email, int saldoPontos) {
        super(nome, CPF, email, saldoPontos);
    }

    public void calcularPontosDeLeitura() {

        adicionarPontos(PONTOS_LEITURA);
    }
}
