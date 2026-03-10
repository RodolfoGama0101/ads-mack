package dev.rodolfo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

//Classe _Aula2_ED: encarregada de executar algumas funcionalidades
//                  com objetos do tipo Veículos armazenados em ArrayList
//Autores: Ivan Carlos Alcântara de Oliveira e Jean Marcos Laine.

public class _Aula2_ED {
	
	    private ArrayList<Veiculo> veic = new ArrayList(); // Inicia o ArrayList
	    private Scanner ler = new Scanner(System.in); // Objeto de leitura
        DecimalFormat df = new DecimalFormat("0.00");

    // Método de entrada do programa
	    public static void main(String[] args) {
	    	_Aula2_ED loja = new _Aula2_ED();
	        System.exit(0);
	    }
	    
	    // Construtor da classe _Aula2_ED
	    // Encarregado de executar as funcionalidades envolvendo  
	    // objetos da classe Veículo
	    public _Aula2_ED() {
	        simularLeituraDeDados();
	        System.out.println("Resultados: \n");
	        mediaPrecosCaminhoesVendidos();
	        veiculoMaisCaroMaisBarato();
	        mediaPrecosDeUmTipoDeVeiculo();
	        listarTodosOsVeiculosDaLoja();
		contarVeiculosPorTipo();
	    }
	    
	    // Método encarregado de criar objetos da classe Veículo
	    // e armazenar em um ArrayList.
	    // Este método foi criado para evitar a necessidade de 
	    // fazer a leitura de Veículos na fase de testes dos outros ´
	    // métodos a serem desenvolvidos.
		public void simularLeituraDeDados() {
		    veic.add(new Veiculo("ABC-1L34","Honda","GL 1800", 2023, 150000f,"moto")); 
		    veic.add(new Veiculo("DEF-2K45","Volvo","Scania X", 2015, 179000f,"caminhão"));
		    veic.add(new Veiculo("EDF-1P34","Audi","A4", 2019, 234000f,"carro")); 
		    veic.add(new Veiculo("FGE-2A45","Ford","Focus", 2018, 89000f,"carro")); 
		    veic.add(new Veiculo("ABD-1B34","Fiat","Track Gls", 2022, 112000f,"carro")); 
		    veic.add(new Veiculo("DGF-2C45","Volvo","Scania X", 2024, 220000f,"caminhão"));
		    veic.add(new Veiculo("FGP-2M45","Ford","Focus", 2021, 120000f,"carro")); 
		    veic.add(new Veiculo("ABC-1234","Honda","GL 1000", 2024, 140000f,"moto")); 
		    veic.add(new Veiculo("AEF-2Q45","Volvo","Scania X", 2019, 195000f,"caminhão"));
		    veic.add(new Veiculo("IGN-1W45","Ford","Focus", 2020, 110000f,"carro")); 
		}

	// Método que calcula e apresenta a média de preços dos caminhões
	// Se houver caminhões no ArrayList de Veículos exibe a mensagem:
	//  "Médias dos preços dos caminhões: R$ ", com duas casas decimais para a média.
	// Caso não haja caminhões mostra a mensagem: "Não existem caminhões na loja"
	public void mediaPrecosCaminhoesVendidos() {
	    // Devenvolver o código Java que realiza o apresentado nos comentários acima.

        if (veic.isEmpty()) {
            System.out.println("Erro: Lista vazia");
            return;
        }

        int qtdCaminhoes = 0;
        float soma = 0;

        for (int i = 0; i < veic.toArray().length; i++) {

            Veiculo veiculo = veic.get(i);
            if (veiculo.getTipo().equals("caminhão")) {
                qtdCaminhoes++;
                soma += veiculo.getPreco();
            }
        }

        if (qtdCaminhoes <= 0) {
            System.out.println("Não existem caminhões na loja");
            return;
        }

        System.out.println("Médias dos preços dos caminhões: R$ " + df.format(soma / qtdCaminhoes));
    }


	// Método que procura e apresenta o veículo mais caro e mais barato dentro do ArrayList
	// Se houver Veículos, após a busca, exibe a mensagem:
	//  "Mais caro: " + <DADOS DO VEÍCULO>
    //  "Mais barato: " + <DADOS DO VEÍCULO>
	// Caso não haja veículos cadastrados, mostra a mensagem: "Não há veículos cadastrados!"
	public void veiculoMaisCaroMaisBarato() {
	    // Devenvolver o código Java que realiza o apresentado nos comentários acima.

        Veiculo veiculoMaiorPreco = veic.getFirst();
        Veiculo veiculoMenorPreco = veic.getFirst();

        if (veic.isEmpty()) {
            System.out.println("Não há veículos cadastrados!");
        }

        for (int i = 0; i < veic.toArray().length; i++) {
            Veiculo veiculo = veic.get(i);

            if (veiculo.getPreco() > veiculoMaiorPreco.getPreco()) {
                veiculoMaiorPreco = veiculo;
            }

            if (veiculo.getPreco() <= veiculoMenorPreco.getPreco()) {
                veiculoMenorPreco = veiculo;
            }
        }

        System.out.println("Mais caro: " + veiculoMaiorPreco.toString());
        System.out.println("Mais barato: " + veiculoMenorPreco.toString());
	}

	// Método que calcula e apresenta a média de preços de um tipo de veículo (carro, caminhão ou moto)
	// fornecido pelo usuário.
	// Se houver veículos no ArrayList de Veículos exibe a mensagem:
	//  "Médias dos preços dos veículos do tipo " + <TIPO DO VÉICULO> + ": R$ ", com duas casas decimais para a média.
	// Caso não haja veículos do tipo solicitado, mostra a mensagem: "Não existem veículos desse tipo na loja"	
	public void mediaPrecosDeUmTipoDeVeiculo() {
	    // Devenvolver o código Java que realiza o apresentado nos comentários acima.

        System.out.println("Digite o tipo de veículo (carro, moto, caminhão) que deseja analizar: ");
        String tipo = ler.nextLine();

        int qtd = 0;
        float soma = 0f;

        for (int i = 0; i < veic.toArray().length; i++) {
            Veiculo veiculo = veic.get(i);

            if (veiculo.getTipo().equals(tipo)) {
                soma += veiculo.getPreco();
                qtd++;
            }
        }

        if (qtd <= 0) {
            System.out.println("Não existem veículos desse tipo na loja");
            return;
        }

        System.out.println("Médias dos preços dos veículos do tipo " + tipo.toUpperCase() + ": R$ " + df.format(soma / qtd));

        ler.close();
	}

	// Método que apresenta todos os dados dos veículos cadastrados.
	// Se houver veículos no ArrayList exibe a mensagem:
	//    "Veículos cadastrados:", seguido dos dados dos veículos um por linha.
	// Caso não haja veículos cadastrados mostra a mensagem: "Não há veículos cadastrados!"
	public void listarTodosOsVeiculosDaLoja() {
	    // Devenvolver o código Java que realiza o apresentado nos comentários acima.

        System.out.println("Veículos cadastrados: ");

        for (int i = 0; i < veic.toArray().length; i++) {
            Veiculo veiculo = veic.get(i);

            System.out.println(veiculo.toString());
        }
	}

	//Método que conta os veículos por tipo e apresenta o resultado
	public void contarVeiculosPorTipo() {
	    // Devenvolver o código Java que realiza o apresentado nos comentários acima.

        ArrayList<String> tipos = new ArrayList<>();
        tipos.add("carro");
        tipos.add("moto");
        tipos.add("caminhão");

        System.out.println("Contagem de veículos por tipo: ");

        for (String tipo : tipos) {

            int qtd = 0;

            for (int i = 0; i < veic.toArray().length; i++) {
                Veiculo veiculo = veic.get(i);

                if (veiculo.getTipo().equals(tipo)) {
                    qtd++;
                }
            }

            System.out.println(tipo.toUpperCase() + ": " + qtd);
        }
	}
}
