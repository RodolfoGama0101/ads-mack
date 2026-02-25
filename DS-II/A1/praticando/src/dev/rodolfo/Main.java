package dev.rodolfo;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Aluno aluno = new Aluno("Rodolfo", "543.324.158-75", "10742570@mackenzista.com.br",
                10742570L, "Análise e Desenvolvimento de Sistemas", LocalDate.ofYearDay(2024, 1));

        System.out.println("--- Aluno ---");
        aluno.exibirInformacoes();

        System.out.println(" ");

        Professor professor = new Professor("Heitor", "926.763.158-75", "heitor@mack.com.br",
                "8255-SP", "Mestre", 200);

        System.out.println("--- Professor ---");
        professor.exibirInformacoes();

        professor.trabalhar();

        System.out.println(" ");

        Coordenador coordenador = new Coordenador("Moacir", "087.476.745-95", "moacir@mack.reitoria.com.br",
                "7854-MG", "Doutor Mestre", 220, "Reitoria");

        System.out.println("--- Coordenador ---");
        coordenador.exibirInformacoes();

        coordenador.trabalhar();
    }
}
