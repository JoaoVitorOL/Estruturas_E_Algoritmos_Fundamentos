package algoritmos_ordenacao;

public class InsertionSort {


    public static void insertionSort(int[] array) {

        int tamanho = array.length;
        long comparacoes = 0;

        // Começa do índice 1, pois o primeiro elemento já é considerado ordenado
        for (int i = 1; i < tamanho; i++) {

            // Elemento que será inserido na parte ordenada
            int marcado = array[i];

            // Índice do último elemento da parte ordenada
            int indiceanterior = i - 1;

            // Desloca os elementos maiores que 'marcado' uma posição à direita
            while (indiceanterior >= 0) {
                comparacoes++; 

                if (array[indiceanterior] > marcado) {
                    array[indiceanterior + 1] = array[indiceanterior];
                    indiceanterior--;
                } else {
                    break;
                }
            }

            // Insere o elemento marcado na posição correta
            array[indiceanterior + 1] = marcado;
        }

        System.out.println("Comparações: " + comparacoes);
    }


    /* =========================
       MAIN PARA TESTE
       ========================= */
    public static void main(String[] args) {

        int[] dados = LeitorArquivo.carregarArray("algoritmos_ordenacao/numeros_100k.txt");


        long inicio = System.nanoTime();
        insertionSort(dados);
        long fim = System.nanoTime();
        long duracao = fim - inicio;
        double tempoMs = duracao / 1_000_000.0;
        double tempoS = duracao / 1_000_000_000.0;
        System.out.println("Tempo de execução (ms): " + tempoMs);
        System.out.println("Tempo de execução (s): " + tempoS);


        // System.out.println("Depois da ordenação:");
        //  System.out.println(Arrays.toString(dados));

        // Tempo médio: 1.74 segundos
        // Comparações: 2.502.930.009

    }
}
