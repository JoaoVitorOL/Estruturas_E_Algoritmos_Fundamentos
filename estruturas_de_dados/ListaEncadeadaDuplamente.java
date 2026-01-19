package estruturas_de_dados;

public class ListaEncadeadaDuplamente {

    private No primeiro;  // variável que guarda o endereço do primeiro nó
    private No ultimo;  //variável que guarda o endereço do ultimo nó

    /* =========================
       CONSTRUTOR
       ========================= */
    public ListaEncadeadaDuplamente() {
        this.primeiro = null;
        this.ultimo = null;
    }

    /* =========================
       LISTA VAZIA
       ========================= */
    private boolean listaVazia() {
        return primeiro == null;
    }

    /* =========================
       INSERIR NO INÍCIO
       ========================= */
    public void inserirInicio(short valor) {

        No novo = new No(valor);

        if (listaVazia()) {
            ultimo = novo;
        } else {
            primeiro.setAnterior(novo); // O antigo primeiro passa a apontar para trás
            novo.setProximo(primeiro); //  O novo aponta para frente
        }

        primeiro = novo; // Atualiza o ponto de entrada da lista (Valor inicial da lista)
    }

    /* =========================
       INSERIR NO FINAL
       ========================= */
    public void inserirFinal(short valor) {

        No novo = new No(valor);

        if (listaVazia()) {
            primeiro = novo;
        } else {
            ultimo.setProximo(novo);
            novo.setAnterior(ultimo);
        }

        ultimo = novo;
    }

    /* =========================
       EXCLUIR NO INÍCIO
       ========================= */
    public No excluirInicio() {

        if (listaVazia()) {
            System.out.println("Erro de lista vazia");
            return null;
        }

        No temp = primeiro; // Nó a ser removido

        if (primeiro.getProximo() == null) { //“O primeiro nó é também o último?”
            ultimo = null; // faz com que: primeiro -> null | ultimo -> null
        } else {
            primeiro.getProximo().setAnterior(null); // Remove a ligação de trás do novo primeiro nó
        }

        primeiro = primeiro.getProximo(); // Move o head 

        temp.setProximo(null); // Desconectadndo o ponteiros do nó removido
        temp.setAnterior(null);

        return temp;
    }

    /* =========================
       EXCLUIR NO FINAL
       ========================= */
    public No excluirFinal() {

        if (listaVazia()) {
            System.out.println("Erro de lista vazia");
            return null;
        }

        No temp = ultimo;

        if (primeiro.getProximo() == null) {
            primeiro = null;
        } else {
            ultimo.getAnterior().setProximo(null);
        }

        ultimo = ultimo.getAnterior();

        temp.setProximo(null);
        temp.setAnterior(null);

        return temp;
    }

    /* =========================
       EXCLUIR QUALQUER VALOR
       ========================= */
    public No excluirQualquer(short valor) {

        No atual = primeiro;

        while (atual != null && atual.getValor() != valor) {
            atual = atual.getProximo();
        }

        if (atual == null) {
            return null;
        }

        if (atual == primeiro) { // 🔹 Caso 1: o nó é o primeiro
            primeiro = atual.getProximo();
        } else {
            atual.getAnterior().setProximo(atual.getProximo());  // Remove o nó atual do encadeamento, conectando diretamente o nó anterior ao nó seguinte.
        }

        if (atual == ultimo) { // 🔹 Caso 2: o nó está no meio ou no fim
            ultimo = atual.getAnterior();
        } else {
            atual.getProximo().setAnterior(atual.getAnterior());
        }

        atual.setProximo(null);
        atual.setAnterior(null);

        return atual;
    }

    /* =========================
       MOSTRAR DO INÍCIO
       ========================= */
    public void mostrarInicio() {

        No atual = primeiro;

        while (atual != null) {
            System.out.print("[" + atual.getValor() + "] <-> ");
            atual = atual.getProximo();
        }

        System.out.println("null");
    }

    /* =========================
       MOSTRAR DO FINAL
       ========================= */
    public void mostrarFinal() {

        No atual = ultimo;

        while (atual != null) {
            System.out.print("[" + atual.getValor() + "] <-> ");
            atual = atual.getAnterior();
        }

        System.out.println("null");
    }

    /* =========================
       PESQUISAR VALOR
       ========================= */
    public No pesquisar(short valor) {

        if (listaVazia()) {
            System.out.println("Erro de lista vazia");
            return null;
        }

        No atual = primeiro;

        while (atual.getValor() != valor) {

            if (atual.getProximo() == null) {
                return null;
            } else {
                atual = atual.getProximo();
            }
        }

        return atual;
    }

    /* =========================
   MAIN PARA TESTES
   ========================= */
    public static void main(String[] args) {

        ListaEncadeadaDuplamente lista = new ListaEncadeadaDuplamente();

        System.out.println("=== CENÁRIO 1: Mostrar lista vazia (início e final) ===");
        lista.mostrarInicio();   // não deve mostrar nada
        lista.mostrarFinal();    // não deve mostrar nada

        System.out.println("\n=== CENÁRIO 2: Inserções no início ===");
        lista.inserirInicio((short) 10);
        lista.inserirInicio((short) 20);
        lista.inserirInicio((short) 30);

        System.out.print("Do início: ");
        lista.mostrarInicio();   // esperado: 30 20 10

        System.out.print("Do final:  ");
        lista.mostrarFinal();    // esperado: 10 20 30

        System.out.println("\n=== CENÁRIO 3: Inserções no final ===");
        lista.inserirFinal((short) 40);
        lista.inserirFinal((short) 50);

        System.out.print("Do início: ");
        lista.mostrarInicio();   // esperado: 30 20 10 40 50

        System.out.print("Do final:  ");
        lista.mostrarFinal();    // esperado: 50 40 10 20 30

        System.out.println("\n=== CENÁRIO 4: Pesquisar valores ===");
        No encontrado = lista.pesquisar((short) 10);
        System.out.println(encontrado != null
                ? "Valor 10 encontrado"
                : "Valor 10 não encontrado");

        encontrado = lista.pesquisar((short) 99);
        System.out.println(encontrado != null
                ? "Valor 99 encontrado"
                : "Valor 99 não encontrado");

        System.out.println("\n=== CENÁRIO 5: Excluir início ===");
        lista.excluirInicio();   // remove 30

        System.out.print("Do início: ");
        lista.mostrarInicio();   // esperado: 20 10 40 50

        System.out.print("Do final:  ");
        lista.mostrarFinal();    // esperado: 50 40 10 20

        System.out.println("\n=== CENÁRIO 6: Excluir final ===");
        lista.excluirFinal();    // remove 50

        System.out.print("Do início: ");
        lista.mostrarInicio();   // esperado: 20 10 40

        System.out.print("Do final:  ");
        lista.mostrarFinal();    // esperado: 40 10 20

        System.out.println("\n=== CENÁRIO 7: Excluir valor do meio ===");
        lista.excluirQualquer((short) 10);

        System.out.print("Do início: ");
        lista.mostrarInicio();   // esperado: 20 40

        System.out.print("Do final:  ");
        lista.mostrarFinal();    // esperado: 40 20

        System.out.println("\n=== CENÁRIO 8: Excluir primeiro e último ===");
        lista.excluirQualquer((short) 20);
        lista.excluirQualquer((short) 40);

        System.out.print("Do início: ");
        lista.mostrarInicio();   // lista vazia

        System.out.print("Do final:  ");
        lista.mostrarFinal();    // lista vazia

        System.out.println("\n=== CENÁRIO 9: Exclusões em lista vazia ===");
        lista.excluirInicio();            // erro controlado
        lista.excluirFinal();             // erro controlado
        lista.excluirQualquer((short) 5); // erro controlado

        System.out.println("\n=== CENÁRIO 10: Reutilização da lista ===");
        lista.inserirFinal((short) 60);
        lista.inserirInicio((short) 70);

        System.out.print("Do início: ");
        lista.mostrarInicio();   // esperado: 70 60

        System.out.print("Do final:  ");
        lista.mostrarFinal();    // esperado: 60 70
    }

}


