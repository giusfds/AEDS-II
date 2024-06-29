# Aula 06/05
#### arvore binaria
(teta)(lg(n))

- usando linguagens especificas
- classe no em java 
- classe arvore binaria em java

estruturas de arvore e a msm estrutura do heap sort. a arvore pode ser balanceada, que e os galhos mais ou menos na mesma posicao
**BALANCEAMENTO DE ARVORE** 

pauzinhos = arestas
bolinhsa = nos
quadrado = nao tem nada na posicao -> representei de forma []
nos folhas = nos que nao tem filhos

no raiz, onde comeca a estrutura, o nivel 0. os filhos do nivel 0, sao os do nivel 1 e assim pod diante.

no interno = no que tem 1 ou mais filhos

arestas: e a quantidade de pauzinhos da arvore, onde so tem um nivel de diferenca entre elas [exemplo](https://prnt.sc/rgGDwYaAJWel)

aeds3 e aeds2 vamos ver arvores, de varios tipos, ate que em grafos (4 periodo) a gnt vai ver a compatibilidade entre eles

nossas arvores vao ser em arvores binarias, sendo 0, 1 ou 2 filhos entre elas, por isso uma arvore binaria 

HEAP E UMA ARVORE COM REGRAS ESPECIAIS [help](https://github.com/giusfds/Aulas-de-AEDS-II/tree/main/aula%2004.03)

a arvore bina'ria em que cada no' e' **maior que todos os seus vizinhos 'a esquerda** e' **menor que todos 'a direita**
|_ a direita vai ser o menor, e a esquerda o maior, 

#### arvore binaria completa
- cada no e uma folha **or** possui exatamente dois filhos 
- todos os nos possuem uma altura H
- o numero de nos internos e (2^H)-1
- o numero de nos folhas e de 2^H
- o numero total de nos e ((2^H)-1) + (2^H) = ((2^(H+1))-1)
usando essas regras, e assim que fazemos uam arvore binaria completa e balanceada

a arvore balanceada nao necessariamente e completa, mas a arvore completa e sim balanceada.

pergunta 1: crie uma arvore binaria completa com os digitos hexadecimais de 0 a F
- falso, e impossivel criar pois a arvore binaria completa so pode ter 2^H nos folhas, e 16 nao e uma potencia de 2

pergunta 2: crie uma arvore binaria completa com digitos hexadecimais nao nulos 
- isso e possivel de ser feito, pois 15 e uma potencia de 2
<!-- - [arvore]() pegar a foto na minha cvs dia 06 de maio-->

para achar a altura da arvore, tem que se fazer HD - HE = saber se a arvore esta balanceada (a diferenca pode ser 1, -1 e 0)

#### arvore binaria de pesquisa
```java
    class No{
        int valor;
        No esq;
        No dir;
        No(int elemento){
            this(elemento, null, null);
        }
        No(int elemento, No esq, No dir){
            valor = elemento;
            this.esq = esq;
            this.dir = dir;
        }   
    }
```

#### algoritmo de incersao em arvore binaria de pesquisa em java
##### Funcionamento basico

se o elemento for repetido, vc nao vai colocar ele na busca ( na arvore do max ), pois ele ja esta la e nao precisa ser colocado de novo, assim, ele vai ser ignorado.

exempo: inserir, na ordem, os elementos 3, 5, 1, 8, 2, 4, 7 e 6
- Desenho:
```
  3
 / \
1   5
 \  / \
  2 4  8
      / \
     7   9
```
- Codigo:
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

#### insercao em java com passagem de pai
- vc pode passar o pai como referencia, assim usando 2 ponteiros entre eles
  
```java
    void inserirPai(int x)thorws Exception{
        if(raiz == null){
            raiz = new No(x);
        }else if(x < raiz.valor){
            inserirPai(x, raiz, raiz.esq);
        }else if(x > raiz.valor){
            inserirPai(x, raiz, raiz.dir);
        }else{
            throw new Exception("Erro: valor ja existente");
        }
    }

    void inserirPai(int x, No i, No pai)throws Exception{
        if(i == null){
            if(x < pai.elemento){
                pai.esq = new No(x);
            }else{
                pai.dir = new No(x);
            }
        }else if(x < i.elemento){
            inserirPai(x, i.esq, i);
        }else if( x > i.elemento){
            inserirPai(x, i.dir, i); // aqui que vai ser inserido
        }else{ 
            throw new Exception("Erro: valor ja existente");
        }
    }
```
- como que ele moveu o ponteiro i?
    o eleemnto i continua apontqando para o null da direita, assim quando vc iguala o pai.dir a um novo no, o i vai ser o filho desse novo no ( isso pode ser visto na linha ( onde tem o comentario ) do metodo inserirPai ) 

#### analise de complexidade da insersao
**MELHOR CASO** (teta)(1) Comparacoes e acontecer, por exemplo, inserindo na raiz 
**PIOR CASO** (teta)(n) comparacoes e acontece, por exemplo, uqnado inserimos os elementos na ordem crescente ou decrescente
**CASO MEDIO** (teta)(lg(n)) comparacoes e acontece, por exempo, quando inserimos um elemento na folha de uma arvore balanceada. lembrando que a altura da arvore balanceada e' (teta)(lg(n))

obs1: dependencia do formato
obs2: na insercao aleatoria (aproximadamente) 1,39 x lg(n) comparacoes

Cooking 🍪