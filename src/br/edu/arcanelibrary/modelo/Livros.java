package br.edu.arcanelibrary.modelo;

public class Livros extends Material {
    private String autor;
    private int ISBN, numeroPaginas;

    public Livros(String titulo, int codigo, int anoPublicacao, int quantDisponivel, String situacao, float valorReposicao,
                  String autor, int ISBN, int numeroPaginas) {
        super(titulo, codigo, anoPublicacao, quantDisponivel, situacao, valorReposicao);
        this.autor = autor;
        this.ISBN = ISBN;
        this.numeroPaginas = numeroPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public int getISBN() {
        return ISBN;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }
}
