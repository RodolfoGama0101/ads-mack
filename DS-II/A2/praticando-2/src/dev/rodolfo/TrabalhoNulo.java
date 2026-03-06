package dev.rodolfo;

public class TrabalhoNulo extends Trabalho {

    public TrabalhoNulo() {
        super(null, "", null, -1.0, null);
    }

    public String getDados() {
        return "Obs: CST não tem obrigatoriedade de trabalho de conclusão\n";
    }
}
