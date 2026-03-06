package dev.rodolfo;

public class Trabalho {

    private String titulo, tipo, nome_orientador;
    private double nota;
    private Curso curso;

    public Trabalho(String titulo, String nivelCurso, String nome_orientador, double nota, Curso curso) {
        this.titulo = titulo;
        switch (nivelCurso) {
            case "Graduação (Bacharelado)": tipo = "TCC"; break;
            case "Lato Senso": tipo = "Monografia"; break;
            case "Mestrado": tipo = "Dissertação"; break;
            case "Doutorado": tipo = "Tese"; break;
        }
        this.nome_orientador = nome_orientador;
        this.nota = nota;
        this.curso = curso;
    }

    public String getDados () {
        String resp = "Título do trabalho (" + tipo + ") : ";
        resp += titulo + "\n";
        resp += "Orientador (a) : Prof. " + nome_orientador + "\n";
        resp += "Nota: " + nota + "\n";
        return resp;
    }
}
