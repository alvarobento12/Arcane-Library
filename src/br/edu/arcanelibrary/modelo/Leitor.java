package br.edu.arcanelibrary.modelo;

public abstract class Leitor {
    private String nome, email, CPF;
    private int saldoPontos;

    public Leitor(String nome, String CPF, String email, int saldoPontos) {
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

    public String getCPF() {
        return CPF;
    }

    public int getSaldoPontos() {
        return saldoPontos;
    }

    public void setSaldoPontos(int saldoPontos) {this.saldoPontos = saldoPontos; }

    protected void adicionarPontos(int pontos) {
        saldoPontos += pontos;
    }

    public abstract void calcularPontosDeLeitura();

    @Override
    public String toString() {
        return String.format("%s : %s (CPF: %s) - %d pontos",
                getClass().getSimpleName(), nome, CPF, saldoPontos);
    }
}
