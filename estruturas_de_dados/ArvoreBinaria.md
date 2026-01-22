# 🌳 Árvore Binária (PT-BR)

## 🎯 Função principal

<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/b9e20132-c0bf-4377-bf9e-05eadac405e5" />


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

<img width="1388" height="1186" alt="image" src="https://github.com/user-attachments/assets/fe7dc8c7-4d1b-4fb3-b5bc-0040076b5740" />


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
## 👶 ENCONTRANDO O SUCESSOR

Para que existe o successor em uma Árvore Binária de Busca (BST)?

Você só precisa do sucessor em **UM caso específico** :
> **Quando vai remover um nó que possui DOIS filhos.**

### 🧠 O problema real ao remover um nó com dois filhos
Considere esta BST:

```text
        50
       /  \
     30    70
           / \
         60   80
````
Regras implícitas:

- Subárvore esquerda de 50 → valores < 50
- Subárvore direita de 50 → valores > 50

Subárvore esquerda de 70 → valores entre 50 e 70
Agora você quer remover o **50.**

## ❓ O que acontece se você simplesmente apagar o 50?
A árvore perde a propriedade da BST, porque: <br>

- tudo à esquerda precisa ser menor <br>
- tudo à direita precisa ser maior <br>

Você não pode escolher qualquer nó para subir no lugar do 50.

## ✔️ A solução correta: substituir por um valor válido
Existem duas escolhas matematicamente seguras:

### Opção 1 — Sucessor em ordem (mais usada)
Menor valor da subárvore direita

### Opção 2 — Predecessor em ordem
Maior valor da subárvore esquerda

### O que é exatamente o successor?
O successor de um nó é:
> o menor valor da direita que é MAIOR do que o nó que eu quero remover.
> successor = nó mais à esquerda da subárvore direita

Para remover o 50:
```text
        50
       /  \
     30    70
           / \
         60   80
````
 1. Vá para a direita de 50 → 70 <br>
 2.  Depois vá sempre para a esquerda <br>
 3. Para no primeiro null <br>

Neste caso, successor = 60 <br>

```text
Antes
        50
       /  \
     30    70
           / \
         60   80
````

```text
Depois
        60
       /  \
     30    70
             \
              80
````

✔️ Nenhuma Violação direta da BST


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

## 💡 Reflexão

> Ao excluir um nó com dois filhos, **“Por que não colocar o 70 no lugar do 50
> e depois empurrar o 60 para a esquerda?”**

**Vamos simular exatamente isso.**

```text
Antes
        50
       /  \
     30    70
           / \
         60   80
````

````text
Depois
        70
       /  \
     30    80
       \
        60

````
Agora vamos verificar a regra da BST, nó por nó. <br>

## 🔍 Verificação matemática (onde quebra)
### 1️⃣ Raiz = 70

Tudo à esquerda precisa ser < 70 <br>
Tudo à direita precisa ser > 70 <br>

Até aqui: <br>

esquerda: 30, 60 → ok <br>
direita: 80 → ok <br>

Parece válido… **mas ainda não terminou**. <br>

### 2️⃣ Verificando o nó 30
````text
     30
       \
        60
````

Regra da BST para o nó 30: <br>
- esquerda < 30 <br>
- direita > 30 <br>

Aqui: <br>
- direita = 60 → ok <br>

Ainda **parece** válido. <br>

### ❌ Agora vem o problema real

> 60 está na subárvore esquerda de 70

60 < 70   <br>
Até aqui, tudo bem. <br>
O problema surge quando a árvore cresce ou quando você faz **operações futuras**. <br>


### 🚨 O erro estrutural criado

Você quebrou a definição forte da BST, que é: <br>

> Todo nó da subárvore direita de 50 deve ser maior que 50 
> e todo nó da subárvore esquerda deve ser menor que 50 

Quando você sobe o 70, você está: <br>

- usando um nó que não é o menor maior <br>
- deixando valores menores “atravessarem” níveis hierárquicos <br>

Isso gera ambiguidade estrutural. <br>

````text
Depois
        70
       /  \
     30    80
       \
        60 Inconsistência

````

⚠️ Eventual Violação da BST

````text
Continuando...
        70
       /  \
     30    80
       \
        60
       /  \
     55    65
````

⚠️ Mas, 65 e 55 nunca deveria ficar sob a custódia do 70.
Na árvore original, o limite superior dele era 50, não 70.

> O nó que sobe para substituir outro não pode ter valores menores “passando por cima” dele futuramente.
>  Um nó X passa a ter, em sua subárvore, valores que não pertencem ao intervalo de valores que X deveria dominar.

👉 Isso é o “passar por cima”:

O valor 65 “ignora” o papel histórico do 50
E passa a existir abaixo de um nó que não deveria governá-lo

###  Mas, e seu eu ❓ 

> Subir o 70 para a raiz
> Empurrar o 80 para a direita
> Manter o 60 como filho esquerdo do 80

````text
Antes
        50
       /  \
     30    70
           / \
         60   80
````

````text
Depois
        70
       /  \
     30    80
           /
         60

````
Agora vamos verificar as regras, nó por nó.

### 📏 Regra formal da BST (recordação objetiva)

Para todo nó X: <br>

- todos os nós na subárvore esquerda < X <br>
- todos os nós na subárvore direita > X <br>

````text
60 < 70 ❌
````

⚠️ Violação direta da BST


# É por isso que:

O sucessor é a melhor opção. Ele resolve isso automaticamente !



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


