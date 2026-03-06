package dev.rodolfo;

public class Main {

    static void main() {
        Aluno a1 = new Aluno(
                "Martin Fowler",
                11223344,
                true,
                new Curso(
                        "ADS",
                        "Graduação",
                        920.50,
                        20.5
                )
        );

        Aluno a2 = new Aluno(
                "Kent Beck",
                22334455,
                false,
                new Curso(
                        "Computação Aplicada",
                        "Mestrado",
                        2150.45,
                        0
                )
        );

        System.out.println(a1.getDados());
        System.out.println(a2.getDados());
    }
}
