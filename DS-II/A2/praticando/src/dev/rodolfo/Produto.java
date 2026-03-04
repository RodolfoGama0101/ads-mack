package dev.rodolfo;

import dev.rodolfo.exceptions.NomeInvalidoException;
import dev.rodolfo.exceptions.PrecoInvalidoException;
import dev.rodolfo.exceptions.QuantidadeInvalidaException;

public class Produto {

    private String nome;

    private double preco;

    private int quantidade;

    public Produto(String nome, double preco, int quantidade) throws NomeInvalidoException {
        if (nome == null || nome.trim().isEmpty()) throw new NomeInvalidoException("Nome inválido");

        if (preco <= 0) throw new PrecoInvalidoException("Valor de preço inválido");

        if (quantidade < 0) throw new QuantidadeInvalidaException("Valor de quantidade inválido");

        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto: " + nome + " | Preço: R$" + preco + " | Quantidade: " + quantidade;
    }
}
