package estruturas_de_dados;
import java.util.Arrays;


public class Fila {

    private  short inicio;
    private short fim;
    private short elementos;
    private short capacidade;
    private short[] fila;

    public Fila(short capacidade) {   //   CONSTRUTOR
        this.capacidade = capacidade;
        this.fila = new short[capacidade];
        this.inicio = 0;
        this.fim = -1;
        this.elementos = 0;
    }


// ===================== AUXILIARES ==================================================
    private boolean cheia() { return elementos == capacidade;}

    private boolean vazia() { return elementos == 0; }



// ===================== ENFILEIRAR==================================================
    private void enfileirar(short valor) {

        if (cheia()) {
            System.out.println("Fila cheia");
            return;
        }

        if (fim == capacidade - 1) 
           { fim = -1 ;} // Cirularidade da fila. (Volta ao início se chegou no fim do array)

        fim++;
        fila[fim] = valor;
        elementos++;

    }


// ===================== DESENFILEIRAR==================================================
    private short desenfileirar() {
        if (vazia()) {
            System.out.println("Fila vazia");
            return -1;
        }

         short temp = fila[inicio];
        inicio++;

        if (inicio == capacidade) { // circularidade da fila.  (Volta ao início se chegou no fim do array)
            inicio = 0;
        }

        elementos--;
        return temp;
    }


// ===================== INÌCIO==================================================
    private short verInicio() {
        if (vazia()) {
            System.out.println("Fila vazia");
            return -1;
        }
        return fila[inicio];
    }


    public static void main(String[] args) { // MAIN FUNCTION
        Fila f = new Fila((short) 5);

        System.out.println("=== TESTE 1: ENFILEIRAR NORMAL ===");
        f.enfileirar((short) 10);
        f.enfileirar((short) 20);
        f.enfileirar((short) 30);
        System.out.println(Arrays.toString(f.fila));  // Deve mostrar [10, 20, 30, 0, 0]

        System.out.println("\n=== TESTE 2: VER INÍCIO ===");
        System.out.println("Início esperado = 10 | obtido = " + f.verInicio());

        System.out.println("\n=== TESTE 3: DESENFILEIRAR NORMAL ===");
        System.out.println("Removeu: " + f.desenfileirar()); // 10
        System.out.println("Removeu: " + f.desenfileirar()); // 20
        System.out.println(Arrays.toString(f.fila));  // Conteúdo antigo ainda aparece, mas é ignorado

        System.out.println("\n=== TESTE 4: CIRCULARIDADE (fim volta ao início) ===");
        f.enfileirar((short) 40);
        f.enfileirar((short) 50);
        f.enfileirar((short) 60);
        System.out.println(Arrays.toString(f.fila));

        System.out.println("\n=== TESTE 5: Fila cheia ===");
        f.enfileirar((short) 70);  // Deve avisar 'Fila cheia'

        System.out.println("\n=== TESTE 6: Desenfileirar até circular para início ===");
        System.out.println("Removeu: " + f.desenfileirar());
        System.out.println("Removeu: " + f.desenfileirar());
        System.out.println("Removeu: " + f.desenfileirar());
        System.out.println(Arrays.toString(f.fila));

        System.out.println("\n=== TESTE 7: Ver início com fila vazia ===");
        System.out.println("Resultado: " + f.verInicio());

        System.out.println("\n=== TESTE 8: Desenfileirar com fila vazia ===");
        System.out.println("Removeu: " + f.desenfileirar()); // -1

    }

}
