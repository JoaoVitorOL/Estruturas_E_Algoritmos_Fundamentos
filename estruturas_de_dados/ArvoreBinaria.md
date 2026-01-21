# 🌳 Árvore Binária (PT-BR)

## 🎯 Função principal

<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/61b77b36-fe0a-4dc8-9b82-3c5fc49c901e" />


Uma Árvore Binária é uma estrutura de dados hierárquica, dinâmica e não linear, utilizada para organizar dados de forma que: <br>

 - Cada elemento pode possuir **até dois filhos** <br>
 - Existe uma relação clara de **hierarquia** <br>
 - A busca pode ser mais eficiente que listas encadeadas <br>

Ela combina vantagens de: <br>

**Array ordenado** → busca mais rápida <br>
**Lista encadeada** → inserção e remoção dinâmicas <br>

Diferente de listas: <br>
> não existe sequência linear única, a navegação depende da estrutura da árvore.

<img width="433" height="612" alt="image" src="https://github.com/user-attachments/assets/70187061-a354-4b10-a594-21efe0d99dad" />


---

## 🧠 ONDE OS DADOS DE UMA ÁRVORE BINÁRIA FICAM NA MEMÓRIA (JAVA)

Regras fundamentais:
> - Objetos criados com new ficam no HEAP
> - Referências e variáveis locais ficam na STACK
> - A árvore não contém os nós fisicamente
> - A árvore mantém apenas uma referência especial: raiz

````java
ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
````
````text
Stack:
------
arvore ─────────────► referência 0x100

Heap:
-----
0x100 → ArvoreBinariaBusca {
    raiz = null
}
````
A árvore começa vazia, sem nós.

---

## 🧱 Estrutura básica da árvore
### 🔹 Nó (classe No)

Cada nó contém três informações:

````text
[ esquerda | valor | direita ]
````
valor → dado armazenado <br>
esquerda → referência para o filho esquerdo <br>
direita → referência para o filho direito <br>

Observações técnicas: <br>

esquerda e direita são ligações estruturais <br>

Um nó pode ter: <br>
- dois filhos <br>
- um filho <br>
- nenhum filho (folha) <br>

---

## 🧠 Terminologia essencial

**Raiz:** nó superior da árvore <br>
**Pai**: nó que aponta para outro <br>
**Filho:** nó apontado por outro <br>
**Folha:** nó sem filhos <br>
**Caminho:** sequência de nós conectados <br>
**Subárvore:** árvore dentro da árvore <br>

---

## 🌳 Árvore Binária de Busca (BST)

Uma Árvore Binária de Busca segue uma regra estrutural:

````text
valores menores  → esquerda
valores maiores  → direita
````
Formalmente:  <br>

- Filho esquerdo < pai <br>
- Filho direito ≥ pai <br>

( < menor que ,  ≥ maior ou igual a) <br>


````text
        40
       /  \
     20    60
    /  \
  10   30
````

---

## ➕ Inserção na árvore (BST)

### Objetivo: <br>

Inserir um novo nó mantendo a propriedade da árvore de busca. <br>


### Procedimento lógico <br>

1. Se a árvore estiver vazia: <br>

  - o novo nó vira a raiz <br>

2. Caso contrário: <br>

  - começar pela raiz <br>
  - comparar valores <br>
  - descer pela esquerda ou direita <br>
  - inserir quando encontrar null <br>



### Complexidade

Média: O(log n)  <br>
Pior caso (árvore degenerada): O(n) <br>


````java
class No {
    short valor;
    No esquerda;
    No direita;

    public No(short valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }
}

````

````java
public class ArvoreBinariaBusca {

    private No raiz;

    public ArvoreBinariaBusca() {
        this.raiz = null;
    }

    public void inserir(short valor) {
        No novo = new No(valor);

        if (raiz == null) {
            raiz = novo;
            return;
        }

        No atual = raiz;
        No pai;

        while (true) {
            pai = atual;

            if (valor < atual.valor) {
                atual = atual.esquerda;
                if (atual == null) {
                    pai.esquerda = novo;
                    return;
                }
            } else {
                atual = atual.direita;
                if (atual == null) {
                    pai.direita = novo;
                    return;
                }
            }
        }
    }
}
````

---

## 🔍 Pesquisa na árvore

### Funcionamento:

 1. Começa pela raiz <br>
 2. Compara o valor <br>
 3. Decide esquerda ou direita <br>
 4. Repete até: <br>
    - encontrar o valor <br>
    - ou chegar em null <br>
    

### Complexidade

Média: O(log n)  <br>
Pior caso: O(n)  <br>



## 🔁 Percursos (Travessias)

As travessias definem a ordem de visita dos nós.

### 🔹 Pré-ordem (Raiz → Esquerda → Direita)
````text
Visita o nó antes dos filhos
````
````java
public void preOrdem(No no) {
    if (no != null) {
        System.out.print(no.valor + " ");
        preOrdem(no.esquerda);
        preOrdem(no.direita);
    }
}
````

### 🔹 Em ordem (Esquerda → Raiz → Direita)

> Em uma BST, em ordem imprime os valores ordenados.

 ````java
public void emOrdem(No no) {
    if (no != null) {
        emOrdem(no.esquerda);
        System.out.print(no.valor + " ");
        emOrdem(no.direita);
    }
}
````


### 🔹 Pós-ordem (Esquerda → Direita → Raiz) <br>

Usada em: <br>

- exclusão <br>
- liberação de memória <br>
- avaliação de expressões <br>

 ````java
public void posOrdem(No no) {
    if (no != null) {
        posOrdem(no.esquerda);
        posOrdem(no.direita);
        System.out.print(no.valor + " ");
    }
}
````


---

## ❌ Exclusão de nós

A exclusão depende da estrutura do nó. <br>

### Caso 1 — Nó folha <br>
> Simplesmente remove a referência do pai. <br>

### Caso 2 — Nó com um filho <br>
> O pai passa a apontar diretamente para o filho. <br>

### Caso 3 — Nó com dois filhos (mais complexo)
> Procedimento: <br>
>  1. Encontrar o sucessor em ordem <br>
>  2. Substituir o nó removido <br>
>  3. Ajustar referências <br>
>  O sucessor é: <br>
> > o menor valor da subárvore direita <br>

---

## 👁️ ESQUEMA VISUAL — ÁRVORE BINÁRIA NA MEMÓRIA (JAVA)

```text
CRIAÇÃO DA ÁRVORE

Stack:
------
arvore ─────────────► 0x100

Heap:
-----
0x100 → ArvoreBinariaBusca {
    raiz ───────► 0x200
}

0x200 → No {
    valor = 40
    esquerda ─────► 0x300
    direita  ─────► 0x400
}

0x300 → No {
    valor = 20
    esquerda = null
    direita = null
}

0x400 → No {
    valor = 60
    esquerda = null
    direita = null
}
````

Observações: <br>

- Os nós não são contíguos <br>
- A hierarquia é definida apenas por referências <br>
- A árvore conhece apenas a raiz <br>

---

📌 Conceitos-chave finais

- Árvore é estrutura não linear
- Organização hierárquica
- Baseada exclusivamente em referências
- Performance depende do balanceamento
- BST permite buscas eficientes


