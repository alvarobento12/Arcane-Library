package br.edu.arcanelibrary.modelo;

public class Livros extends Material {
    private String autor;
    private int numeroPaginas;
    private long ISBN;

    public Livros(String titulo, int codigo, int anoPublicacao, int quantDisponivel, SituacaoMaterial situacao, float valorReposicao,
                  String autor, long ISBN, int numeroPaginas) {
        super(titulo, codigo, anoPublicacao, quantDisponivel, situacao, valorReposicao);
        this.autor = autor;
        this.ISBN = ISBN;
        this.numeroPaginas = numeroPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public long getISBN() {
        return ISBN;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Autor: %s, ISBN: %d, %d páginas",
                autor, ISBN, numeroPaginas);
    }
}
