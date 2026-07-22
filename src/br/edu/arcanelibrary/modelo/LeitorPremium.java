package br.edu.arcanelibrary.modelo;

import br.edu.arcanelibrary.excecao.PontosInsuficientesException;

public class LeitorPremium extends Leitor {
    private static final int PONTOS_LEITURA = 2;

    public LeitorPremium(String nome, String CPF, String email, int saldoPontos) {
        super(nome, CPF, email, saldoPontos);
    }

    public void calcularPontosDeLeitura() {

        adicionarPontos(PONTOS_LEITURA);
    }

    public void pagarComPontos (int diasDesejados) throws PontosInsuficientesException {
        int custoEmPontos = diasDesejados * 10;
        if(diasDesejados <= 0) {
            throw new IllegalArgumentException();
        }

        if (this.getSaldoPontos() < custoEmPontos) {
            throw new PontosInsuficientesException("Pontos insuficientes para aumentar essa quantidade de dias. ");
        }

        this.setSaldoPontos(this.getSaldoPontos() - custoEmPontos);
    }
}
