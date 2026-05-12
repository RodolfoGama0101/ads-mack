package dev.rodolfo;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// Classe __Aula7_ED: encarregada de executar alguns testes/funcionalidades
// com a estrutura de dados ABB.
// Autores: Ivan Carlos Alcântara de Oliveira e Jean Marcos Laine.

// Autor 2: Rodolfo Figueiredo Gama | 10742570
// Data da Atualização: 11/05/2026

public class _Aula7_ED {

	private static Scanner ler = new Scanner(System.in);

	// armazenaDadosABB(ABB<Veiculo> abb): realiza o cadastro de 15
	// veículos na árvore de busca binária (ABB) abb.

	public static void armazenaDadosABB(ABB<Veiculo> abb) {
		abb.inserir(new Veiculo("FPE5U59", 2021, 105000, "passeio"));
		abb.inserir(new Veiculo("UJP0T10", 2022, 100000, "passeio"));
		abb.inserir(new Veiculo("APK1A21", 2019, 100000, "passeio"));
		abb.inserir(new Veiculo("FAD1P10", 2021, 110000, "passeio"));
		abb.inserir(new Veiculo("PST1B77", 2023, 300000, "carga"));
		abb.inserir(new Veiculo("PAQ1C33", 2024, 440000, "carga"));
		abb.inserir(new Veiculo("FID2T42", 2023, 410000, "carga"));
		abb.inserir(new Veiculo("PAB3Q78", 2023, 210000, "carga"));
		abb.inserir(new Veiculo("CAO4R91", 2023, 180000, "suv"));
		abb.inserir(new Veiculo("FEE6A21", 2023, 150000, "suv"));
		abb.inserir(new Veiculo("DDA5T55", 2024, 160000, "suv"));
		abb.inserir(new Veiculo("PPR9W76", 2023, 190000, "suv"));
		abb.inserir(new Veiculo("AAC8X55", 2019, 210000, "pick_up"));
		abb.inserir(new Veiculo("BAA6F22", 2018, 290000, "pick_up"));
		abb.inserir(new Veiculo("CDD5B34", 2023, 260000, "pick_up"));
	}

	// mostraQuantidadeVeiculos(ABB<Veiculo> abb): método que mostra os 
	//   de veículos de um certo tipo e ano informados/   pelo usuário. O percurso é realizado na árvore abb fornecida.
	//   Faz as buscas enquanto o usuário desejar.
	public static void mostraQuantidadeVeiculos(ABB<Veiculo> abb) {
		System.out.println("Deseja procurar veículos (S/N)?");
		char opcao = ler.next().charAt(0);
		while (opcao == 'S' || opcao == 's') {
			System.out.println("Forneça o ano do veículo: ");
			int ano = Integer.parseInt(ler.next());
			boolean correto = false;
			String tipo = "";
			while (!correto){
				System.out.println("Forneça o tipo do veículo (passeio, suv, carga ou pick_up): ");
				tipo = ler.next();
				if ((tipo.toLowerCase().equals("passeio") ||
						tipo.toLowerCase().equals("suv") ||
						tipo.toLowerCase().equals("carga") ||
						tipo.toLowerCase().equals("pick_up")))
					correto = true;
			}
			System.out.println(String.format("Veículos do ano = %d e tipo = %s", ano, tipo));
			
			// DESCOMENTAR DEPOIS DE IMPLEMENTAR O METODO 
			// System.out.println(abb.veiculosIgualAnoETipo(ano,  tipo));
			
			System.out.println("Deseja continuar a procurar veículos (S/N)?");
			opcao = ler.next().charAt(0);
		}
	}	

	public static void main(String[] args) {
		System.out.println("ABB de objetos da classe Veículo (ordenadas pela Placa):\n");
		ABB<Veiculo> abb = new ABB<Veiculo>();
		armazenaDadosABB(abb);
		abb.emOrdem();  	    	   
		System.out.println("Total de Veículos: " + abb.getSize());


		/* DESCOMENTAR APOS A IMPLEMENTAÇÃO DOS METODOS SOLICITADOS PARA TESTAR A SOLUCAO */

		/* TESTE da Parte I: Quantidade de Veículos com Preço Acima da Média */

	    System.out.println("Total de Veículos com preço maior do que a média: " + abb.qtdeMaiorMediaPrecos());
	    mostraQuantidadeVeiculos(abb);



		/* INCLUIR TESTE da Parte II: Listagem de Veículos por Ano e Tipo
		 * 
		 */




		// Loop para garantir que o usuário insira valores numéricos válidos
		/* TESTE da Parte III: Veículos em Faixa de Preço */


        System.out.println("\n--- Filtrar Veículos por Faixa de Preço ---");
        double precoMin = 0;
        double precoMax = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Digite o preço mínimo desejado: R$ ");
                precoMin = ler.nextDouble(); // Usar nextDouble para ler valores decimais

                System.out.print("Digite o preço máximo desejado: R$ ");
                precoMax = ler.nextDouble();

                if (precoMin < 0 || precoMax < 0) {
                    System.out.println("Erro: Os preços não podem ser negativos. Tente novamente.");
                } else if (precoMin > precoMax) {
                    System.out.println("Erro: O preço mínimo não pode ser maior que o preço máximo. Tente novamente.");
                } else {
                    entradaValida = true; // Saia do loop se a entrada for válida
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, digite um número válido para o preço.");
                ler.next(); // Limpa o buffer do scanner para evitar loop infinito
            }
        }

        // Chama o método filtrarPorFaixaPreco com os valores do usuário
        List<Veiculo> veiculosFiltrados = abb.filtrarPorFaixaPreco(precoMin, precoMax);

        System.out.println(String.format("\nVeículos encontrados com preço entre R$ %.2f e R$ %.2f:", precoMin, precoMax));

        // Verifica se a lista está vazia antes de iterar
        if (veiculosFiltrados.isEmpty()) {
            System.out.println("Nenhum veículo encontrado nessa faixa de preço.");
        } else {
            // Itera sobre a lista e imprime os veículos encontrados
            for (Veiculo veiculo : veiculosFiltrados) {
            // Imprime usando o toString() da classe Veiculo, que já está formatado
                System.out.print(veiculo); // O toString já inclui a quebra de linha (\n)
            }
            System.out.println("Total de veículos encontrados na faixa: " + veiculosFiltrados.size());
        }

		System.out.println("\nFim da execução.");
		ler.close(); // Boa prática: fechar o Scanner ao final
	}
}
