package dev.rodolfo;

public class Principal {

    public static void main(String[] args) {
        CadastroProdutos cadastro = new CadastroProdutos();

        cadastro.adicionarProduto("Computador", 9500.0, 7); // Ok

        cadastro.adicionarProduto("", 249.99, 11); // Nome inválido

        cadastro.adicionarProduto("Memória RAM DDR5", -78.90, 20); // Preço inválido

        cadastro.adicionarProduto("Mouse Logitech", 270.80, -3); // Quantidade inválida

        cadastro.listarProdutos();
    }
}
