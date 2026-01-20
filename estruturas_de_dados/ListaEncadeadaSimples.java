package estruturas_de_dados;

public class ListaEncadeadaSimples {

    private No primeiro; // ligação estrutural (HEAD da lista)  | Variáveis de tipo objeto guardam REFERÊNCIAS, não os objetos em si

    public ListaEncadeadaSimples() { 
        this.primeiro = null;
    }

    /* =========================
       INSERIR NO INÍCIO
       ========================= */
    public void inserirInicio(short valor) {

        No novo = new No(valor);
        novo.setProximo(primeiro); // O valor de "proximo" do novo nó passa de "null" para o antigo "primeiro"
        primeiro = novo; // A variável primeiro (head) passa a apontar para novo
    }

    /* =========================
       MOSTRAR LISTA
       ========================= */
    public No mostrar() {

        if (primeiro == null) {
            System.out.println("Erro de lista vazia");
            return null;
        }

        No atual = primeiro; // "primeiro" se refere ao valor que está no início da lista"

        while (atual != null) {
            System.out.print("[" + atual.getValor() + "] -> ");
            atual = atual.getProximo();
        }

        return null;
    }


    /* =========================
       PESQUISAR VALOR
       ========================= */
    public No pesquisar(short valor) {

        if (primeiro == null) {
            System.out.println("Erro de lista vazia");
            return null;
        }

        No temp = primeiro;

        while (atual.getValor() != valor) {

            if (atual.getProximo() == null) {
                return null;
            } else {
                atual = atual.getProximo();
            }
        }

        return temp;
    }


    /* =========================
       EXCLUIR NO INÍCIO
       ========================= */
    public No excluirInicio() {

        if (primeiro == null) {
            System.out.println("Erro de lista vazia");
            return null;
        }

        No atual = primeiro;
        primeiro = primeiro.getProximo();

        return atual;
    }


    /* =========================
       EXCLUIR NÓ QUALQUER
       ========================= */
    public No excluirQualquer(short valor) {

        if (primeiro == null) {
            System.out.println("Erro de lista vazia");
            return null;
        }

        No atual = primeiro; // atual → nó sendo analisado
        No anterior = primeiro; // anterior → nó que aponta para atual

        while (atual.getValor() != valor) {

            if (atual.getProximo() == null) {
                return null;
            } else {
                anterior = atual; // anterior anda um passo atrás
                atual = atual.getProximo(); // atual anda um passo à frente
                // Antes: anterior → [A]  atual → [B]  |   Depois:  anterior → [B] atual  → [C]

            }
        }

        if (atual == primeiro) {
            primeiro = primeiro.getProximo(); // 🔹 Caso 1 — o nó a remover é o primeiro
        } else {
            anterior.setProximo(atual.getProximo()); // 🔹 Caso 2 — o nó está no meio ou no fim (Aqui é onde acontece a reorganização dos ponteiros)
        }

        return atual;
    }

    /* =========================
       MAIN PARA TESTES
       ========================= */
    public static void main(String[] args) {

        ListaEncadeadaSimples lista = new ListaEncadeadaSimples();

        System.out.println("=== CENÁRIO 1: Mostrar lista vazia ===");
        lista.mostrar();   // deve imprimir erro

        System.out.println("\n=== CENÁRIO 2: Inserções no início ===");
        lista.inserirInicio((short) 10);
        lista.inserirInicio((short) 20);
        lista.inserirInicio((short) 30);
        lista.mostrar();   // esperado: 30, 20, 10

        System.out.println("\n=== CENÁRIO 3: Pesquisar valores ===");
        System.out.println("Pesquisar 20:");
        No encontrado = lista.pesquisar((short) 20);
        System.out.println(encontrado != null ? "Encontrado: " + encontrado.getValor() : "Não encontrado");

        System.out.println("Pesquisar 99:");
        encontrado = lista.pesquisar((short) 99);
        System.out.println(encontrado != null ? "Encontrado" : "Não encontrado");

        System.out.println("\n=== CENÁRIO 4: Excluir início ===");
        lista.excluirInicio();   // remove 30
        lista.mostrar();         // esperado: 20, 10

        System.out.println("\n=== CENÁRIO 5: Excluir qualquer (valor do meio) ===");
        lista.excluirQualquer((short) 10); // remove 10
        lista.mostrar();                   // esperado: 20

        System.out.println("\n=== CENÁRIO 6: Excluir qualquer (primeiro elemento) ===");
        lista.excluirQualquer((short) 20); // remove 20
        lista.mostrar();                   // lista vazia

        System.out.println("\n=== CENÁRIO 7: Excluir em lista vazia ===");
        lista.excluirInicio();              // erro
        lista.excluirQualquer((short) 5);   // erro

        System.out.println("\n=== CENÁRIO 8: Reinserção após esvaziar ===");
        lista.inserirInicio((short) 40);
        lista.inserirInicio((short) 50);
        lista.mostrar();                   // esperado: 50, 40
    }
}







