# Aula 03.04

Heapsort                        (theta)(n*lg n)

**o heapsort contem duas etapas, ambas com custo (theta)(n*ln n). a primeira etapa e' a criacao do heap, a segunda etapa e' a destruicao do heap ou a ordenacao propriamente dita**

construcao do heap
                |_ IMPORTANTE SABER O QUE E'
heap -> maior elemento

O heap e uma TAD que nos fornece ou menor ou o maior elemento do conjunto. com o custo de (theta)(1)
              |_ tipo abstrato de dados
**o custo de construcao do heap e' (theta)(n\*lg n). ao remover a "cabeca" do heapconseguimos reorganizar-lo com custo (theta)(lg n)**
                                                                |_Maior numero
heap [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

arvore origina:
```
        0
       / \
      4   1
     / \ / \
    6   5 2 3
   / \ /
  8   9 7
```
arvore heap:
```
        9
       / \
      8   3
     / \ / \
    7   6 1 2
   / \ /
  5   4 0
```

vetor: [ |9|7|8|3|6|4|5|1|2|0]
        0 1 2 3 4 5 6 7 8 9 10

o numero "pai" esta na posicao 1 do vetor
a conta para ordenar o vetor e:
(i\*2)  (i\*2+1)
assim conseguimos os numeros ordenados.