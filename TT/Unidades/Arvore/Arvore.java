package Unidades.Arvore;

//! MENOR VALOR VAI PARA A ESQUERDA, VALOR MAIOR A DIREITA

class No{
    int elemento;
    No esq;
    No dir;

    // INICIO constituicao de e um NO
    No ( int elemento){
        this(elemento, null, null);
    }

    No(int elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
    // FIM da constituicao do No
}

class Arvorebinaria{
    No raiz;
    //! EX1 getAltura
    int altura;
    //  construtor 
    Arvorebinaria() { raiz = null; altura =0; }
    // inserir valor na arvore
    void inserir(int valor)throws Exception{
        raiz = inserir(valor, raiz);
    }
    No inserir (int newValor, No newNo)throws Exception{
        if (newNo == null) {
            newNo = new No(newValor);
            //! aumentar a altura da arvore, para facilitar na conta dps
            altura++;
        }else if(newValor < newNo.elemento){
            // verifica se o valor e maior, assim podendo atribuir o maior valor a esquerda
            newNo.esq = inserir(newValor, newNo.esq);
            //! aumentar a altura da arvore, para facilitar na conta dps
            altura++;
        }else if (newValor > newNo.elemento) {
            // verifico se o valor e menor, assim podendo atribuir o menor valor a direita
            newNo.dir = inserir(newValor, newNo.dir);
            //! aumentar a altura da arvore, para facilitar na conta dps
            altura++;
        }else{
            // vai jogar a execao quando o valor ja estiver na arvore
            throw new Exception("Erro!");
        }
        return newNo;
    } // END insercao
    // inserir um valor no NO pai
    void inserirPai(int newValor)throws Exception{
        if (raiz == null) {
            // verifica se o pai esta vazio, assim criando o primeiro pai
            raiz = new No(newValor);
            //! aumentar a altura da arvore, para facilitar na conta dps
            altura++;
        }else if (newValor < raiz.elemento) {
            // varifica se o valor e maior, assim chamando o metodo para colocar os numeros a esquerda
            inserirPai(newValor, raiz.esq, raiz);
            //! aumentar a altura da arvore, para facilitar na conta dps
            altura++;
        }else if(newValor > raiz.elemento){
            //  verifica se o valor e menor, assim podendo colocar ele a direita
            inserirPai(newValor, raiz.dir, raiz);
            //! aumentar a altura da arvore, para facilitar na conta dps
            altura++;
        }else{
            //  evita que um elemento igual seja inserido
            throw new Exception("ERRO!");
        }
    }
    void inserirPai(int x, No i, No pai)throws Exception{
        // verificar se existe um ponteiro
        if(i == null){
            // nao existe, verificar se ele vai para esquerda ou direita
            if (x < pai.elemento) {
                pai.esq = new No(x);
            }else{
                pai.dir = new No(x);
            }
        }
        // se ja existe, fazer a comparacao para saber se o valor vai na direita ou na esquerda
        else if(x < i.elemento){
            inserirPai(x, i.esq, i);
        }
        // colocar o valor a direita, ja que o mesmo e menor do que o no pai
        else if(x > i.elemento){
            inserirPai(x, i.dir, i);
        }else{
            // o numero ja existe na arvore
            throw new Exception("ERRO!");
        }
    }// end of inserirPai()
    boolean pesquisar(int valor){ 
        return pesquisar(valor, raiz);
    }
    boolean pesquisar (int valor, No i){
        boolean resp;
        // se a arvore nao foi iniciada, nao tem valor la dentro
        if (i==null) {
            resp = false;
        }
        // se o elemento for do no pai, retornar true, ja que ja achou o valor (funciona para a recurcao)
        else if(valor == i.elemento){
            resp = true;
        }
        // o elemento nao foi encontrado, comecar a procurar pelos nos, da esquerda e direita ate achar, sendo que
        // direita e o menor valor e esquerda e o maior valor
        else if( valor < i.elemento){
            resp = pesquisar(valor, i.esq);
        }else{
            resp = pesquisar(valor, i.dir);
        }
        // retornar se achou o numero ou nao
        return resp;
    } //end of pesquisar()
    void caminharCentral(No i){
        // printa de ordem crescente

        // verifica se chegou no fim da arvore
        if (i == null) {
            return;
        }
        // chama o valor da esquerda, ja que e sempre o menor, ate achar ele.
        caminharCentral(i.esq);
        // printa o valor
        System.out.println(i.elemento + " ");
        // comeca a caminhas para a direita, onde tem os valores menores
        caminharCentral(i.dir);
        
    }
    void caminhasPre(No i){
        //  printa em ordem que a sub arvore da esquerda e printada primeiro e dps a arvore da direita
        if (i == null) {
            return;
        }
        //  mesma ideia do de cima
        System.out.println(i.elemento + " ");
        caminhasPre(i.esq);
        caminhasPre(i.dir);
    }
    void caminhasPos(No i){
        if (i == null) {
            return;
        }
        caminhasPos(i.esq);
        caminhasPos(i.dir);
        System.out.println(i.elemento + " ");
    }
    void remover(int valor){}


    // atividades do slide "pesquisa e caminhamento"
    // EX1
    // faca um metodo que retorne a altura da arvore

    public int getAltura(No i, int altura){
        if (i == null) {
            altura--;
        }else{
            int alturaEsq = getAltura(i.esq, altura+1);
            int alturaDir = getAltura(i.dir, altura+1);
            altura = (alturaEsq > alturaDir) ? alturaEsq : alturaDir;
        }
    return altura;
    }
}