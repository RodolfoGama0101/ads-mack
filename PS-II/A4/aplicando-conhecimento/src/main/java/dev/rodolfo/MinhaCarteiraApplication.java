package dev.rodolfo;

import dev.rodolfo.exception.ValorInvalidoException;
import java.time.LocalDate;
import java.util.List;

public class MinhaCarteiraApplication {

    static void main(String[] args) {

        TransacaoDAO dao = new TransacaoDAO();

        System.out.println("=== BUSCANDO DADOS INICIAIS DO BANCO ===");
        exibirLista(dao.listar());

        System.out.println("\n=== SALVANDO NOVAS TRANSAÇÕES NO BANCO ===");
        try {
            Despesa despesaA = new Despesa();
            despesaA.setDescricao("Financiamento Carro");
            despesaA.setValor(1237.09);
            despesaA.setData(LocalDate.of(2026, 2, 3));

            Receita receitaA = new Receita();
            receitaA.setDescricao("Salário");
            receitaA.setValor(5000.00);
            receitaA.setData(LocalDate.of(2026, 2, 1));

            Despesa despesaB = new Despesa();
            despesaB.setDescricao("Jantar Restaurante");
            despesaB.setValor(150.00);
            despesaB.setData(LocalDate.of(2026, 2, 17));

            dao.salvar(despesaA);
            dao.salvar(receitaA);
            dao.salvar(despesaB);
            System.out.println("-> Transações salvas com sucesso!");

        } catch (ValorInvalidoException | IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println("\n=== LISTANDO DADOS ATUALIZADOS DO BANCO ===");
        exibirLista(dao.listar());
    }

    private static void exibirLista(List<Transacao> lista) {
        if (lista.isEmpty()) {
            System.out.println("Nenhuma transação encontrada no banco.");
            return;
        }

        for (Transacao t : lista) {
            t.exibirDetalhes();

            if (t instanceof Tributavel) {
                System.out.println("Tributos: " + ((Tributavel) t).calcularTributos());
            }
        }
    }
}