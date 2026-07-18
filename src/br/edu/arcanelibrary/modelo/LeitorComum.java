package br.edu.arcanelibrary.modelo;

public class LeitorComum extends Leitor{
    private static final int PONTOS_LEITURA= 1;

    public LeitorComum(String nome, String CPF, String email, int saldoPontos) {
        super(nome, CPF, email, saldoPontos);
    }

    @Override
    public void calcularPontosDeLeitura() {
        adicionarPontos(PONTOS_LEITURA);
    }
}
