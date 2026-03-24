package dev.rodolfo;

import java.io.Serializable;

public class Livro implements Serializable {

    private String titulo;

    private String autor;

    private Integer anoPublicacao;

    private transient Double preco;

    public Livro(String titulo, String autor, Integer anoPublicacao, Double preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                ", preco=" + preco +
                '}';
    }
}
