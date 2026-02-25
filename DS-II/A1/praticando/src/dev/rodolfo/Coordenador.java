package dev.rodolfo;

public class Coordenador extends Professor implements Trabalhador {

    private String departamento;

    public Coordenador(String nome, String cpf, String email, String registroProfissional, String titulacao,
                       Integer limiteHoras, String departamento) {
        super(nome, cpf, email, registroProfissional, titulacao, limiteHoras);
        this.departamento = departamento;
    }

    @Override
    void exibirInformacoes() {
        super.exibirInformacoes();
    }

    @Override
    public void trabalhar() {
        System.out.println("dev.rodolfo.Coordenador " + this.nome + " está trabalhando!");
    }
}
