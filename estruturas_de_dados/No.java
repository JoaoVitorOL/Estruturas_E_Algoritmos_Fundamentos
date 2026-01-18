package estruturas_de_dados;

public class No {

    private final short valor;
    private No proximo;
    private No anterior;

    public No(short valor) {
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
