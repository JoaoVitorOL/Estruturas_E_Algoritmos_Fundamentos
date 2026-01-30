# 🫧 Bubble Sort (Ordenação por Bolha) O(n²) | (PT-BR)

<img width="300" height="180" alt="image" src="https://github.com/user-attachments/assets/535ee30f-8d59-4e11-b11f-dfe22289e256" />


<img width="612" height="612" alt="image" src="https://github.com/user-attachments/assets/d85a8c3d-6ac7-4f50-903b-b6fcd3b9a9fd" />

### 1. O problema da ordenação
Ordenar significa **reorganizar uma coleção de dados segundo um critério**, normalmente ordem crescente ou decrescente.

Exemplos clássicos:
- números em ordem crescente
- nomes em ordem alfabética
- registros por chave (ID, CEP, preço)

Antes de pesquisar dados de forma eficiente, ordenar é um passo fundamental.

---

## 🫧 Ideia central do Bubble Sort

O Bubble Sort é o algoritmo de ordenação **mais simples e mais lento**.
Ele funciona com uma regra única:

> Compare dois elementos adjacentes.
> Se o elemento a esquerda for maior que seu colega a direita, eles trocam de lugar.
> Após isso, esse mesmo maior valor é comparado novamente com seu próximo colega da direita.
> Como podemos observar, a tendência do algoritmo é:  Em cada passada, vários valores são comparados, mas apenas o maior entre eles “borbulha” até sua posição final (superfícia|topo).
> É aí de onde vem o apelido de "Bolha"|"Bubble". É só mentalizar um valor grande subindo o máximo que ele consegue até a superfície.

Resumindo: <br>
À medida que o algoritmo avança: <br>
os maiores valores “sobem” para o final | topo <br>
como uma bolha subindo na água. <br>

---

````java
public static void bubbleSort(int[] array) {

    int tamanho = array.length;

    // Controla o número de voltas completas pelo array
    for (int volta = 0; volta < tamanho - 1; volta++) {

        // Percorre os elementos ainda não ordenados
        for (int indiceAtual = 0; indiceAtual < tamanho - 1 - volta; indiceAtual++) {

            // Comparação entre elementos vizinhos
            if (array[indiceAtual] > array[indiceAtual + 1]) {

                int temp = array[indiceAtual];
                array[indiceAtual] = array[indiceAtual + 1];
                array[indiceAtual + 1] = temp;
            }
        }
    }
}

````

## O que cada parte do algoritmo faz ?

````java
for (int volta = 0; volta < tamanho - 1; volta++)
````
Cada volta completa garante que:
- No mínimo, o maior elemento da parte não ordenada atinja sua posição final.

Após a 1ª volta:

- o maior elemento já está no final

Após a 2ª volta:

- o segundo maior está fixo
- E assim por diante

Por isso, não precisamos mais comparar o final do vetor.

````java
for (int indiceAtual = 0; indiceAtual < tamanho - 1 - volta; indiceAtual++)
````

(tamanho - 1) <br>
evita acessar array[j + 1] fora do vetor <br>

(- volta) <br>
ignora a parte já ordenada no final <br>


````java
if (array[indiceAtual] > array[indiceAtual + 1]) {
    int temp = array[indiceAtual];
    array[indiceAtual] = array[indiceAtual + 1];
    array[indiceAtual + 1] = temp;
}

````

- Compara dois vizinhos
- Troca somente se necessário
- Mantém o algoritmo estável (não troca iguais)

---

# Complexidade (Big-O)
## O que é o Big O?
Muitas pessoas confundem o Big O como um sinônimo de tempo. Mas, na verdade, o Big O mede **a quantidade de comparações|operações** que o algoritmo realiza conforme o tamanho da entrada n aumenta.
Ou seja, Big-O **não mede tempo em segundos**. Na realidade, **mede crescimento do número de operações**.
O fato de demorar menos tempo para realizar o trabalho é decorrente da redução do número de comparações necessárias para organizar elementos.


<img width="800" height="556" alt="image" src="https://github.com/user-attachments/assets/2ecca399-6b62-4a71-a0b3-b8f87c42f391" />

[Big O Cheat Sheet](https://www.bigocheatsheet.com/)

O Big O nos mostra a **tendência de crescimento**.
> Se eu multiplicar n por 10, o custo cresce:
- linearmente?
- quadraticamente?
- exponencialmente?

Ignora:

- velocidade do computador
- linguagem
- constantes pequenas

Observa apenas **como o algoritmo escala**.

Pergunta central:
> Se n (tamanho do array) dobra, o trabalho dobra, quadruplica ou explode?

---

#  Big O do Bubble Sort O(n²)

```text
para volta de 0 até n-1:
    para indice de 0 até n-1-volta:
        compara
````
Isso já nos diz algo importante:
> Cada elemento pode ser comparado com quase todos os outros.

**Imagine n = 10**
````text
Volta 0 → 9 comparações
Volta 1 → 8 comparações
Volta 2 → 7 comparações
Volta 3 → 6 comparação
Volta 4 → 5 comparação
Volta 5 → 4 comparação
Volta 6 → 3 comparação
Volta 7 → 2 comparação
Volta 8 → 1 comparação

9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1 = 45
````
Agora generalizando para n elementos:
````text
(n - 1) + (n - 2) + ... + 1

(Representa o número total de comparações feitas pelo algoritmo)

Essa soma é conhecida matematicamente como:

n(n - 1) / 2

A divisão por 2 acontece porque o total de comparações no Bubble Sort segue uma sequência que diminui passo a passo (PA decrescente).
Se você somar essa sequência com ela mesma ao contrário, todos os pares de números darão o mesmo resultado, o que acaba gerando o dobro da soma que você precisa.
Por isso, dividimos por 2: para eliminar essa repetição e encontrar o número real de comparações.

````

Vamos expandir:
````text
n(n - 1) = n² - n

Dividindo por 2:

(n² - n) / 2

````
A parte importante disso tudo é que a fórmula (n² - n) / 2 tem n² como seu termo dominante ! <br>
Sendo assim, **o Big O do Bubble Sort cresce quadraticamente** O(n²) . <br>

---

# 👁️ Visualização do algoritmo

[Visualizar operação do algoritmo no Visualgo.net](https://visualgo.net/en/sorting)

---

# Bubble Sort — Melhor, Médio e Pior Caso


### 🔴 Pior caso — O(n²)
O pior caso ocorre quando o vetor está totalmente em ordem inversa.
```text
[5, 4, 3, 2, 1]
````
O que acontece
- Toda comparação resulta em troca
- Cada elemento precisa “subir” várias posições
- O número de comparações é máximo

### 🟠 Caso médio — O(n²)
O vetor está parcialmente desordenado, com elementos fora de posição de forma aleatória.
```text
[3, 1, 2, 4, 5]
````
O que acontece

- Algumas comparações trocam
- Outras não
- Mas todas as comparações ainda acontecem

### 🟢 Melhor caso — O(n)
 O vetor já está totalmente ordenado.
 ```text
[1, 2, 3, 4, 5]
````
O que acontece:
- Algoritmo faz a primeira volta inteira
- Percebe que nenhuma troca ocorreu
- encerra com um Break

