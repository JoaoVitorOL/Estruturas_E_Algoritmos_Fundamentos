# 📦 Recursão  (PT-BR)

<img width="612" height="408" alt="image" src="https://github.com/user-attachments/assets/311544c7-145a-432d-a09b-cc0a560b8580" />


---


## 1. O que é recursão

Recursão é uma técnica onde **uma função chama a si mesma** para resolver um problema menor, até chegar a um ponto onde **não precisa mais chamar**.

Toda função recursiva **OBRIGATORIAMENTE** possui:

- **Caso base** → condição de parada  
- **Passo recursivo** → chamada da própria função com um problema menor  

Sem caso base → loop infinito → StackOverflowError.

---

# 🎯 Função principal

A Pilha é uma estrutura de dados linear e estática (nesta implementação), que segue rigorosamente o princípio:

*LIFO — Last In, First Out*
**(O último a entrar é o primeiro a sair)**

Características principais: <br>
⚫ Inserção e remoção ocorrem somente em uma extremidade <br>
⚫ Essa extremidade é chamada de topo <br>
⚫ Não há acesso direto a elementos intermediários <br>
⚫ Toda operação acontece no topo <br>

Exemplo conceitual:
```text
Base
[10]
[20]
[30]  ← Topo
````

![pilha lógica ](../assets/pilhalogica.jpeg)

# 🧠 ONDE OS DADOS DA PILHA FICAM NA MEMÓRIA (JAVA)
### 1️⃣ Regras de memória aplicáveis

> - Arrays criados com "new" ficam no HEAP
> - Variáveis primitivas e referências ficam na STACK
> - O array armazena valores, não referências (neste caso short)

### 2️⃣ Estado inicial da pilha

Ao criar a pilha:
```java
Pilha minhaPilha = new Pilha((short) 5);
````
⚫ Um array de tamanho fixo é criado <br>
⚫ Nenhum valor está logicamente presente <br>
⚫ O topo indica nenhum elemento <br>

### 3️⃣ Conceito-chave

> A pilha não cresce nem encolhe na memória
> Ela cresce e encolhe logicamente, através do índice "topo"

## 🧱 Estrutura interna da pilha

```java
private short[] pilha; // Array que armazena os valores
private short topo;    // Índice do último elemento válido
````

## ➕ Empilhar (push)
```java
public void empilhar(short valor) {

    if (cheia()) {
        System.out.println("Pilha cheia");
        return;
    }
    topo++;
    pilha[topo] = valor;
}
````
Execução passo a passo <br>

- Verifica se a pilha está cheia <br>
- Incrementa o índice topo <br>
- Armazena o valor no array <br>

```java
empilhar(10);
empilhar(20);
````

Estado da memória:

```text
pilha = [10, 20, ?, ?, ?]
topo  = 1
````

## 👁️ Ver topo (peek)

```java
public void verTopo() {

    if (vazia()) {
        System.out.println("Pilha vazia");
    } else {
        System.out.println("Topo da pilha: " + pilha[topo]);
    }
}

````
Execução passo a passo <br>

- Apenas consulta <br>
- Não altera a estrutura <br>
- Retorna o valor mais recente inserido <br>

## ➖ Ignorar topo (pop lógico)

```java
public void ignorarTopo() {  

    if (vazia()) {
        System.out.println("Pilha vazia");
        return;
    }

    short valor = pilha[topo];
    topo--;
    System.out.println("Valor desempilhado: " + valor);
}


````
Conceito fundamental:

> O valor não é apagado do array
> Ele apenas deixa de ser considerado parte da pilha

## 🧠 ESQUEMA VISUAL

Estado inicial

```text
pilha = [ ?, ?, ?, ?, ? ]
topo  = -1
````

empilhar(10)
empilhar(20)

```text
pilha = [10, 20, ?, ?, ?]
topo  = 1
````

ignorarTopo()

```text
pilha = [10, 20, ?, ?, ?]
topo  = 0
````
⚠️ O 20 ainda existe no array, mas está inacessível pela pilha.

---


### 📌 Características finais da pilha

- Estrutura LIFO <br>
- Inserção e remoção em tempo O(1) <br>
- Implementação simples <br>
- Uso de memória contínua (array) <br>
- Não permite acesso direto a elementos internos <br>
- Controle lógico feito apenas pelo índice topo <br>

### 🔗 Relação com outras estruturas

- A pilha é base direta para: <br>
- Chamadas de função (call stack) <br>
- Undo / Redo <br>
- Avaliação de expressões <br>
- Backtracking <br>
- Algoritmos de busca (DFS) <br>
- Parsers e compiladores <br>

