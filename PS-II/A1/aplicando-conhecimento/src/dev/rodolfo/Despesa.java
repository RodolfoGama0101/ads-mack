package dev.rodolfo;

import java.time.LocalDate;

public class Despesa extends Transacao {

    public Despesa() {}

    public Despesa(String descricao, Double valor, LocalDate data) {
        super(descricao, valor, data);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("--- Despesa ---");
        System.out.println("Descrição: " + this.getDescricao());
        System.out.println("Valor: " + this.getValor());
        System.out.println("Data: " + this.getData());
    }
}
