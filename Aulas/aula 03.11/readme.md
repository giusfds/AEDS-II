# Aula dia 11
### definicao da notacao O 

g(n) e' O(f(n)) se existirem as constantes positivas C e M tais que, para n >= m temao que | g(n) | <= c . | f(n) |

f(n) e' um `limite assinto'tico superior` para g(n)

o que significa M?
o M seria qualqueer numero de um par (C e M) para que o M nao ultrapasse o valor de N, no exemplo do slide, m =3, ja que a funcao de 
G(n) = 3n^3 + 5n + 1
f(n) = n^2

[print que explica melhor as cosias faladas a cima](https://prnt.sc/WF-V6cRNGvE2)


ver videos de analise de complexidades no canvas para a prova
- listas
- pilhas
- ordenaao 
- Unidade 1 a 3


quarta tem quiz de ordenacao (selecao, incercao e bolha)

## TAD (`T`ipo `A`bstrato de `D`ados)
em outras palavras, sao pilhas e filas

### LISTA
se vc colocar um numero na posicao onde ja tem, ela tem que jogar para o fim da lista e colocar no lugar desejado 

Os metodos de inserir recebem um elemento a ser inserido no array de verificam se existe espaco no array e incrementa o contador

Os metodos de remocao verificam se N > 0, retornam o elemento removido e decrementam o contador (N)
quando vc remove alguma coisa da lista, ele e retornado para ser trabalhado no programa, mas tbm pode ser inserido dnv 

As listas sao uma bagunca, ja que vc pode colcoar em qualquer lugar e tirar de qualquer lugar 

pilha != fila

### PILHA
nas pilhas, os elementos sao colocados no final e quando removem, sao removidos do comeco.

`F`irst `I`n, `L`ast `O`ut `(`FILO`)`

pilha de recursividade nada mais e do que uma atrefa realizando outra, fazedo o prosesso de "desemplihar"

` Exemplo em ACII`principio da localizacao
quando vc coloca qualquer comando no terminal e aperta a seta apra cima e para baixo, assim por diante 

### [EXEMPLO PRATICO DE FILAS E PILHAS](https://prnt.sc/H3o3LlaB6S8F)

