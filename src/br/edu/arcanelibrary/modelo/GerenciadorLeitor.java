package br.edu.arcanelibrary.modelo;
import java.util.ArrayList;

public class GerenciadorLeitor {
    private ArrayList<Leitor> leitores;

    public GerenciadorLeitor() {leitores = new ArrayList<>(); }

    public void adicionarLeitor(Leitor leitor) {
        leitores.add(leitor);
    }

    public Leitor buscarLeitor(String CPF) {
        for(Leitor leitor : leitores) {
            if(CPF == leitor.getCPF()) {
                return leitor;
            }
        }
        return null;
    }

    public void removerLeitor(String CPF) {
        Leitor removivel = buscarLeitor(CPF);
        leitores.remove(removivel);
    }

    public void listarLeitores() {
        for(Leitor leitor : leitores) {
            System.out.println(leitor.getNome());
        }
    }

    public boolean existeCPF (String CPF) {
       return buscarLeitor(CPF) != null;
    }
}
