

# 📦 Lista Duplamente Encadeada (PT-BR)

![Lista dupla construção](../assets/duplaconstruir.png)


---

## 🎯 Função principal

A **Lista Encadeada Duplamente** é uma **estrutura de dados linear e dinâmica**, na qual:

- Os elementos **não ocupam posições fixas de memória**
- Cada elemento (nó) mantém **duas ligações estruturais**
- A navegação pode ocorrer **do início para o fim** e **do fim para o início**

Ela resolve uma limitação direta da lista simples:
> não precisar manter manualmente um ponteiro `anterior` durante remoções no meio da lista.

---

# 🧱 Estrutura básica da lista

### 🔹 Nó (classe `No`)

Cada nó encapsula **três informações**:

- `valor` → dado armazenado
- `proximo` → referência para o próximo nó
- `anterior` → referência para o nó anterior

Representação conceitual:

```text
[ anterior | valor | proximo ]
````
Aspectos técnicos:

- valor representa informação.
- proximo e anterior representam ligações estruturais, não dados.
- A lista é construída exclusivamente por essas referências.


# 🧠 Conceito central: relacionamento bidirecional

Representação de uma lista duplamente encadeada:
```text
null ← [10] ⇄ [20] ⇄ [30] → null
````
Condições de borda:
- Primeiro nó: anterior == null
- Último nó: proximo == null

# 🗣️ Cabeças da lista

O código mantém duas referências externas:
```java
private No primeiro;
private No ultimo;
````

Funções:
primeiro → ponto de entrada da lista
ultimo → ponto de saída da lista

Observação crítica:
> "primeiro" e "ultimo" não são nós, apenas referências.

# ➕ Inserir no início

![Lista dupla inserir](../assets/duplainseririnicio.png)


## Objetivo
Inserir um novo nó antes do atual primeiro.

## Execução lógica

1. Criar o novo nó

2. Se a lista estiver vazia:
   - ultimo também aponta para o novo nó <br>
   
Caso contrário:

   - O antigo primeiro aponta de volta para o novo
   - O novo aponta para o antigo primeiro

3. Atualizar primeiro

Fluxo estrutural:
```text
novo ⇄ antigoPrimeiro
primeiro(Head) → novo
````


# ➕ Inserir no final

![Lista dupla inserir](../assets/duplainserirfinal.png)

## Objetivo
Adicionar um novo nó após o atual ultimo.

## Execução lógica

1. Criar novo nó

2. Se lista vazia:
   - primeiro aponta para ele <br>

Caso contrário:
  - Antigo último aponta para o novo
  - Novo aponta de volta para o antigo último

3. Atualizar ultimo

# ➖ Excluir do início
![Lista dupla excluir inicio](../assets/duplaexcluirinicio.png)

## Objetivo
Remover o nó apontado por primeiro (Head).

## Execução lógica

1. Guardar o nó removido

2. Se havia apenas um nó:
   - ultimo = null <br>

Caso contrário:
   - O segundo nó perde referência para trás

4. Atualizar "primeiro"

5. Isolar o nó removido

Conceito importante
> O nó não é apagado — ele apenas perde as referências da lista.

# ➖ Excluir do final

![Lista dupla excluir final](../assets/duplaexcluirfinal.png)

## Objetivo

Remover o nó apontado por ultimo (tail).

## Execução lógica

1. Guardar o nó removido

2. Se havia apenas um nó:
   - primeiro = null <br>

Caso contrário:
  - O penúltimo perde referência para frente

3. Atualizar ultimo

4. Isolar o nó removido

# ❌ Excluir qualquer valor
![Lista dupla excluir qualquer](../assets/duplaexcluirqualquer.png)

## Objetivo
Remover um nó intermediário sem necessidade de ponteiro auxiliar externo.


1. Percorrer a lista até encontrar o valor

2. Caso não encontre, retornar null

3. Se for o primeiro:
   - Atualizar primeiro <br>

Caso contrário:
  - Ligar anterior ao proximo

4. Se for o último:
   - Atualizar ultimo <br>

Caso contrário: 
   - Ajustar o anterior do próximo nó

5. Isolar o nó removido

Vantagem estrutural
> O próprio nó conhece quem vem antes e depois.

# 🔍 Mostrar do início

![Lista dupla](../assets/listadupla.png)

Percorre a lista usando "proximo".

## 🔍 Mostrar do final
Percorre a lista usando "anterior".


# 🔎 Pesquisar valor

Funcionamento:

- Percorre a lista do início

- Compara valores

- Retorna o nó ou null

Observação:
Mesmo com lista dupla, a busca continua sequencial.

## 🔗 Relação com outras estruturas

A lista duplamente encadeada é base direta para:

- Deques

- LRU Cache

- Navegação undo/redo

- Gerenciadores de histórico

- Estruturas de sistemas operacionais



