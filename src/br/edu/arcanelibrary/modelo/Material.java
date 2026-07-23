package br.edu.arcanelibrary.modelo;

import br.edu.arcanelibrary.excecao.MaterialIndisponivelException;

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

    public void emprestarExemplar() throws MaterialIndisponivelException {
        if (quantDisponivel == 0) {
            throw new MaterialIndisponivelException(
                    "Material Indisponível para Empréstimo, quantidade zerada em estoque.");
        }

        quantDisponivel --;

        if(quantDisponivel == 0) {
            situacao = SituacaoMaterial.INDISPONIVEL;
        }
    }

    public void devolverExemplar() {
        if(quantDisponivel == 0) {
            situacao = SituacaoMaterial.DISPONIVEL;
        }
        quantDisponivel ++;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s (%d) - %s - %d disponível(is)",
                codigo, titulo, anoPublicacao, situacao, quantDisponivel);
    }

}
