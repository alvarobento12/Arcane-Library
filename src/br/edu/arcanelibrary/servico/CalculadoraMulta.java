package br.edu.arcanelibrary.servico;
import br.edu.arcanelibrary.modelo.Emprestimo;

public interface CalculadoraMulta {
    double calcularMulta(long diasAtraso);
}
