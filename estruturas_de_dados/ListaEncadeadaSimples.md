# 📦 Lista Encadeada Simples (PT-BR)

## 🎯 Função principal

A **Lista Encadeada Simples** é uma **estrutura de dados linear e dinâmica**, utilizada para armazenar elementos de forma sequencial **sem uso de posições fixas de memória**, diferentemente de vetores (arrays).

A lista é formada por **nós**, e cada nó conhece apenas o **próximo nó da sequência**. O acesso à lista ocorre exclusivamente por meio de uma referência inicial chamada **primeiro** ou **head**.

Não existe acesso direto por índice. Para alcançar um elemento intermediário, é necessário **percorrer a lista nó a nó**, seguindo as referências.

---

## 🧱 Estrutura básica da lista

### 🔹 Nó (Node)

Um **nó** é a menor unidade da lista encadeada. Ele encapsula:

- **valor**: o dado armazenado
- **próximo**: referência para o próximo nó da lista

Representação conceitual:

```text
[ valor | próximo ]
```

Tecnicamente:
- `valor` é o conteúdo
- `próximo` é uma **ligação estrutural**, não um dado

O último nó da lista sempre possui:

```java
proximo == null
```

Isso indica o **fim da lista**.

---

## 🧠 Conceito central: posição × relacionamento

### Vetor (array)

- Cada elemento ocupa uma **posição fixa** na memória
- Acesso direto por índice

```text
arr[0] arr[1] arr[2]
```

### Lista encadeada

- Os elementos **não possuem posição fixa**
- Cada elemento conhece apenas o próximo
- O acesso é feito por **relacionamento**, não por índice

```text
primeiro → nó1 → nó2 → nó3 → null
```

Consequência direta:
- Para acessar o 3º elemento, é necessário passar pelo 1º e 2º

---

## 🧭 Cabeça da lista (head)

A lista mantém uma referência especial:

```java
private No primeiro;
```

Função:
- Apontar para o **primeiro nó da lista**
- Servir como ponto de entrada para qualquer operação

Observação importante:
- `primeiro` **não é um nó**
- É apenas uma **referência externa** mantida pela lista

---

## ⚙️ Operações fundamentais

De acordo com o material, a lista encadeada simples implementa as seguintes operações:

- Inserir no início
- Excluir do início
- Mostrar lista
- Pesquisar valor
- Excluir em qualquer posição

Todas essas operações funcionam **manipulando referências**, nunca índices.

---

## ➕ Inserir no início

![Inserção no início](../assets/encadeadainseririnicio.png)

### Objetivo

Adicionar um novo nó como primeiro elemento da lista.

### Procedimento lógico

1. Criar um novo nó
2. Fazer o novo nó apontar para o antigo primeiro
3. Atualizar o head da lista para o novo nó

### Algoritmo conceitual

```text
novo → antigoPrimeiro
primeiro → novo
```

### Consequência

- Operação de **custo O(1)**
- Não depende do tamanho da lista

---

## ➖ Excluir do início

### Objetivo

Remover o primeiro nó da lista.

### Procedimento lógico

1. Guardar o nó atual apontado por `primeiro`
2. Fazer `primeiro` apontar para o segundo nó
3. Retornar o nó removido

### Observação

- O nó removido perde a referência da lista
- Se não houver mais referências para ele, torna-se elegível ao **Garbage Collector**

---

## 🔍 Mostrar lista

![Mostrar lista](sandbox:/mnt/data/lista_encadeada_imagens/page_9_img_1.png)

### Funcionamento

1. Começa pelo nó apontado por `primeiro`
2. Percorre a lista usando `proximo`
3. Encerra quando encontra `null`

### Forma de percurso

```text
atual = primeiro
while (atual != null)
```

Essa operação tem custo:
- **O(n)**, onde `n` é o número de nós

---

## 🔎 Pesquisar valor

![Pesquisar](../assets/listaencadeada.png)

### Funcionamento

- Percorre a lista sequencialmente
- Compara o valor de cada nó
- Finaliza quando:
  - encontra o valor, ou
  - chega ao final da lista (`null`)

### Importante

- Não há atalho
- Mesmo listas ordenadas exigem percurso sequencial

---

## ❌ Excluir em qualquer posição

![Excluir qualquer](../assets/encadeadaposicaoqualquer.png)

### Objetivo

Remover um nó específico pelo valor.

### Necessidade adicional

É preciso manter duas referências:

- `atual`: nó sendo analisado
- `anterior`: nó imediatamente anterior

### Procedimento lógico

1. Localizar o nó desejado
2. Fazer o nó anterior apontar para o próximo do nó removido

```text
anterior → atual → proximo

vira

anterior → proximo
```

### Caso especial

- Se o nó removido for o primeiro:

```java
primeiro = primeiro.getProximo();
```

---

## 📌 Características finais da lista encadeada simples

- Estrutura dinâmica
- Uso intensivo de referências
- Inserções e remoções eficientes no início
- Percurso sempre sequencial
- Não utiliza índices

A lista encadeada simples é a base conceitual para:
- Listas duplamente encadeadas
- Pilhas
- Filas
- Árvores
- Grafos

Entender **referência**, **encadeamento** e **head** aqui é essencial para todas essas estruturas.
