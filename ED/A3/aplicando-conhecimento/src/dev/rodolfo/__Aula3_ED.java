package dev.rodolfo;

import java.util.Scanner;
import java.util.Arrays;

//Classe __Aula3_ED: encarregada de executar algumas funcionalidades
//com objetos do tipo Candidato a um concurso musical armazenados em um vetor
//Autores: Jean Marcos Laine e Ivan Carlos Alcântara de Oliveira.


public class __Aula3_ED {
    // Objeto de leitura
    private Scanner ler = new Scanner(System.in); 
    // constante com o total de candidatos
    public static final int MAX_CANDIDATOS = 15;
    // main: ponto de entrada do programa
    public static void main(String[] args) {
        // Cria objeto da Classe com a 
        // execução das funcionalidades solicitadas
        new __Aula3_ED();  
    }

    // Construtor da classe encarregada de realizar a execução
    // das funcionalidades solicitadas
    public __Aula3_ED() {
        // Vetor de Candidatos
        Candidato candidatos[];
        // Cria vetor de objetos do tipo Candidato para 
        // uso nos métodos de ordenação e pesquisa
        candidatos = new Candidato[MAX_CANDIDATOS];
        
        // Cria lista de candidatos
        criarCadastroCandidatos(candidatos);
        // Mostra todos os candidatos cadastrados na ordem do cadastro
        mostrarTodosOsCandidatos(candidatos);
        
        // Criar aqui as cópias do vetor original para ordenação nos métodos InsertionSort e SelectionSort
		// Verificar o exemplo no texto
		
        
        // Procura um candidato pelo nome em um vetor não ordenado
        System.out.println("Forneça o nome do candidato: ");
        String nomeCandidato = ler.nextLine();
        Candidato cand = pesquisaSequencial(nomeCandidato, candidatos);
        if (cand != null) {
            System.out.println("Dados Candidato: " + cand.toString());
        } else {
            System.out.println("Candidato Inexistente!");
        }
        
        
        // Ordena o vetor de candidatos pelo nome do candidato
        bubbleSort(candidatos);
        // Mostra os candidatos ordenados por nome
		
        System.out.println("\nApós ordenação");
        mostrarTodosOsCandidatos(candidatos);
        
        
        // Procura um candidato no vetor ordenado pelo número do candidato 
        cand = pesquisaBinaria(nomeCandidato, candidatos);
        if (cand != null) {
            System.out.println("Dados Candidato: " + cand.toString());
        } else {
            System.out.println("Candidato Inexistente!");
        }
       
        Candidato[] candidatosInsertionSort = Arrays.copyOf(candidatos, candidatos.length);
        Candidato[] candidatosSelectionSort = Arrays.copyOf(candidatos, candidatos.length);

        // Ordena o vetor de candidatos pela idade do candidato
        insertionSort(candidatosInsertionSort);
        // Mostra os candidatos ordenados por idade
       // mostrarTodosOsCandidatos(candidatos);
       
        // Ordena o vetor de candidatos pelo número do candidato
        selectionSort(candidatosSelectionSort);
        // Mostra os candidatos ordenados por número do candidato
       // mostrarTodosOsCandidatos(candidatos);
    }
    
    // Método encarregado de criar objetos da classe Candidato
    // e armazenar em um vetor.
    // Este método foi criado para evitar a necessidade de 
    // fazer a leitura de dados de Candidato na fase de testes dos outros 
    // métodos a serem modificados.    
    public void criarCadastroCandidatos(Candidato[] candidatos) {    
        candidatos[0] = new Candidato(1111, "111.111.111-11", "Leonardo", 18, 'M', "rock");
        candidatos[1] = new Candidato(8888, "888.888.888-88", "Luiza", 21, 'F', "romantica");
        candidatos[2] = new Candidato(7777, "777.777.777-77", "Pedro", 22, 'M', "rock");
        candidatos[3] = new Candidato(6666, "666.666.666-66", "Ana Lopes", 54, 'F', "sertanejo");
        candidatos[4] = new Candidato(3333, "333.333.333-33", "Mariana", 25, 'F', "sertanejo");
        candidatos[5] = new Candidato(4444, "444.444.444-44", "Amilton", 35, 'M', "rock");
        candidatos[6] = new Candidato(2222, "222.222.222-22", "Juliano", 19, 'M', "forró");    
        candidatos[7] = new Candidato(5555, "555.555.555-55", "Luciano", 52, 'M', "forró");
        candidatos[8] = new Candidato(1010, "101.101.101-10", "Christiane", 35, 'F', "rock");    
        candidatos[9] = new Candidato(9999, "999.999.999-99", "Luis Alberto C.", 18, 'M', "rap");
        candidatos[10] = new Candidato(1212, "121.212.121-21", "Beatriz Ramos", 29, 'F', "pop");
        candidatos[11] = new Candidato(1313, "131.313.131-31", "Ricardo Souza", 42, 'M', "jazz");
        candidatos[12] = new Candidato(1414, "141.414.141-41", "Fernanda Lima", 31, 'F', "mpb");
        candidatos[13] = new Candidato(1515, "151.515.151-51", "Gustavo Henrique", 24, 'M', "eletronica");
        candidatos[14] = new Candidato(1616, "161.616.161-16", "Camila Castro", 27, 'F', "indie");
    }
  
        
    // Método que apresenta todos os dados dos candidatos cadastrados.
    // Se houver candidatos exibe a mensagem:
    //    "Candidatos cadastrados:", seguido dos seus dados um por linha.
    // Caso não haja Candidatos cadastrados mostra a mensagem: "Não há candidatos cadastrados!"
    public void mostrarTodosOsCandidatos(Candidato[] cand) {
        String cad = "";
        for(int i=0; i<cand.length; i++) {
            cad += cand[i].toString() + "\n";
        }
        if (cand.length >= 1)
           System.out.println("\nCandidatos cadastrados:\n" + cad);  
        else 
           System.out.println("Não há Candidatos cadastrados!");
    }
    
    
    // Método encarregado de pesquisar um candidato 
    // armazenado em um vetor (ordenado ou não)
    // tendo como chave o nome do candidato.    
    public Candidato pesquisaSequencial(String nomeCandidato, Candidato[] cand) {
        int comparacoes = 0; // Contador de comparações

        for (int i = 0; i < cand.length; i++) {
            comparacoes++;
            if (cand[i].getNome().equals(nomeCandidato)) {
                System.out.println("Pesquisa Sequencial - Total de comparações: " + comparacoes);

                return cand[i];
            }
        }

        System.out.println("Pesquisa Sequencial - Total de comparações: " + comparacoes);

        return null;
    }
    
    // Método encarregado de pesquisar um candidato 
    // armazenado em um vetor ordenado
    // Método de pesquisa binária por nome do candidato
    public Candidato pesquisaBinaria(String nomeCandidato, Candidato[] cand) {

        int inf = 0;
        int sup = cand.length - 1;
        int comparacoes = 0;

        while (inf <= sup) {
            comparacoes++;

            int meio = (inf + sup) / 2;

            int resultadoComp = cand[meio].getNome().compareToIgnoreCase(nomeCandidato);

            if (resultadoComp == 0) {
                System.out.println("Busca binária - Total de comparações: " + comparacoes);

                return cand[meio];
            } else if (resultadoComp < 0) {
                inf = meio + 1;
            } else {
                sup = meio - 1;
            }
        }

        System.out.println("Busca binária - Total de comparações: " + comparacoes);
        return null;
    }
    

    // Método encarregado de ordenar os Candidatos 
    // armazenados em um vetor pelo número do candidato.
    public void selectionSort(Candidato cand[]) {
        System.out.println("# Selection Sort");

        int j, min;
        Candidato aux;
        int contagem = 0;

        for (int i = 0; i < cand.length -1; i++) {
            min = 1;

            for (j = i; j < cand.length; j++) {
                if (cand[j].getNumero_candidato() < cand[min].getNumero_candidato()) {
                    min = j;

                    if (i != min) {
                        aux = cand[i];
                        cand[i] = cand[min];
                        cand[min] = aux;

                        contagem++;
                    }
                }
            }
        }

        System.out.println("Número de trocas realizadas na operação: " + contagem);
    }
 
    // Método encarregado de ordenar os Candidatos 
    // armazenados em um vetor pela idade do candidato.
    public void insertionSort(Candidato[] cand) {
        System.out.println("# Insertion Sort");

        int j;
        Candidato aux;
        int contagem = 0;

        for (int i = 1; i < cand.length; i++) {
            aux = cand[i];

            for (j = i - 1; j >= 0 && aux.getNumero_candidato() > cand[j].getNumero_candidato(); j--) {
                cand[j + 1] = aux;

                contagem++;
            }
        }

        System.out.println("Número de trocas realizadas na operação: " + contagem);
    }

    // Método encarregado de ordenar os Candidatos 
    // armazenados em um vetor pelo nome do candidato.
    public void bubbleSort(Candidato[] cand) {
        System.out.println("# Bundle Sort");

        Candidato temp;
        int contagem = 0;

        for (int i = 0; i < cand.length; i++) {
            for (int j = 1; j < cand.length - i; j++) { // O "- i" otimiza, pois o maior já "flutua" para o fim

                // Comparação alfabética entre o nome da posição anterior e a atual
                // Se o resultado for > 0, significa que cand[j-1] vem DEPOIS de cand[j]
                if (cand[j - 1].getNome().compareToIgnoreCase(cand[j].getNome()) > 0) {
                    // Realiza a troca (swap)
                    temp = cand[j - 1];
                    cand[j - 1] = cand[j];
                    cand[j] = temp;

                    contagem++;
                }
            }
        }

        System.out.println("Número de trocas realizadas na ordenação por nome: " + contagem);
    }
}