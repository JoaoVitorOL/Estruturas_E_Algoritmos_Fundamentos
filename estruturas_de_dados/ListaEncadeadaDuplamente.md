

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

## 🧱 Estrutura básica da lista

### 🔹 Nó (classe `No`)

Cada nó encapsula **três informações**:

- `valor` → dado armazenado
- `proximo` → referência para o próximo nó
- `anterior` → referência para o nó anterior

Representação conceitual:

```text
[ anterior | valor | proximo ]
````

