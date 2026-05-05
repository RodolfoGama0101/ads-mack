package dev.rodolfo.aplicandoconhecimento.model;

import dev.rodolfo.aplicandoconhecimento.exception.ValorInvalidoException;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Transacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private Double valor;
    private LocalDate data;

    public Transacao() {}

    public Transacao(String descricao, Double valor, LocalDate data) throws ValorInvalidoException {
        if (valor <= 0) throw new ValorInvalidoException("O valor da transação deve ser maior que zero");
        if (descricao == null || descricao.isBlank()) throw new IllegalArgumentException("A descrição não pode ser vazia.");
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) {
        if (descricao == null || descricao.isBlank()) throw new IllegalArgumentException("A descrição não pode ser vazia.");
        this.descricao = descricao;
    }

    public Double getValor() { return valor; }
    public void setValor(Double valor) throws ValorInvalidoException {
        if (valor <= 0) throw new ValorInvalidoException("O valor da transação deve ser maior que zero");
        this.valor = valor;
    }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public abstract void exibirDetalhes();
}