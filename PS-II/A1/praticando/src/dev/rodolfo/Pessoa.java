package dev.rodolfo;

abstract class Pessoa {

    protected String nome;

    protected String cpf;

    protected String email;

    public Pessoa(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    abstract void exibirInformacoes();
}
