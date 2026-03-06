package dev.rodolfo;

public class Curso {

    private String nome, nivel;
    private double mensalidade, desconto;

    public Curso(String nome, String nivel, double mensalidade, double desconto) {
        this.nome = nome;
        this.nivel = nivel;
        this.mensalidade = mensalidade;
        this.desconto = desconto;
    }

    public String getNome() {
        return nome;
    }

    public String getNivel() {
        return nivel;
    }

    public double getMensalidade() {
        return mensalidade;
    }

    public double getDesconto() {
        return desconto;
    }

    public double calculaMensalidadeComDesconto() {
        return this.mensalidade * (1 - this.desconto / 100);
    }
}
