package dev.rodolfo;

import java.time.LocalDate;

public class Receita extends Transacao implements Tributavel {

    public Receita() {}

    public Receita(String descricao, Double valor, LocalDate data) {
        super(descricao, valor, data);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("--- Receita ---");
        System.out.println("Descrição: " + this.getDescricao());
        System.out.println("Valor: " + this.getValor());
        System.out.println("Data: " + this.getData());
        System.out.println("Total líquido: " + (this.getValor() - this.calcularTributos()));
    }

    @Override
    public double calcularTributos() {
        return this.getValor() * 0.10;
    }
}
