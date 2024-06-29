# AULA 15/04

#### ponteiro (dnv)

o argumento **new** em java, faz a mesam coisa que o **malloc** em C, ja que e um nome melhor para a variavel, ja que memoria nao se cria, simpesmente aloca em algum lugar

```java
Cliente c1 = new Cliente( 1, "aa");
Cliente c2 = null;
c2 = c1;
// nesse caso, se a gvnt atribuir qualquer valor a C2, ele vai atribuir o valor de memoria ja alocado. no caso, ao objeto que C2 aponta
c2 = null;
c2 = c1.clone();
```

**dinamico** esta ultrapassado, antes tinha so a linguagem C, tinha a alocacao sequencial e estatica e a alocacao dinamica. porem em java tudo e dinamico.

Nas linguagens Java e C#, todos os objetos nao referenciados ficam aptos para a coleta automatica de lixo.

nas linguagens C e C++, antes de removermos a referencia para um registro, devemos desaloca-lo ```C ( free ou delete )```

