package dev.rodolfo;

public class Main {

    static void main() {

        Curso curso1 = new Curso(
                "ADS",
                "Graduação (Bacharelado)",
                920.50,
                20.5
        );

        Trabalho trabalho1 = new Trabalho(
                "Impacto da Refatoração", curso1.getNivel(), "Peter Coad", 9.5, curso1
        );

        Curso curso2 = new Curso(
                "Computação Aplicada",
                "Mestrado",
                2150.45,
                0
        );

        Trabalho trabalho2 = new TrabalhoNulo();

        Aluno a1 = new Aluno(
                "Martin Fowler",
                11223344,
                true,
                curso1,
                trabalho1

        );

        Aluno a2 = new Aluno(
                "Kent Beck",
                22334455,
                false,
                curso2,
                trabalho2
        );

        System.out.println(a1.getDados());
        System.out.println(a2.getDados());
    }
}
