package br.edu.arcanelibrary.servico;

public class CalculadoraMultaPadrao implements CalculadoraMulta {

    private static final double VALOR_POR_DIA = 2.50;

    @Override
    public double calcularMulta(long diasAtraso) {
        return diasAtraso * VALOR_POR_DIA;
    }
}

