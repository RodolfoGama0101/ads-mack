package dev.rodolfo.aplicandoconhecimento;

import dev.rodolfo.aplicandoconhecimento.model.Despesa;
import dev.rodolfo.aplicandoconhecimento.model.Receita;
import dev.rodolfo.aplicandoconhecimento.model.Transacao;
import dev.rodolfo.aplicandoconhecimento.model.Tributavel;
import dev.rodolfo.aplicandoconhecimento.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class MinhaCarteiraApplication implements CommandLineRunner {

    @Autowired
    private TransacaoRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(MinhaCarteiraApplication.class, args);
    }

    @Override
    public void run(String... args) {
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

            // Substituindo o DAO pelo Repository do Spring Data JPA
            repository.save(despesaA);
            repository.save(receitaA);
            repository.save(despesaB);
            
            System.out.println("-> Transações salvas com sucesso via Hibernate!");

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println("\n=== LISTANDO DADOS ATUALIZADOS DO BANCO ===");
        List<Transacao> lista = repository.findAll();
        
        if (lista.isEmpty()) {
            System.out.println("Nenhuma transação encontrada no banco.");
        } else {
            for (Transacao t : lista) {
                t.exibirDetalhes();
                if (t instanceof Tributavel) {
                    System.out.println("Tributos: " + ((Tributavel) t).calcularTributos());
                }
            }
        }
    }
}