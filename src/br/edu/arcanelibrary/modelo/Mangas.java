package br.edu.arcanelibrary.modelo;

public class Mangas extends Material {
    private String serie, editora;
    private int volume;

    public Mangas(String titulo, int codigo, int anoPublicacao, int quantDisponivel, SituacaoMaterial situacao, float valorReposicao,
                  String serie, String editora, int volume) {
        super(titulo, codigo, anoPublicacao, quantDisponivel, situacao, valorReposicao);
        this.serie = serie;
        this.editora = editora;
        this.volume = volume;
    }

    public String getSerie() {
        return serie;
    }

    public String getEditora() {
        return editora;
    }

    public int getVolume() {
        return volume;
    }
}
