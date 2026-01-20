
# 📦 Fila (Queue) — Implementação com Vetor Circular (PT-BR)

🎯 Função principal

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
