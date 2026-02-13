package algoritmos_ordenacao;
import java.util.Arrays;

public class QuickSort {
    /*
[5,2,8,1,7,3,6,4]
└── pivô = 4
    ├── [2,1,3]
    │   └── pivô = 3
    │       ├── [2,1]
    │       │   └── pivô = 1
    │       │       ├── []
    │       │       └── [2]
    │       │       └── concat → [1,2]
    │       └── []
    │       └── concat → [1,2,3]
    └── [5,8,7,6]
        └── pivô = 6
            ├── [5]
            └── [8,7]
                └── pivô = 7
                    ├── []
                    └── [8]
                    └── concat → [7,8]
            └── concat → [5,6,7,8]

└── concat final → [1,2,3,4,5,6,7,8]



    */

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


