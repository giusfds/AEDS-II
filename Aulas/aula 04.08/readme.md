# AULA 08/04

#### heap sort 
reforcando, o maior numero esta na posicao 1 do vetor
                                            |_ para realizar a conta com maior facilidade, para saber onde estao os filhos e os pais
                                            |_ [foto sxplicando o metodo](https://prnt.sc/vVntqzrPiX_I)

tendo o exemplo que todos os numeros estejam em HEAP, se colocarmos um numero na ultima casa (ultimo valor do vetor) teremos que reorganizar o HEAP por completo. [exemplo](https://prnt.sc/rC5skHSXfJp_), como que vamos realizazr essa conta

**o principio de insersao no HEAP consiste em inserir uma nova folha no ultimo nivel o mais a a esquerda possivel. Em seguida comparamos a nova folha com o pai. Se a nova folha for maior que o pai invertemos (swap) seus valores. Continuaremos "subindo" o novo elemento enquanto ele for maior que seu pai.** 

```Java
void construir (int tam){
    for(int i=tam; i>1 && array[i]>array[i/2];i/=2){
        swap(i, i/2);
        // o codigo para realizar a troca entre pais e filhos
    }
}
```
**Na verdade, o pior caso e o caso medio da primeira etapa do HEAP sort tem custo (theta)(n\*lg n). A novidade o melhor caso da primeira etapa do HEAP sort tem custo (theta)(n) e acontece quando cada elemento inserido no HEAP for menor ou igual ao seu pai.**

**O unico momento do HEAP que comparamos element0s irmaos acontecem na remocao da cabeca do HEAP. nesse caso comparamos os irmaos para saber quem ficara no lugar do pai**

#### Merge sort
Usa o paradigma de "dividir e conquistar"

porem ele e falho... ao ponto do quick dar um pau nele (porque?)

MERGE normalmente ele e recursivo, pois e melhor, apenas aceite que e melhor

algoritmo *im-place* -> depende sempre do tamanho do array

o merge ele interacla dois vetorres ordenados, de forma que o resultado final deles fique ordenado

pega o vetor divide na petade, ate que so sobre 2 para haver a comparacao entre eles, assim, quando chegar nesse passo, pode simplesmente ir comparando um com o outro, ate chegar no vetor organizado

[codigo](https://prnt.sc/PgItfHK-Jgpc)