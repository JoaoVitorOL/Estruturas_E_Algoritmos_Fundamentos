package estruturas_de_dados;

public class Recursao {

    /* =========================
       EXEMPLO 1 – FATORIAL
       ========================= */
    public static int fatorial(int n) {

        // Caso base
        if (n == 0 || n == 1) {
            return 1;
        }

        // Passo recursivo
        return n * fatorial(n - 1);
    }


    /* =========================
       EXEMPLO 2 – SOMA DOS N PRIMEIROS INTEIROS
       ========================= */
    public static int soma(int n) {

        // Caso base
        if (n == 1) {
            return 1;
        }

        // Passo recursivo
        return n + soma(n - 1);
    }


    /* =========================
       EXEMPLO 3 – FIBONACCI
       ========================= */
    public static int fibonacci(int num) {

        // Caso base
        if (num <= 1) {
            return num;
        }

        // Passo recursivo
        return fibonacci(num - 1) + fibonacci(num - 2);
    }


    /* =========================
       EXEMPLO PRÁTICO – CONTAR MOEDAS
       ========================= */
    public static int contarMoedas(int[] lista, int posicao) {

        // Caso base: chegou ao final da lista
        if (posicao == lista.length) {
            return 0;
        }

        // Passo recursivo
        if (lista[posicao] == 1) {
            return 1 + contarMoedas(lista, posicao + 1);
        } else {
            return contarMoedas(lista, posicao + 1);
        }
    }


    /* =========================
       MAIN PARA TESTES
       ========================= */
    public static void main(String[] args) {

        System.out.println("=== FATORIAL ===");
        System.out.println("5! = " + fatorial(5));   // esperado: 120
        System.out.println("1! = " + fatorial(1));   // esperado: 1
        System.out.println("0! = " + fatorial(0));   // esperado: 1

        System.out.println("\n=== SOMA DOS N PRIMEIROS INTEIROS ===");
        System.out.println("soma(5) = " + soma(5));  // esperado: 15
        System.out.println("soma(1) = " + soma(1));  // esperado: 1

        System.out.println("\n=== FIBONACCI ===");
        for (int i = 0; i <= 7; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        // esperado: 0 1 1 2 3 5 8 13

        System.out.println("\n\n=== CONTAR MOEDAS ===");
        int[] moedas = {1, 0, 1, 1, 0, 1, 0, 1};

        int total = contarMoedas(moedas, 0);
        System.out.println("Total de moedas: " + total); // esperado: 5
    }
}
