package estruturas_de_dados;

public class No {

    private final short valor;  // conteúdo do nó
    private No proximo;  // ligação estrutural ( Usado na Lista encadeada simlpes)
    private No anterior;  // ligação estrutural ( Usado na Lista encadeadadupla)

    public No(short valor) { // Construtor
        this.valor = valor;
        this.proximo = null;
        this.anterior = null;
    }

    public short getValor() {
        return valor;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

}


