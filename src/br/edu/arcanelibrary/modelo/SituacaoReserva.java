package br.edu.arcanelibrary.modelo;

public enum SituacaoReserva {

    ATIVA,
    ATENDIDA,
    CANCELADA;

    public boolean estaAtiva() {return this == ATIVA;}

    public boolean estaAtendida() {return this == ATENDIDA;}

    public boolean estaCancelada() {return this == CANCELADA; }
}
