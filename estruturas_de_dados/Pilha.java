package estruturas_de_dados;
import java.util.Arrays;


public class Pilha {

    private short[] pilha;
    private short topo;

    public Pilha(short tamanho) {   //   CONSTRUTOR
        this.pilha = new short[tamanho];
        this.topo = -1;
    }

//==============================================================
//            VERIFICAÇÕES VAZIA|CHEIA
//==============================================================
    private boolean cheia() {
        return topo == pilha.length - 1;
    }

    private boolean vazia() {
        return topo == -1;
    }

//==============================================================
//            EMPILHAR (ADICIONAR)
//==============================================================
    public void empilhar(short valor) {

        if (cheia()) {
            System.out.println("Pilha cheia");
            return;
        }
        topo++;
        pilha[topo] = valor;
    }
//==============================================================
//            VER TOPO
//==============================================================
    public void verTopo() {

        if (vazia()) {
            System.out.println("Pilha vazia");
        } else {
            System.out.println("Topo da pilha: " + pilha[topo]);
        }
    }

//==============================================================
//            EXCLUIR TOPO
//==============================================================
    public void ignorarTopo() {  

        if (vazia()) {
            System.out.println("Pilha vazia");
            return;
        }

        short valor = pilha[topo];
        topo--;  //O valor do topo não é realmente removido, apenas passa a ser ignorado.(Até ser eventualmente sobre-escrito por outra informação)
        System.out.println("Valor desempilhado: " + valor);
    }


    public static void main(String[] args) {  //  MAIN FUNCTION
        Pilha minhaPilha = new Pilha((short) 5);

        minhaPilha.ignorarTopo(); // Deve indicar que a pilha está vazia
        minhaPilha.empilhar((short) 10);
        minhaPilha.empilhar((short) 20);
        System.out.println(Arrays.toString(minhaPilha.pilha));
        minhaPilha.verTopo(); // Deve exibir 20

        minhaPilha.ignorarTopo(); // Deve remover (ignorar) 20
        minhaPilha.verTopo(); // Deve exibir 10

        minhaPilha.ignorarTopo(); // Deve remover (ignorar) 10
        minhaPilha.ignorarTopo(); // Deve indicar que a pilha está vazia
        System.out.println(Arrays.toString(minhaPilha.pilha));
    }

}


