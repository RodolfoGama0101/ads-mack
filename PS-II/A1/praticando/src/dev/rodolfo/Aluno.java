package dev.rodolfo;

import java.time.LocalDate;

public class Aluno extends Pessoa {

    private Long ra;
    private String curso;
    private LocalDate anoIngresso;

    public Aluno(String nome, String cpf, String email, Long ra, String curso, LocalDate anoIngresso) {
        super(nome, cpf, email);
        this.ra = ra;
        this.curso = curso;
        this.anoIngresso = anoIngresso;
    }

    @Override
    void exibirInformacoes() {
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Email: " + this.email);
        System.out.println("RA: " + this.ra);
        System.out.println("Curso: " + this.curso);
        System.out.println("Ano Ingresso: " + this.anoIngresso);
    }
}
