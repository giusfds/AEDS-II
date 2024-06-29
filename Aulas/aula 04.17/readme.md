# AULA 15/04

#### estruturas de dados flexiveis
|_ alocar espaco de memoria sob demanda -> restricao apenas pela memoria que o computador tem

uma variavel temporaria em uma celula, ela e necessaria, pois precisa dela para manipular. porem nao precisa desalocar o espaco de memoria dela, ja que a mesma so vai existor dentro do scopo geral

metodo -> classe    |   desalocar a variavel mesmo que a cariavel
funcao -> nao POO   |   for local

- na linguagem Java e C existe exclusivamente a passagem de parametro por valor, ou seja, ao passar por uma variavel como parametro, na verdade, passamos apenas o valor dessa variavel. alteracao nessa variavel pelo metodo chamado nao serao refletidas originalmente.

se voce pegar a ideia de recursao, tudo fica mais facil ( um exemplo claro e a atividade 5)

ex6) faca o ex6 com (theta)(n) acessos a celulas. nesse caso, utilize uma pikha auxiliar. faca esse metodo com (theta)(n^2) acessos a pilha. nesse caso, utilize dois ponteiros temporarios

estruturas flexiveis
```Java
import PrincipalFila.java.util;
import Fila.java.util;
// as duas principais bibliotecas que serao usadas
```

fila != pilha - 2 ponteiros
             |_ nos construtores

na fila flexivel, temos 2 ponteiros porque a insersao e a remocao acontece pela existencia distintas. o ponteiro p ( fila circular ) gerencia as remocoes e o U ( fila circular ) as insersoes

a outra diferenca e' que um tem um ponteiro para null e o outro tem um ponteiro para ele mesmo, ambos iniciados no construtor

#### Lista simples 
|_ != pilha
    |_ inserir em qualquer lugar ( fila )
|_ lista tem o mesmo codigo de inserir e remover iguais da Fila
|_ a funcao mostrar pode ser igual a funcao da Pilha e da Fila, a diferenca e a ordem que vai mostrar os numeros. 