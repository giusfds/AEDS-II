# Aula dia 13.03

tem basicamente os metodos de inserir ( empilhar, push ) e remover ( desempilhar, pull )

gambiarra
|_ quando alocar o vetor pelo construtor colocar tamanho + 1 para ficar mais facil a manipulacao
[exemplo]( https://prnt.sc/YRW9_M_Jlobo )

no construtor fda fila circular (FC) alocamos o array com uma posicao a mais para economizar um IF na incrementacao
|_ pensar como que faz sem usar o +1

a vatiavel `ultimo` gerencia as insersoes. a `primeira` as remocoes
            |_ variavel                         |_ variavel

exemplo em codigo

```java
void inserir(int x) throw Exeptions{
    // nesse caso, X e o valor a ser incrementado na FC

    if ((ultimo + 1) % arr.lenght() == primeiro)
        thrpw new Exception;

    arr[ultimo] = x;
    ultimo = (ultimo + 1) % arr.lenght()
}
```