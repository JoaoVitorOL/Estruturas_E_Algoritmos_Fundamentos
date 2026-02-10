package algoritmos_ordenacao;
import java.util.Arrays;

public class QuickSort {

    private static long comparacoes = 0;

    // =================================
    //        PARTIÇÃO DO ARRAY
    // =================================
    public static int particao(int[] array, int inicio, int fim) {

        int pivo = array[fim];
        int i = inicio - 1; // marca a ÚLTIMA posição que contém um valor ≤ pivô

        for (int j = inicio; j < fim; j++) {

            comparacoes++; // comparação array[j] <= pivo

            if (array[j] <= pivo) {
                i++;

                int temp = array[i]; // Swap que garante que Tudo que está em array[inicio..i] é ≤ pivô
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1]; // Colocação final do pivô
        array[i + 1] = array[fim];
        array[fim] = temp;

        return i + 1;
    }

    // =================================
    //        QUICK SORT
    // =================================
    public static void quickSort(int[] vetor, int inicio, int fim) {

        if (inicio < fim) { // Condição de parada da recursão (Se o subarray tem 0 ou 1 elemento Ele já está ordenado A função retorna imediatamente)

            int posicao = particao(vetor, inicio, fim);

            quickSort(vetor, inicio, posicao - 1);
            quickSort(vetor, posicao + 1, fim);
        }
    }


    /* =========================
         MAIN PARA TESTE
========================= */
    public static void main(String[] args) {

        int[] dados = LeitorArquivo.carregarArray(
                "algoritmos_ordenacao/numeros_100k.txt"
        );

        long inicio = System.nanoTime();

        quickSort(dados, 0, dados.length - 1);

        long fim = System.nanoTime();

        double tempoMs = (fim - inicio) / 1_000_000.0;
        double tempoS = (fim - inicio) / 1_000_000_000.0;

        System.out.println("Comparações: " + comparacoes);
        System.out.println("Tempo (ms): " + tempoMs);
        System.out.println("Tempo (s): " + tempoS);

         System.out.println(Arrays.toString(dados));
        // Tempo médio: 0.013021701 segundos | 13.021701 milésimos
        // Comparações: 1.984.094
    }
}
