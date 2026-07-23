package br.edu.arcanelibrary.modelo;
import java.util.ArrayList;

public class GerenciadorEmprestimo {
    private ArrayList<Emprestimo> emprestimos;

    public GerenciadorEmprestimo() {emprestimos = new ArrayList<>(); }

    public void adicionarEmprestimo (Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public Emprestimo buscarEmprestimo(int numeroEmprestimo) {
        for(Emprestimo emprestimo : emprestimos) {
            if(numeroEmprestimo == emprestimo.getNumeroEmprestimo()) {
                return emprestimo;
            }
        }
        return null;
    }

    public void removerEmprestimo(int numeroEmprestimo) {
        Emprestimo removivel = buscarEmprestimo(numeroEmprestimo);
        emprestimos.remove(removivel);
    }

   public void listarEmprestimos() {
        for(Emprestimo emprestimo : emprestimos) {
            System.out.println(emprestimo);
        }

   }

    public void adicinoar() {

    }
}
