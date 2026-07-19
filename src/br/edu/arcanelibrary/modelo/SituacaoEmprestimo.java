package br.edu.arcanelibrary.modelo;

public enum SituacaoEmprestimo {

    ABERTO,
    FINALIZADO,
    ATRASADO;


    public boolean estaAberto() {
        return this == ABERTO;
    }

    public boolean estaFinalizado() { return this == FINALIZADO; }

    public boolean estaAtrasado() {return this == ATRASADO; }
}
