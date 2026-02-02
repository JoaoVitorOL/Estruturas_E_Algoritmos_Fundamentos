package algoritmos_ordenacao;
import java.util.Arrays;

public class MergeSort {

    // Contador global de comparações entre elementos
    private static long comparacoes = 0;

    public static void mergesort(int[] array) {
        // =================================
        //        DIVISÃO DO ARRAY
        // =================================
        if (array.length <= 1) {
            return;
        }

        int divisao = array.length / 2;

        // esquerda <- cópia(array[0 até divisão])
        int[] esquerda = new int[divisao];
        System.arraycopy(array, 0, esquerda, 0, divisao);

        // direita <- cópia(array[divisão até final])
        int[] direita = new int[array.length - divisao];
        System.arraycopy(array, divisao, direita, 0, array.length - divisao);

        // merge_sort(esquerda)
        mergesort(esquerda);

        // merge_sort(direita)
        mergesort(direita);

        // merge(array, esquerda, direita)
        merge(array, esquerda, direita);

    }

    private static void merge(int[] array, int[] esquerda, int[] direita) {

        // =================================
        //    ORDENA ESQUERDA E DIREITA
        // =================================

        // i = j = k = 0
        int indiceesquerda = 0;
        int indicedireita = 0;
        int indicefinal = 0;

        // enquanto i < tamanho(esquerda) E j < tamanho(direita)
        while (indiceesquerda < esquerda.length && indicedireita < direita.length) {

            comparacoes++;

            // se esquerda[i] < direita[j]
            if (esquerda[indiceesquerda] < direita[indicedireita]) {
                array[indicefinal] = esquerda[indiceesquerda];
                indiceesquerda++;
            } else {
                array[indicefinal] = direita[indicedireita];
                indicedireita++;
            }
            indicefinal++;
        }

        // =================================
        //     ORDENAÇÃO FINAL
        // =================================
        // enquanto i < tamanho(esquerda)
        while (indiceesquerda < esquerda.length) {
            array[indicefinal] = esquerda[indiceesquerda];
            indiceesquerda++;
            indicefinal++;
        }

        // enquanto j < tamanho(direita)
        while (indicedireita < direita.length) {
            array[indicefinal] = direita[indicedireita];
            indicedireita++;
            indicefinal++;
        }
    }

    /* =========================
    MAIN PARA TESTE
    ========================= */
    public static void main(String[] args) {

        int[] dados = LeitorArquivo.carregarArray("algoritmos_ordenacao/numeros_100k.txt");

        
        long inicio = System.nanoTime();
        mergesort(dados);
        long fim = System.nanoTime();
        long duracao = fim - inicio;
        double tempoMs = duracao / 1_000_000.0;
        double tempoS = duracao / 1_000_000_000.0;
        System.out.println("Comparações: " + comparacoes);
        System.out.println("Tempo de execução (ms): " + tempoMs);
        System.out.println("Tempo de execução (s): " + tempoS);


        //System.out.println("Depois da ordenação:");
        //System.out.println(Arrays.toString(dados));

        // Tempo médio: 0.0162447 segundos | 16.2447 milésimos
        // Comparações: 1.536.238

    }
}

