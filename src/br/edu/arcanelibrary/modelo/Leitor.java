package br.edu.arcanelibrary.modelo;

public abstract class Leitor {
    private String nome, email;
    private int CPF, saldoPontos;

    public Leitor(String nome, int CPF, String email, int saldoPontos) {
        this.nome = nome;
        this.CPF = CPF;
        this.email = email;
        this.saldoPontos = saldoPontos;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getCPF() {
        return CPF;
    }

    public int getSaldoPontos() {
        return saldoPontos;
    }


}
