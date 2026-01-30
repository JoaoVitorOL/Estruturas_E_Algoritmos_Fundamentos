# 🫧 Bubble Sort (Ordenação por Bolha) | (PT-BR)

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
> Como podemos observar, a tendência do algoritmo é:  Um único valor é pego como parâmetro em cada iteração sobre o array, quando este valor é maior que a maioria ele irá ser comparado várias vezes na mesma lista "subindo" até o topo do array.
> É aí de onde vem o apelido de "Bolha"|"Bubble". É só mentalizar um valor grande subindo o máximo que ele consegue até a superfície.

Resumindo:
À medida que o algoritmo avança:
os maiores valores “sobem” para o final | topo
como uma bolha subindo na água.


[Visualizar operação do algoritmo no Visualgo.net]([https://visualgo.net/en/sorting?slide=10](https://visualgo.net/en/sorting?slide=14))
