# 📦 Recursão  (PT-BR)

<img width="612" height="408" alt="image" src="https://github.com/user-attachments/assets/311544c7-145a-432d-a09b-cc0a560b8580" />


---


## ❓ 1. O que é recursão

Recursão é uma técnica onde **uma função chama a si mesma** para resolver um problema menor, até chegar a um ponto onde **não precisa mais chamar**.

Toda função recursiva **OBRIGATORIAMENTE** possui:

- **Caso base** → condição de parada  
- **Passo recursivo** → chamada da própria função com um problema menor  

Sem caso base → loop infinito → StackOverflowError.

---


## 🪙 2. Regra de ouro da recursão

> **Cada chamada recursiva empilha uma nova execução na memória.  
Nada é resolvido até o caso base ser atingido.**

A execução acontece em duas fases:

1. **Descida (empilhamento)**  
2. **Subida (desempilhamento / retorno dos valores)**

---

## ❗ Exemplo 1 – Fatorial

```java
public static int fatorial(int n) {

    if (n == 0 || n == 1) {
        return 1;
    }

    return n * fatorial(n - 1);
}

````

Leitura correta da função: <br>

Se n for 0 ou 1 → resposta imediata <br>
Caso contrário → guarda n e delega o resto para fatorial(n - 1) <br>

```text
fatorial(5)
= 5 * fatorial(4)
= 5 * (4 * fatorial(3))
= 5 * (4 * (3 * fatorial(2)))
= 5 * (4 * (3 * (2 * fatorial(1))))
= 5 * 4 * 3 * 2 * 1
= 120
````
### 📌 Nada multiplica até chegar em fatorial(1).

---

## 🔢 Exemplo 2 – Soma dos N primeiros inteiros

```java
public static int fatorial(int n) {

    if (n == 0 || n == 1) {
        return 1;
    }

    return n * fatorial(n - 1);
}
````
```text
soma(5)
= 5 + soma(4)
= 5 + (4 + soma(3))
= 5 + (4 + (3 + soma(2)))
= 5 + (4 + (3 + (2 + soma(1))))
= 5 + 4 + 3 + 2 + 1
= 15
````
---

## 🤓 Exemplo 3 – Fibonacci

⚠️ Problema do Fibonacci recursivo <br>

- Recalcula os mesmos valores várias vezes <br>
- Crescimento exponencial de chamadas <br>

Ótimo exemplo didático, péssimo em performance <br>

```java
public static int fibonacci(int num) {

    if (num <= 1) {
        return num;
    }

    return fibonacci(num - 1) + fibonacci(num - 2);
}
````
Leitura conceitual : <br>
Cada termo é a soma dos dois anteriores <br>
A função se divide em duas chamadas <br>

```text
fibonacci(5)

fibonacci(5) = fibonacci(4) + fibonacci(3)
Nada é somado ainda. Tudo fica pendente.

fibonacci(4) = fibonacci(3) + fibonacci(2)

Substituindo na expressão original:
fibonacci(5) =
    (fibonacci(3) + fibonacci(2)) + fibonacci(3)


fibonacci(3) = fibonacci(2) + fibonacci(1)

Substituindo na expressão original:
fibonacci(5) =
    ((fibonacci(2) + fibonacci(1)) + fibonacci(2)) + fibonacci(3)


fibonacci(2) = fibonacci(1) + fibonacci(0)

Substituindo tudo:

fibonacci(5) =
    (((fibonacci(1) + fibonacci(0)) + fibonacci(1)) +
      (fibonacci(1) + fibonacci(0))) +
      fibonacci(3)

Até aqui, nenhuma soma aconteceu.
Só empilhamento.

Agora entram os retornos imediatos:
fibonacci(1) -> 1
fibonacci(0) -> 0

Substituindo:
fibonacci(5) =
    (((1 + 0) + 1) + (1 + 0)) + fibonacci(3)

Resolver o fibonacci(3) da direita
Lembre que ele é outro, não o mesmo já calculado.

fibonacci(3) =
    fibonacci(2) + fibonacci(1)

Expandindo novamente:
fibonacci(2) =
    fibonacci(1) + fibonacci(0)

Chega nos casos base:
fibonacci(1) -> 1
fibonacci(0) -> 0

Logo:
fibonacci(3) = (1 + 0) + 1 = 2


Agora tudo pode subir !
Voltando para a expressão principal:

fibonacci(5) =
    (((1 + 0) + 1) + (1 + 0)) + 2

(1 + 0) = 1
(1 + 0) = 1

((1 + 1) + 1) + 2
(2 + 1) + 2
3 + 2
5

fibonacci(5) = 5


O ponto CRÍTICO (onde a galera se perde)

fibonacci(3) Foi calculado DUAS VEZES E fibonacci(2) foi calculado TRÊS VEZES.
Isso acontece porque:
  - Cada chamada cria uma subárvore inteira
  - A função não lembra resultados anteriores

f(5)
├── f(4)
│   ├── f(3)
│   │   ├── f(2)
│   │   │   ├── f(1)
│   │   │   └── f(0)
│   │   └── f(1)
│   └── f(2)
│       ├── f(1)
│       └── f(0)
└── f(3)
    ├── f(2)
    │   ├── f(1)
    │   └── f(0)
    └── f(1)
````

### Frase para fixar

Recursão não executa de cima para baixo. <br>
Ela empilha de cima para baixo e resolve de baixo para cima. <br>

---

## Como NÃO se perder em recursão

Checklist mental ao ler uma função recursiva <br>

 ⚫ Onde está o caso base? <br>
 ⚫ O problema está ficando menor a cada chamada? <br>
 ⚫ O que a função retorna ao subir da pilha? <br>
 ⚫ O valor é usado antes ou depois da chamada recursiva? <br>

Se você responder essas quatro, você entende a função. <br>

---

## 🌲Conexão com árvores (BST)
Em árvores: <br>

- Cada nó chama recursivamente seus filhos <br>
- O caso base é no == null <br>
- A pilha representa o caminho percorrido na árvore <br>

````java
private void imprimirArvoreRec(No no, int nivel) {

    if (no == null) {
        return;
    }

    imprimirArvoreRec(no.getDireita(), nivel + 1);

    printIndentacao(nivel);
    System.out.println(no.getValor());

    imprimirArvoreRec(no.getEsquerda(), nivel + 1);
}
````

````text
        50
      /    \
    30      70
   /  \    /  \
 20   40  60  80


imprimirArvoreRec(50, 0)

omo no != null, não retorna.
Ela vira:
Nada imprime ainda. Tudo fica pendente.

imprimirArvoreRec(70, 1)
→ imprimirArvoreRec(80, 2)
→ imprimirArvoreRec(null, 3) → retorna

Agora sim começa a subir.

Voltando para: 
imprimirArvoreRec(80, 2)

Fluxo:
direita → null (retorna)
IMPRIME 80
esquerda → null (retorna)


Voltando para:
imprimirArvoreRec(70, 1)

Fluxo:
direita já resolvida
IMPRIME 70
esquerda → imprimirArvoreRec(60, 2)

Saída:
        80
    70
        60


Voltamos para:
imprimirArvoreRec(50, 0)

Fluxo:
direita resolvida
IMPRIME 50
esquerda → imprimirArvoreRec(30, 1)

Saída parcial:
        80
    70
        60
50


Lado esquerdo repete o MESMO padrão
imprimirArvoreRec(30, 1)
→ imprimirArvoreRec(40, 2)
→ imprimirArvoreRec(20, 2)


Resultado final:

        80
    70
        60
50
        40
    30
        20

Árvore deitada

````



---

## Comparação: Recursão vs Iteração

| Aspecto | Recursão | Iteração   |
| :--- | :---: | ---: |
| Legibilidade | Alta (conceitual)| Média |
| Uso de memória | Maior (pilha) | Menor |
| Controle de fluxo | Implícito | Explícito |
| Risco | StackOverflow | Loop infinito |


