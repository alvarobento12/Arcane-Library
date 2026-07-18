package br.edu.arcanelibrary.modelo;

public enum SituacaoEmprestimo {

    ABERTO,
    FINALIZADO;


    public boolean estaAberto() {
        return this == ABERTO;
    }

    public boolean estaFinalizado() { return this == FINALIZADO; }
}
