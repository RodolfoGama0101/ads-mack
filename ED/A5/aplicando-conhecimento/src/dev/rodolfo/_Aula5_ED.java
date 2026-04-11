package dev.rodolfo;

/**
 * Classe _Aula5_ED: Responsável por testar e demonstrar funcionalidades
 * da estrutura de dados Fila Circular com objetos do tipo Imóvel.
 *
 * Autores: Ivan Carlos Alcântara de Oliveira e Jean Marcos Laine
 * Autor 2: <Rodolfo Figueiredo Gama | 10742570>
 * @version 1.1
 * @since  / /2025
 */

public class _Aula5_ED {
    /**
     * Preenche a fila circular com 10 imóveis pré-cadastrados.
     *
     * @param f Fila circular que será populada com os imóveis
     * @throws Exception Se ocorrer erro ao inserir na fila
     */

    public static void bancoDeDados(FilaCircular<Imovel> f) throws Exception {
        f.enqueue(new Imovel(1, 1998, 'C', 2000000.0f, 450.0f));
        f.enqueue(new Imovel(2, 2005, 'S', 10000000.0f, 700.0f));
        f.enqueue(new Imovel(3, 2008, 'A', 500000.0f, 80.0f));
        f.enqueue(new Imovel(4, 2012, 'F', 33000000.0f, 2000.0f));
        f.enqueue(new Imovel(5, 2000, 'S', 20000000.0f, 800.0f));
        f.enqueue(new Imovel(6, 2024, 'A', 400000.0f, 45.0f));
        f.enqueue(new Imovel(7, 2021, 'F', 8000000.0f, 1000.0f));
        f.enqueue(new Imovel(8, 2001, 'A', 450000.0f, 50.0f));
        f.enqueue(new Imovel(9, 1999, 'C', 500000.0f, 80.0f));
        f.enqueue(new Imovel(10, 2016, 'C', 1000000.0f, 100.0f));
    }

    /**
     * Remove todos os imóveis de um determinado tipo da fila,
     * mantendo a ordem dos elementos restantes.
     *
     * @param f Fila circular de imóveis
     * @param tipo Tipo do imóvel a ser removido (C, S, A, F)
     * @throws Exception Se ocorrer erro durante a remoção
     */

    public static void removeImovel(FilaCircular<Imovel> f, char tipo) throws Exception {
        int tamanhoOriginal = f.size();

        for (int i = 0; i < tamanhoOriginal; i++) {
            Imovel atual = f.dequeue();

            if (atual.getTipo() != tipo) {
                f.enqueue(atual);
            }
        }
    }

    /**
     * Exibe imóveis com ano de construção igual ou superior ao especificado
     * e área maior que a informada.
     *
     * @param f Fila circular de imóveis
     * @param anoDeConstrucao Ano mínimo de construção para filtro
     * @param area Área mínima requerida para exibição
     * @throws Exception Se ocorrer erro durante a operação
     */

    public static void exibeImovelAnoArea(FilaCircular<Imovel> f, int anoDeConstrucao, float area) throws Exception {
        int tamanhoOriginal = f.size();

        for (int i = 0; i < tamanhoOriginal; i++) {
            Imovel atual = f.dequeue();

            if (atual.getAnoDeConstrucao() >= anoDeConstrucao && atual.getArea() > area) {
                System.out.println(atual);
            }

            f.enqueue(atual);
        }
    }


    /**
     * Exibe imóveis com ano de construção anterior ao especificado
     * e preço menor que o valor informado.
     *
     * @param f Fila circular de imóveis
     * @param anoDeConstrucao Ano máximo de construção para filtro
     * @param preco Valor máximo de preço para exibição
     * @throws Exception Se ocorrer erro durante a operação
     */

    public static void exibeImovelAnoPreco(FilaCircular<Imovel> f, int anoDeConstrucao, float preco) throws Exception {
        int tamanhoOriginal = f.size();

        for (int i = 0; i < tamanhoOriginal; i++) {
            Imovel atual = f.dequeue();

            if (atual.getAnoDeConstrucao() < anoDeConstrucao && atual.getPreco() < preco) {
                System.out.println(atual);
            }

            f.enqueue(atual);
        }
    }

    /**
     * Ordena os imóveis da fila circular em ordem crescente de preço e imprime.
     *
     * @param f Fila circular contendo os imóveis a serem ordenados
     * @throws Exception Se a fila estiver vazia, contiver elementos nulos ou ocorrerem erros de manipulação
     */

    public static void ordenarImoveisPorPreco(FilaCircular<Imovel> f) throws Exception {
        int tamanho = f.size();
        if (tamanho == 0) return;

        Imovel[] vetorTemp = new Imovel[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetorTemp[i] = f.dequeue();
        }

        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - 1 - i; j++) {
                if (vetorTemp[j].getPreco() > vetorTemp[j + 1].getPreco()) {
                    Imovel aux = vetorTemp[j];
                    vetorTemp[j] = vetorTemp[j + 1];
                    vetorTemp[j + 1] = aux;
                }
            }
        }

        System.out.println("[Fila ordenada por preço]:");
        for (int i = 0; i < tamanho; i++) {
            f.enqueue(vetorTemp[i]);
            System.out.println(vetorTemp[i]);
        }
    }


    // Método main que testa todas as funcionalidades desta atividade.
    public static void main(String[] args) {
        try {
            FilaCircular<Imovel> f = new FilaCircular<Imovel>();
            bancoDeDados(f);
            System.out.println(f);
            System.out.println("\nAno >= 2000 e Area > 300m2");
            exibeImovelAnoArea(f, 2000, 300.0f);
            System.out.println("\nAno < 2023 e Preço < R$ 10.000.000,00");
            exibeImovelAnoPreco(f, 2023, 10000000.0f);
            System.out.println("\nFila após a remoção dos imóveis tipo 'C' (casa):");
            removeImovel(f, 'C');
            System.out.println(f);
            System.out.println("\nApós ordenar imóveis por preço:");
            ordenarImoveisPorPreco(f);
        } catch(Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
