package br.edu.arcanelibrary.modelo;

public class Material {
    private int codigo, anoPublicacao, quantDisponivel;
    private String titulo, situacao;
    private float valorReposicao;

    public Material(String titulo, int codigo, int anoPublicacao, int quantDisponivel, String situacao, float valorReposicao) {
        this.titulo = titulo;
        this.codigo = codigo;
        this.anoPublicacao = anoPublicacao;
        this.quantDisponivel = quantDisponivel;
        this.situacao = situacao;
        this.valorReposicao = valorReposicao;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public int getQuantDisponivel() {
        return quantDisponivel;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSituacao() {
        return situacao;
    }

    public float getValorReposicao() {
        return valorReposicao;
    }
}
