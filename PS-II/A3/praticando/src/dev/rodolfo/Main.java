package dev.rodolfo;

import java.io.*;
import java.util.List;

public class Main {

    private static final String NOME_ARQUIVO = "livros.ser";

    static void main(String[] args) {
        List<Livro> livros = List.of(
                new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954, 89.90),
                new Livro("1984", "George Orwell", 1949, 45.00),
                new Livro("Dom Casmurro", "Machado de Assis", 1899, 32.50)
        );

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOME_ARQUIVO))) {
            oos.writeObject(livros);

            System.out.println("Lista de livros salva em: " + NOME_ARQUIVO);
        } catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NOME_ARQUIVO))) {

            @SuppressWarnings("unchecked")
            List<Livro> listaRecuperada = (List<Livro>) ois.readObject();

            listaRecuperada.forEach(livro -> {
                System.out.println(livro.toString());
            });
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao ler: " + e.getMessage());
        }
    }
}
