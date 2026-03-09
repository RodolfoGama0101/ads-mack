package dev.rodolfo;

public class Professor extends Pessoa implements Trabalhador {

    private String registroProfissional;

    private String titulacao;

    private Integer limiteHoras;

    public Professor(String nome, String cpf, String email, String registroProfissional, String titulacao, Integer limiteHoras) {
        super(nome, cpf, email);
        this.registroProfissional = registroProfissional;
        this.titulacao = titulacao;
        this.limiteHoras = limiteHoras;
    }

    @Override
    void exibirInformacoes() {
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Email: " + this.email);
        System.out.println("Registro Profissional: " + this.registroProfissional);
        System.out.println("Titulacao: " + this.titulacao);
        System.out.println("Limite Horas: " + this.limiteHoras);
    }

    @Override
    public void trabalhar() {
        System.out.println("dev.rodolfo.Professor " + this.nome + " está trabalhando!");
    }
}
