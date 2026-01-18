# 📦 Lista Encadeada Simples (PT-BR)

## 🎯 Função principal

A **Lista Encadeada Simples** é uma **estrutura de dados linear e dinâmica**, utilizada para armazenar elementos de forma sequencial **sem uso de posições fixas de memória**, diferentemente de vetores ou arrays.

Cada elemento da lista é representado por um **nó**, que contém:
- um **valor**
- uma **referência para o próximo nó**

A lista é acessada sempre a partir de uma referência inicial chamada **primeiro** (ou *head*).  
Não há acesso direto a posições intermediárias; o percurso é feito **sequencialmente**.

---

## 🧱 Estrutura básica

### 🔹 Nó (Node)

Cada nó possui dois componentes fundamentais:

```text
[ valor | próximo ]

