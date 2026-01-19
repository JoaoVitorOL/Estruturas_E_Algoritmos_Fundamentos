# 📦 Lista Encadeada Simples (PT-BR)
![Construção da lista](../assets/encadeadaconstruir.png)

## 🎯 Função principal


A **Lista Encadeada Simples** é uma **estrutura de dados linear e dinâmica**, utilizada para armazenar elementos de forma sequencial **sem uso de posições fixas de memória**, diferentemente de vetores (arrays).

A lista é formada por **nós**, e cada nó conhece apenas o **próximo nó da sequência**.  
O acesso à lista ocorre exclusivamente por meio de uma referência inicial chamada **primeiro** (ou **head**).

Não existe acesso direto por índice. Para alcançar um elemento intermediário, é necessário **percorrer a lista nó a nó**, seguindo as referências.

---

## 🧱 Estrutura básica da lista

### 🔹 Nó (Node)

Um **nó** é a menor unidade da lista encadeada. Ele encapsula:

- **valor** → dado armazenado
- **próximo** → referência para o próximo nó da lista

Representação conceitual:

```text
[ valor | próximo ]
````
Aspectos técnicos importantes:
  1. Valor representa informação. <br>
  2. "Próximo" representa uma ligação estrutural, não um dado. <br>


O último nó da lista sempre possui:
proximo == null , indicando o fim da lista.

# 🧠 Conceito central: posição × relacionamento
## Vetor (array) 

⚫ Cada elemento ocupa uma posição fixa na memória. <br>
⚫ O acesso é feito por índice. <br>

```text
arr[0] arr[1] arr[2]
````
## Lista Encadeada

⚫ Os elementos não possuem posição fixa. <br>
⚫ Cada nó conhece apenas o próximo. <br>
⚫ O acesso ocorre por relacionamento entre nós. <br>

```text
primeiro → nó1 → nó2 → nó3 → null
````

Consequência direta:
Para acessar o 3º elemento, é necessário passar pelo 1º e pelo 2º

# 🗣️ Cabeça da lista (head)
A lista mantém uma referência especial:

```java
private No primeiro;
````

Funções dessa referência:
⚫ Apontar para o primeiro nó da lista. <br>
⚫ Servir como ponto de entrada para todas as operações. <br>

Observações importantes:
⚫ "primeiro" não é um nó. <br>
⚫ É apenas uma referência externa mantida pela estrutura da lista. <br>

# ⚙️ Operações fundamentais
A lista encadeada simples implementa as seguintes operações:
⚫ Inserir no início <br>
⚫ Excluir do início <br>
⚫ Mostrar lista <br>
⚫ Pesquisar valor <br>
⚫ Excluir em qualquer posição <br>
Todas funcionam exclusivamente por manipulação de referências, nunca por índices.

# ➕ Inserir no início

![Inserir Início](../assets/encadeadainseririnicio.png)

## Objetivo
⚫ Adicionar um novo nó como primeiro elemento da lista. <br>

## Procedimento lógico
1. Criar um novo nó.  <br>
2. Fazer o novo nó apontar para o antigo primeiro nó.  <br>
3. Atualizar o head da lista para o novo nó. <br>

```text
novo → antigoPrimeiro
primeiro → novo
````

Complexidade: 
O(1), Independe do tamanho da lista.

# ➖ Excluir do início
![Excluir Início](../assets/encadeadaexcluirinicio.png)

## Objetivo
⚫ Remover o primeiro nó da lista. <br>

## Procedimento lógico

1  Guardar o nó atualmente apontado por primeiro. <br>
2. Fazer "primeiro" apontar para o segundo nó. <br>
3. Retornar o nó removido. <br>

# Observação técnica
O nó "removido", apenas perde sua ligação com a lista.

# 🔍 Mostrar lista
![mostrar lista](../assets/listaencadeada.png)

## Funcionamento

1. Começa pelo nó apontado por "primeiro". <br>
2. Percorre a lista utilizando "proximo". <br>
3. Encerra ao encontrar null. <br>

```text
atual = primeiro
while (atual != null)
````
Complexidade: 
O(n), onde n é o número de nós da lista

# 🔎 Pesquisar valor

## Funcionamento

1. Percorre a lista sequencialmente <br>
2. Compara o valor de cada nó <br>

## Finaliza quando:
o valor é encontrado, ou o final da lista é alcançado (null)

Observação importante
⚫ Não existe atalho. <br>
⚫ Mesmo listas ordenadas exigem percurso sequencial. <br>

# ❌ Excluir em qualquer posição

![Excluir qualquer](../assets/encadeadaposicaoqualquer.png)

## Objetivo
Remover um nó específico com base no valor.

## Necessidade adicional

São necessárias duas referências:

atual → nó sendo analisado <br>
anterior → nó imediatamente anterior <br>


## Procedimento lógico

1. Localizar o nó desejado. <br>
2. Fazer o nó anterior apontar para o próximo do nó removido. <br>

```text
anterior → atual → proximo

vira

anterior → proximo

````

#  📌 Características finais da lista encadeada simples

⚫ Estrutura dinâmica <br>
⚫ Uso intensivo de referências <br>
⚫ Inserções e remoções eficientes no início <br>
⚫ Percurso sempre sequencial <br>
⚫ Não utiliza índices <br>

A lista encadeada simples é a base conceitual para:

⚫ Listas duplamente encadeadas <br>
⚫ Pilhas <br>
⚫ Filas <br>
⚫ Árvores <br>
⚫ Grafos <br>


