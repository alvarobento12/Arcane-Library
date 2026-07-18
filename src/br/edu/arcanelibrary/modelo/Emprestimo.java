package br.edu.arcanelibrary.modelo;
import java.util.ArrayList;
import java.time.LocalDate;
import static br.edu.arcanelibrary.modelo.SituacaoMaterial.DISPONIVEL;

public class Emprestimo {
    private static int proximoNumero = 1;
    private int numeroEmprestimo;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private SituacaoEmprestimo situacao;
    private Leitor leitor;
    private ArrayList<ItemEmprestimo> itens;

    public Emprestimo(Leitor leitor) {
        this.leitor = leitor;
        this.numeroEmprestimo = proximoNumero++;
        this.dataEmprestimo = LocalDate.now();
        this.dataPrevistaDevolucao = dataEmprestimo.plusDays(14);
        this.situacao = SituacaoEmprestimo.ABERTO;
        this.itens = new ArrayList<>();
    }

    public int getNumeroEmprestimo() {
        return numeroEmprestimo;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public Leitor getLeitor() {
        return leitor;
    }
    public void adicionarMaterial(Material material) {
        material.
        if(situacao == DISPONIVEL) {

        }
    }
}
