package br.edu.arcanelibrary.modelo;
import br.edu.arcanelibrary.servico.CalculadoraMulta;
import br.edu.arcanelibrary.servico.CalculadoraMultaPadrao;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.time.LocalDate;
import static br.edu.arcanelibrary.modelo.SituacaoMaterial.DISPONIVEL;

public class Emprestimo {
    private static int proximoNumero = 1;
    private int numeroEmprestimo;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolucao;
    private SituacaoEmprestimo situacao;
    private Leitor leitor;
    private ArrayList<ItemEmprestimo> itens;

    private CalculadoraMulta calculadoraMulta;
    private double valorMulta;

    public Emprestimo(Leitor leitor, CalculadoraMulta calculadoraMulta) {
        this.leitor = leitor;
        this.numeroEmprestimo = proximoNumero++;
        this.dataEmprestimo = LocalDate.now();
        this.dataPrevistaDevolucao = dataEmprestimo.plusDays(14);
        this.situacao = SituacaoEmprestimo.ABERTO;
        this.itens = new ArrayList<>();

        this.calculadoraMulta = calculadoraMulta;
        this.valorMulta = 0;
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
        material.emprestarExemplar();
        ItemEmprestimo item = new ItemEmprestimo(material);
        itens.add(item);
    }

    public boolean estaAtrasado() {
        return dataDevolucao.isAfter(dataPrevistaDevolucao);
    }

    public long calcularDiasAtraso() {
        long diasAtraso = ChronoUnit.DAYS.between(dataPrevistaDevolucao, dataDevolucao);
        return diasAtraso;
    }

    public void devolverMaterial() {
        for (ItemEmprestimo item : itens) {
            item.getMaterial().devolverExemplar();
        }

        dataDevolucao = LocalDate.now();
        if (estaAtrasado()) {
            long diasDeAtraso = calcularDiasAtraso();
            valorMulta = calculadoraMulta.calcularMulta(diasDeAtraso);
        }
        situacao = SituacaoEmprestimo.FINALIZADO;
    }
}
