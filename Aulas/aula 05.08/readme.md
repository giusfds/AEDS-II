# aula 08/05

### funcionamento basico da insercao em arvore binaria
o ponteiro I ( o que fica de referencia para o no atual ) vai ser o no que vai ser inserido, se ele for nulo, ele vai ser o no que vai ser inserido, criando um novo no, se nao, ele vai ser o no que vai ser inserido, se o valor for menor que o valor do no atual, ele vai ser o no a esquerda, se nao, ele vai ser o no a direita, se o valor for igual, ele vai ser ignorado. porem, ele so vai ser aclopado na arvore, na volta da recursao, ou seja, quando ele ja tiver passado por todos os nos ate chegar no no que vai ser inserido, e ele vai ser inserido no no que vai ser inserido, e o no que vai ser inserido vai ser retornado, e vai ser aclopado no no que vai ser inserido, e assim por diante, ate chegar no no que foi chamado pela primeira vez, que vai ser o no raiz, e ele vai ser retornado, e vai ser aclopado na raiz, e assim a arvore vai ser criada.

### insercao em java
```java
    public void inserir(int x)throws Exception{
        raiz = inserir(x, raiz);
    }
    private No inserir(int x, No i)throws Exception{
        if(i == null){
            i = new No(x);
        }else if(x < i.valor){
            i.esq = inserir(x, i.esq);
        }else if(x > i.valor){
            i.dir = inserir(x, i.dir);
        }else{
            throw new Exception("Erro: valor ja existente");
        }
        return i;
    }
```
### analise de complexidade da arvore binaria
[no final dessa pagina](https://github.com/giusfds/Aulas-de-AEDS-II/tree/main/aula%2005.06)

#### como fazer o balanceamento de uma arvore, e a proxima materia que ele vai dar

### pesquisa e caminhamento 
vc verifica se o numero e igual, se ele for maior ele esta localizado para a direita, se ele for menor ele esta localizado para a esquerda, e vc vai fazendo isso ate achar o numero, ou ate chegar em um no nulo, que significa que o numero nao esta na arvore. <!-- [explicacao]() pegar foto na minha cvs -->

```java
    public boolean pesquisar(int x){
        return pesquisar(x, raiz);
    }
    private boolean pesquisar(int x, No i){
        boolean resp;
        if(i == null){
            resp = false;
        }else if(x == i.valor){
            resp = true;
        }else if(x < i.valor){
            resp = pesquisar(x, i.esq);
        }else{
            resp = pesquisar(x, i.dir);
        }
        return resp;
    }
```

esse e o codigo referente a pesquisa em arvore binaria, ele vai retornar true se o numero estiver na arvore, e false se nao estiver.

### caminhamento em java

essa funcao nada mais e do que um print da arvore, porem, ele vai printar a arvore em ordem crescente, ou seja, ele vai printar a arvore da esquerda para a direita, e ele vai fazer isso ate chegar no no nulo, e ele vai printar o no, e ele vai fazer isso ate chegar no no raiz, e ele vai printar o no raiz, e ele vai fazer isso ate chegar no no da direita, e ele vai printar o no da direita, e assim por diante, ate chegar no no nulo da direita, e ele nao vai printar o no nulo da direita, e assim a arvore vai ser printada em ordem crescente.

```java
    // printar a arvore em ordem crescente
    public void caminhar(){
        caminhar(raiz);
    }
    private void caminhar(No i){
        if(i != null){
            caminhar(i.esq);
            System.out.println(i.valor + " ");
            caminhar(i.dir);
        }
    }
```

para printar o codigo de forma decrescente, e so trocar a ordem do print, ou seja, printar o no, depois o no da direita, e depois o no da esquerda.

```java
    // printar a arvore em ordem decrescente ou caminhamento central da arvore
    public void caminhar(){
        caminhar(raiz);
    }
    private void caminhar(No i){
        if(i != null){
            caminhar(i.dir);
            System.out.println(i.valor + " ");
            caminhar(i.esq);
        }
    }
```

se voce quiser printar a arvore em pre-ordem, ou seja, printar o no, depois o no da esquerda, e depois o no da direita, e so trocar a ordem do print.

```java
    // printar a arvore em pre-ordem
    public void caminhar(){
        caminhar(raiz);
    }
    private void caminhar(No i){
        if(i != null){
            System.out.println(i.valor + " ");
            caminhar(i.esq);
            caminhar(i.dir);
        }
    }
```

se voce quiser printar a arvore em pos-ordem, ou seja, printar o no da esquerda, depois o no da direita, e depois o no, e so trocar a ordem do print.

```java
    // printar a arvore em pos-ordem
    public void caminhar(){
        caminhar(raiz);
    }
    private void caminhar(No i){
        if(i != null){
            caminhar(i.esq);
            caminhar(i.dir);
            System.out.println(i.valor + " ");
        }
    }
```

**EX:** insira os elementos em uma arvore e em seguida faca o caminhar central. Justifique porque esse algoritmo e conhecido como TreeSort

```java
// metodos ja feitos anteriormente
public inserir(int x)throws Exception{
    raiz = inserir(x, raiz);
}
private No inserir(int x, No i)throws Exception{
    if(i == null){
        i = new No(x);
    }else if(x < i.valor){
        i.esq = inserir(x, i.esq);
    }else if(x > i.valor){
        i.dir = inserir(x, i.dir);
    }else{
        throw new Exception("Erro: valor ja existente");
    }
    return i;
}

//  caminhamento central da arvore, tambem feito anteriormente
public void caminhar(){
    caminhar(raiz);
}
private void caminhar(No i){
    if(i != null){
        caminhar(i.esq);
        // diferenca, inves de printar, ele vai salvar em um vetor
        // nao sei fazer...
        System.out.println(i.valor + " ");
        caminhar(i.dir);
    }
}

//  metodo TreeSort
public void treeSort(){
    caminhar();
}

```

**EX:**  FAZER AS ATIVIDADES 3, 4, 6, 8 do slide "Arvore binaria de pesquisa e caminhamento" [link](https://github.com/icei-pucminas/aeds2/blob/master/aulas/u05%20%C3%81rvores%20bin%C3%A1rias/unidade05c_%C3%A1rvoreBinaria_pesquisa%20e%20caminhamento.pdf)

### remocao em arvore binaria

pergunta: faca o metodo de getMaior() para pegar o maior elementod e uma arvore binaria

```java
public int getMaior(){
    int resp=0;
    if (raiz != null){
        No i;
        for(i= raiz; i.esq != null; i= i.esq);
        resp= i.elemento;
    }
   return resp;
}
```

se o elemento estiver em uma folha, remova 