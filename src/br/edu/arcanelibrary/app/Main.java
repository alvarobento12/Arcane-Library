package br.edu.arcanelibrary.app;

import br.edu.arcanelibrary.excecao.MaterialIndisponivelException;
import br.edu.arcanelibrary.excecao.PagamentoPremiumException;
import br.edu.arcanelibrary.excecao.PontosInsuficientesException;
import br.edu.arcanelibrary.modelo.*;
import br.edu.arcanelibrary.servico.CalculadoraMulta;
import br.edu.arcanelibrary.servico.CalculadoraMultaPadrao;

public class Main {

    public static void main(String[] args) {
        System.out.println("==== SISTEMA ARCANE LIBRARY ====\n");

        GerenciadorLeitor gerenciadorLeitor = new GerenciadorLeitor();
        GerenciadorMaterial gerenciadorMaterial = new GerenciadorMaterial();
        GerenciadorEmprestimo gerenciadorEmprestimo = new GerenciadorEmprestimo();

        // ---------- Cadastro de Leitores ----------
        System.out.println("--- Cadastro de Leitores ---");
        Leitor leitorComum = new LeitorComum("João Pedro", "111.111.111-11", "joao@email.com", 0);
        Leitor leitorPremium = new LeitorPremium("Maria Júlia", "222.222.222-22", "maria@email.com", 50);
        gerenciadorLeitor.adicionarLeitor(leitorComum);
        gerenciadorLeitor.adicionarLeitor(leitorPremium);
        gerenciadorLeitor.listarLeitores();
        System.out.println("Existe CPF 111.111.111-11?" + gerenciadorLeitor.existeCPF("111.111.111-11"));
        System.out.println();

        // ---------- Cadastro de Materiais ----------
        System.out.println("--- Cadastro de Materiais ---");
        Livros livro = new Livros("A Batalha do Apocalipse", 1, 2010, 2, SituacaoMaterial.DISPONIVEL,
                89.90f, "Eduardo Spohr", 9780132350884L, 560);
        Mangas manga = new Mangas("Dragon Ball", 2, 1984, 1, SituacaoMaterial.DISPONIVEL,
                199.90f, "Dragon Ball", "Panini", 1);
        gerenciadorMaterial.adicionarMaterial(livro);
        gerenciadorMaterial.adicionarMaterial(manga);
        gerenciadorMaterial.listarMaterial();
        System.out.println(livro);
        System.out.println(manga);
        System.out.println();

        // ---------- Empréstimo do Leitor Comum ----------
        System.out.println(" --- Empréstimo do Leitor Comum ---");
        Emprestimo emprestimoComum = new Emprestimo(leitorComum, new CalculadoraMultaPadrao());
        try {
            emprestimoComum.adicionarMaterial(livro);
            gerenciadorEmprestimo.adicionarEmprestimo(emprestimoComum);
            System.out.println("Empréstimo criado: " + emprestimoComum);
            emprestimoComum.consultarItensEmprestimo();
        } catch (MaterialIndisponivelException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        System.out.println();

        // ---------- Leitor Comum tentando usar pontos (deve falhar) ----------
        System.out.println("--- Leitor Comum tentando aumentar prazo com pontos (deve falhar)");
        try {
            emprestimoComum.aumentarEmprestimoComPontos(5);
        } catch (PontosInsuficientesException | PagamentoPremiumException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
        System.out.println();

        // ---------- Devolução no prazo (Leitor Comum ganha ponto) ----------
        System.out.println("--- Devolução no prazo (Leitor Comum) ");
        emprestimoComum.devolverMaterial();
        System.out.println(emprestimoComum);
        System.out.println(leitorComum);
        System.out.println(livro);
        System.out.println();

        // ---------- Empréstimo do Leitor Premium ----------
        System.out.println("--- Empréstimo do Leitor Premium ");
        Emprestimo emprestimoPremium = new Emprestimo(leitorPremium, new CalculadoraMultaPadrao());
        try {
            emprestimoPremium.adicionarMaterial(manga);
            gerenciadorEmprestimo.adicionarEmprestimo(emprestimoPremium);
            System.out.println("Empréstimo criado: " + emprestimoPremium);
        } catch (MaterialIndisponivelException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        System.out.println();

        // ---------- Premium aumenta prazo com pontos (sucesso) ----------
        System.out.println("--- Leitor Premium aumentando prazo com pontos (3 dias = 30 pontos) ---");
        try {
            emprestimoPremium.aumentarEmprestimoComPontos(3);
            System.out.println("Prazo estendido com sucesso! ");
            System.out.println(emprestimoPremium);
            System.out.println(leitorPremium);
        } catch (PontosInsuficientesException | PagamentoPremiumException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        System.out.println();

        // ---------- Premium sem pontos suficientes (deve falhar) ----------
        System.out.println("--- Leitor Premium com pontos insuficientes (10 dias = 100 pontos, só tem 20) ---");
        try {
            emprestimoPremium.aumentarEmprestimoComPontos(10);
        } catch (PontosInsuficientesException | PagamentoPremiumException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
        System.out.println();

        // ---------- Tentando emprestar material sem estoque (deve falhar) ----------
        System.out.println("--- Tentando emprestar o mesmo mangá sem estoque (deve falhar) ---");
        Emprestimo outroEmprestimo = new Emprestimo(leitorComum, new CalculadoraMultaPadrao());
        try {
            outroEmprestimo.adicionarMaterial(manga);
        } catch (MaterialIndisponivelException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
        System.out.println();

        // ---------- Devolução do mangá ----------
        System.out.println("--- Devolução do mangá (Leitor Premium) ---");
        emprestimoPremium.devolverMaterial();
        System.out.println(emprestimoPremium);
        System.out.println(manga);
        System.out.println();

        // ---------- Cálculo isolado de multa ----------
        System.out.println("--- Cálculo isolado de multa por atraso ---");
        CalculadoraMulta calculadora = new CalculadoraMultaPadrao();
        System.out.printf("Multa para 5 dias de atraso: R$ %.2f%n", calculadora.calcularMulta(5));
        System.out.println();

        // ---------- Testes dos Gerenciadores ----------
        System.out.println("--- Testes dos Gerenciadores ---");
        System.out.println("Buscar empréstimo #1: " + gerenciadorEmprestimo.buscarEmprestimo(1));
        System.out.println("Buscar material código 1: " + gerenciadorMaterial.buscarMaterial(1));
        gerenciadorLeitor.removerLeitor("111.111.111-11");
        System.out.println("Leitores após remoção de João Pedro: ");
        gerenciadorLeitor.listarLeitores();

        System.out.println("\n ===== FIM DOS TESTES =====");
    }
}