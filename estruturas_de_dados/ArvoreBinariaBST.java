
package estruturas_de_dados;
import java.util.Arrays;

class ArvoreBinariaBST {

    private No raiz;


    public ArvoreBinariaBST() {
        this.raiz = null;
    }


    //=======================================================================
    //                   INSERIR
    //=======================================================================
    public void inserir(short valor) {

        No novo = new No(valor);

        // Caso 1: árvore vazia
        if (raiz == null) {
            raiz = novo;
            return;
        }

        No atual = raiz; // nó que está sendo analisado naquele momento da descida na árvore
        No pai = null; // guarda onde você estava antes de avançar

        // Percorre a árvore
        while (true) {
            pai = atual; // Salva o nó anterior antes de andar (necessário para ligar o novo nó depois)

            // esquerda
            if (valor < atual.getValor()) {
                atual = atual.getEsquerda(); // Desce um nível à esquerda

                if (atual == null) {
                    pai.setEsquerda(novo);
                    return;
                }

                // direita
            } else {
                atual = atual.getDireita();

                if (atual == null) {
                    pai.setDireita(novo);
                    return;
                }
            }
        }
    }

    //=======================================================================
    //                   PESQUISAR
    //=======================================================================
    public No pesquisar(short valor) {

        No atual = raiz;

        while (atual != null) {

            if (valor == atual.getValor()) {
                return atual;
            }

            if (valor < atual.getValor()) {
                atual = atual.getEsquerda();
            } else {
                atual = atual.getDireita();
            }
        }

        return null; // não encontrado
    }

    //=======================================================================
    //                   PRÉ-ORDEM ( Raiz, esquerda, direita )
    //=======================================================================

    public void preOrdem (No no) {
        if (no != null) {

            System.out.print(no.getValor() + " "); // 1️⃣ RAIZ
            preOrdem(no.getEsquerda());            // 2️⃣ ESQUERDA
            preOrdem(no.getDireita());             // 3️⃣ DIREITA
        }
    }

    //=======================================================================
    //                   EM ORDEM (Esquerda → Raiz → Direita)
    //=======================================================================
    public void emOrdem(No no) {
        if (no != null) {
            emOrdem(no.getEsquerda());                 // 1️⃣ ESQUERDA
            System.out.print(no.getValor() + " ");     // 2️⃣ RAÍZ
            emOrdem(no.getDireita());                  // 3️⃣ DIREITA
        }
    }

    //=======================================================================
    //                   PÓS-ORDEM (Esquerda → Direita → Raiz)
    //=======================================================================
    public void posOrdem(No no) {
        if (no != null) {
            posOrdem(no.getEsquerda());                // 1️⃣ ESQUERDA
            posOrdem(no.getDireita());                 // 2️⃣ DIREITA
            System.out.print(no.getValor()+ " ");      // 3️⃣ RAÍZ
        }
    }
    //=======================================================================
    //                   GET SUCESSOR
    //=======================================================================
    private No getSucessor(No no) {

        No paiSucessor = no;
        No sucessor = no;
        No atual = no.getDireita();

        // Vai para o menor nó da subárvore direita
        while (atual != null) {
            paiSucessor = sucessor;
            sucessor = atual;
            atual = atual.getEsquerda();
        }

        // Se o sucessor não for o filho direito direto
        if (sucessor != no.getDireita()) {
            paiSucessor.setEsquerda(sucessor.getDireita());
            sucessor.setDireita(no.getDireita());
        }

        return sucessor;
    }


    //=======================================================================
    //                   EXCLUIR NÓ
    //=======================================================================
    public boolean excluir(short valor) {

        if (raiz == null) {
            System.out.println("Árvore vazia");
            return false;
        }

        No atual = raiz;
        No pai = raiz;
        boolean eEsquerda = true; //indica de que lado do pai o nó atual está. Está na esquerda? True|False

        // 🔍 Buscar o nó
        while (atual.getValor() != valor) {

            pai = atual;

            if (valor < atual.getValor()) {
                eEsquerda = true;
                atual = atual.getEsquerda();
            } else {
                eEsquerda = false;
                atual = atual.getDireita();
            }

            if (atual == null) {
                return false;
            }
        }

        //🟢 Caso 1: nó folha (sem filhos)
        if (atual.getEsquerda() == null && atual.getDireita() == null) {

            if (atual == raiz) {
                raiz = null;
            } else if (eEsquerda) {
                pai.setEsquerda(null);
            } else {
                pai.setDireita(null);
            }

        }
        //🟡 Caso 2: Tem UM filho na esquerda.
        else if (atual.getDireita() == null) {

            if (atual == raiz) {
                raiz = atual.getEsquerda();
            } else if (eEsquerda) {
                pai.setEsquerda(atual.getEsquerda());
            } else {
                pai.setDireita(atual.getEsquerda());
            }

        }
        //🟠 Caso 3: Tem UM filho na direita
        else if (atual.getEsquerda() == null) {

            if (atual == raiz) {
                raiz = atual.getDireita();
            } else if (eEsquerda) {
                pai.setEsquerda(atual.getDireita());
            } else {
                pai.setDireita(atual.getDireita());
            }

        }
        //🔴  Caso 4: O nó tem DOIS FILHOS
        else {

            No sucessor = getSucessor(atual);

            if (atual == raiz) {
                raiz = sucessor;
            } else if (eEsquerda) {
                pai.setEsquerda(sucessor);
            } else {
                pai.setDireita(sucessor);
            }

            sucessor.setEsquerda(atual.getEsquerda());
        }

        return true;
    }

    public No getRaiz() {
        return raiz;
    }


    public void imprimirArvore() {
        System.out.println("(Árvore está deitada)");
        imprimirArvoreRec(raiz, 0);
    }

    private void imprimirArvoreRec(No no, int nivel) {
        /**
         * Exemplo:
         *         50
         *        /  \
         *      30    70
         *           /  \
         *         60   80
         *
         *  Primeira chamada:
         *
         *  imprimirArvoreRec(50, 0)
         *
         *  Nó ≠ null → continua
         *  ANTES DE IMPRIMIR 50, chama o lado direito
         *
         *  Descida TOTAL para a direita
         *  Chamadas encadeadas:
         *
         *  imprimirArvoreRec(50, 0)
         *  └─ imprimirArvoreRec(70, 1)
         *      └─ imprimirArvoreRec(80, 2)
         *          └─ imprimirArvoreRec(null, 3) → return
         *
         *  Nada foi impresso ainda.
         * A pilha só cresce.
         *
         *
         * Primeira impressão ocorre aqui:
         * Estamos em  imprimirArvoreRec(80, 2)
         * Executa:
         * for (int i = 0; i < 2; i++) print("    ");
         * System.out.println(80);
         *
         * Depois de imprimir:
         *
         * imprimirArvoreRec(80.getEsquerda(), 3) → null → return
         *
         * Voltamos para imprimirArvoreRec(70, 1)
         *
         * .......
         *
         * **/


        if (no == null) {
            return;
        }

        // Primeiro imprime o lado direito (para ficar visualmente bonito)
        imprimirArvoreRec(no.getDireita(), nivel + 1);

        // Espaçamento proporcional ao nível
        for (int i = 0; i < nivel; i++) {
            System.out.print("    "); // 4 espaços
        }

        // Imprime o valor do nó
        System.out.println(no.getValor());

        // Depois imprime o lado esquerdo
        imprimirArvoreRec(no.getEsquerda(), nivel + 1);
    }




    //=======================================================================
    //                  MAIN
    //=======================================================================
    public static void main(String[] args) {

        ArvoreBinariaBST arvore = new ArvoreBinariaBST();

        System.out.println("=== CENÁRIO 1: Árvore vazia ===");
        System.out.print("Pré-ordem: ");
        arvore.preOrdem(arvore.getRaiz());   // não imprime nada
        System.out.println();

        System.out.print("Em-ordem: ");
        arvore.emOrdem(arvore.getRaiz());    // não imprime nada
        System.out.println();

        System.out.print("Pós-ordem: ");
        arvore.posOrdem(arvore.getRaiz());   // não imprime nada
        System.out.println();

        // --------------------------------------------------------

        System.out.println("\n=== CENÁRIO 2: Inserções ===");

        arvore.inserir((short) 50);
        arvore.inserir((short) 30);
        arvore.inserir((short) 70);
        arvore.inserir((short) 20);
        arvore.inserir((short) 40);
        arvore.inserir((short) 60);
        arvore.inserir((short) 80);

        arvore.imprimirArvore();

    /*
                50
              /    \
            30      70
           /  \    /  \
         20   40  60  80
     */

        // --------------------------------------------------------

        System.out.println("\n=== CENÁRIO 3: Travessias ===");

        System.out.print("Pré-ordem (raiz, esquerda, direita): ");
        arvore.preOrdem(arvore.getRaiz());   // 50 30 20 40 70 60 80
        System.out.println();

        System.out.print("Em-ordem (esquerda, raiz, direita): ");
        arvore.emOrdem(arvore.getRaiz());    // 20 30 40 50 60 70 80
        System.out.println();

        System.out.print("Pós-ordem (esquerda, direita, raiz): ");
        arvore.posOrdem(arvore.getRaiz());   // 20 40 30 60 80 70 50
        System.out.println();

        // --------------------------------------------------------

        System.out.println("\n=== CENÁRIO 4: Pesquisar valores ===");

        No encontrado = arvore.pesquisar((short) 40);
        System.out.println(encontrado != null
                ? "Valor 40 encontrado"
                : "Valor 40 não encontrado");

        encontrado = arvore.pesquisar((short) 99);
        System.out.println(encontrado != null
                ? "Valor 99 encontrado"
                : "Valor 99 não encontrado");

        // --------------------------------------------------------

        System.out.println("\n=== CENÁRIO 5: Excluir folha (20) ===");
        arvore.excluir((short) 20);

        System.out.print("Em-ordem após excluir 20: ");
        arvore.emOrdem(arvore.getRaiz());    // 30 40 50 60 70 80
        System.out.println();

        arvore.imprimirArvore();

        // --------------------------------------------------------

        System.out.println("\n=== CENÁRIO 6: Excluir nó com um filho (30) ===");
        arvore.excluir((short) 30);

        System.out.print("Em-ordem após excluir 30: ");
        arvore.emOrdem(arvore.getRaiz());    // 40 50 60 70 80
        System.out.println();

        arvore.imprimirArvore();

        // --------------------------------------------------------

        System.out.println("\n=== CENÁRIO 7: Excluir nó com dois filhos (70) ===");
        arvore.excluir((short) 70);

        System.out.print("Em-ordem após excluir 70: ");
        arvore.emOrdem(arvore.getRaiz());    // 40 50 60 80
        System.out.println();

        arvore.imprimirArvore();
        // --------------------------------------------------------

        System.out.println("\n=== CENÁRIO 8: Excluir a raiz (50) ===");
        arvore.excluir((short) 50);

        System.out.print("Em-ordem após excluir a raiz: ");
        arvore.emOrdem(arvore.getRaiz());    // 40 60 80
        System.out.println();

        arvore.imprimirArvore();
        // --------------------------------------------------------

        System.out.println("\n=== CENÁRIO 9: Excluir valor inexistente ===");
        boolean removido = arvore.excluir((short) 999);
        System.out.println(removido
                ? "Valor removido"
                : "Valor não encontrado");

    }

}
