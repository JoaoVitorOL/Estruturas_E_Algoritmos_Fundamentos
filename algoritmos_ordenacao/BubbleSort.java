package algoritmos_ordenacao;

import java.util.Arrays;


public class BubbleSort {

    public static void bubbleSort(int[] array) {

        int tamanho = array.length;
        long comparacoes = 0;

        // Controla o número de voltas pelo array
        for (int volta = 0; volta < tamanho - 1; volta++) {


            // Percorre o vetor comparando elementos adjacentes
            for (int indiceatual = 0; indiceatual < tamanho - 1 - volta; indiceatual++) {

                comparacoes ++;
                // Se estiver fora de ordem, troca
                if (array[indiceatual] > array[indiceatual + 1]) {

                    int temp = array[indiceatual];
                    array[indiceatual] = array[indiceatual + 1];
                    array[indiceatual + 1] = temp;
                }
            }
        }
        System.out.println("Comparações: " + comparacoes);


    }


    /* =========================
       MAIN PARA TESTE
       ========================= */
    public static void main(String[] args) {

        int[] dados = LeitorArquivo.carregarArray("algoritmos_ordenacao/numeros_100k.txt");


        long inicio = System.nanoTime();
        bubbleSort(dados);
        long fim = System.nanoTime();
        long duracao = fim - inicio;
        double tempoMs = duracao / 1_000_000.0;
        double tempoS = duracao / 1_000_000_000.0;
        System.out.println("Tempo de execução (ms): " + tempoMs);
        System.out.println("Tempo de execução (s): " + tempoS);


       // System.out.println("Depois da ordenação:");
      //  System.out.println(Arrays.toString(dados));

        // Tempo médio: 15 segundos
        // Comparações: 4999950000


    }
}
