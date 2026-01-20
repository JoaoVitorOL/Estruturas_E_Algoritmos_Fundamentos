
# 📦 Fila (Queue) — Implementação com Vetor Circular (PT-BR)

🎯 Função principal

![fila ](../assets/fila.png)

A Fila é uma estrutura de dados linear e estática (nesta implementação) que segue rigorosamente o princípio:

*FIFO — First In, First Out* <br>
**(O primeiro a entrar é o primeiro a sair)** <br>

Características principais: <br>

- Inserção ocorre no fim <br>
- Remoção ocorre no início <br>
- Não há acesso direto a elementos intermediários <br>
- Ordem de saída preserva a ordem de entrada <br>

```text
Início → [10] [20] [30] ← Fim
````

![fila lógica ](../assets/Filalogica.jpg)

---

# 🧠 ONDE OS DADOS DA FILA FICAM NA MEMÓRIA (JAVA)
### 1️⃣ Regras de memória aplicáveis

> O array criado com new fica no HEAP
> Variáveis primitivas e referências ficam na STACK
> O array armazena valores primitivos (short)
> A fila cresce e diminui logicamente, não fisicamente

---

# 🧱 Estrutura interna da fila

```java
private short inicio; // Índice do primeiro elemento válido
private short fim; // Índice do último elemento inserido
private short elementos; // Quantidade lógica de elementos
private short capacidade; // Tamanho máximo da fila
private short[] fila; // Array que armazena os valores
````

# ⚙️ Estado inicial da fila

```java
public Fila(short capacidade) {
    this.capacidade = capacidade;
    this.fila = new short[capacidade];
    this.inicio = 0;
    this.fim = -1;
    this.elementos = 0;
}
````
Representação lógica inicial:
```text
fila        = [ ?, ?, ?, ?, ? ]
inicio      = 0
fim         = -1
elementos   = 0
capacidade  = 5
````

## 🗝️ Conceito-chave

> "inicio" e "fim" não indicam posições fixas
> Eles se movem conforme a fila cresce e diminui

---
