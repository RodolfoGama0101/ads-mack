package dev.rodolfo;

public class Aluno {

    private String nome;
    private int cod_matrícula;
    private boolean e_bolsista;
    private Curso curso;

    public Aluno(String nome, int cod_matrícula, boolean e_bolsista, Curso curso) {
        this.nome = nome;
        this.cod_matrícula = cod_matrícula;
        this.e_bolsista = e_bolsista;
        this.curso = curso;
    }

    public String getDados()
    {
        String resp = "Aluno: "+ this.nome +"\n";
        resp += "Curso: " + this.curso.getNivel() + " em " + this.curso.getNome() +"\n";

        if (e_bolsista) {
            resp += "Bolsista com desconto de: " + this.curso.getDesconto()+"\n";
            resp += "Mensalidade: R$ " + this.curso.calculaMensalidadeComDesconto() +"\n";
        } else resp += "Mensalidade: R$ " + this.curso.getMensalidade();

        return resp;
    }
}
