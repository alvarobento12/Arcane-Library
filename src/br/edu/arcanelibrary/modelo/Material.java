package br.edu.arcanelibrary.modelo;

import static br.edu.arcanelibrary.modelo.SituacaoMaterial.INDISPONIVEL;

public class Material {
    private int codigo, anoPublicacao, quantDisponivel;
    private String titulo;
    private SituacaoMaterial situacao;
    private float valorReposicao;

    public Material(String titulo, int codigo, int anoPublicacao, int quantDisponivel, SituacaoMaterial situacao, float valorReposicao) {
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

    public float getValorReposicao() {
        return valorReposicao;
    }

    public void setTitulo(String titulo) {this.titulo = titulo; }

    public void emprestarExemplar() {
        if (quantDisponivel > 0) {
            quantDisponivel --;
        }

        if(quantDisponivel == 0) {
            situacao = SituacaoMaterial.INDISPONIVEL;
        }
    }

    public void devolverExemplar() {
        quantDisponivel ++;

        if(quantDisponivel == 0) {
            situacao = SituacaoMaterial.DISPONIVEL;
        }
    }

}
