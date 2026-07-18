package br.edu.arcanelibrary.modelo;

public enum SituacaoMaterial {

    DISPONIVEL,
    INDISPONIVEL;

    public boolean estaDisponivel() {return this == DISPONIVEL;}

    public boolean estaIndisponivel() {return this == INDISPONIVEL; }
}
