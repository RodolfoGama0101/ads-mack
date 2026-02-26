package dev.rodolfo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MinhaCarteiraApplication {

    public static void main(String[] args) {

        List<Transacao> transacaoList = new ArrayList<>();

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
        despesaB.setValor(250.00);
        despesaB.setData(LocalDate.of(2026, 2, 17));

        transacaoList.add(despesaA);
        transacaoList.add(receitaA);
        transacaoList.add(despesaB);

        for (Transacao t : transacaoList) {
            t.exibirDetalhes();

            if (t instanceof Tributavel) {
                System.out.println("Tributos: " + ((Tributavel) t).calcularTributos());
            }
        }
    }
}
