package dev.rodolfo;

public abstract class Notificacao {

    private String destinatario;
    private String mensagem;

    public abstract void enviar();
}
