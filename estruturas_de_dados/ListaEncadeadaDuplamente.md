

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
primeiro → novo
````
