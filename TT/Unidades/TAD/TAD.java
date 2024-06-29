// package Unidades.TAD;


//  caso abse de uma celula
class Celula {
  // elementos da celula, o seu valor
  int elemento;
  Celula prox;

  // construtores
  Celula(){
    this(0);
  }
  Celula(int x){
    this.elemento = x;
    this.prox = null;
  }// !end of construtores()
}

// Pilhas
class Pilha{
  Celula topo;

  // construtor
  public Pilha(){
    topo = null;
  } 

  // inserir
  public void inserir(int x){
    // crio uma nova celula com o valor que desejo inserir
    Celula tmp = new Celula(x);
    // faco o ponteiro do valor antigo apontar para o valor novo, assim, eu comeco a empilhar
    // deixando o novo valor por cima
    tmp.prox = topo;
    // desaloco o ponteiro
    tmp = null;
  }// ent of inserir()

  // remover
  public int remover()throws Exception{
    // verifica se a celula ta vazia
    if (topo == null) {
      throw new Exception("ERRO!"); 
    }
    // cria um novo elemento, para guardar o calor que foi removido
    int elemento = topo.elemento;
    // criar um novo ponteiro, para manipular a remocao
    Celula tmp = topo;
    // passa o ponteiro principal para a procima celula, usando o seu proprio ponteiro
    topo = topo.prox;
    // o ponteiro da variavel temporaria agora vai apontar para nada, para desconectar o valor totalmente
    // da pilha
    tmp.prox = null;
    // delasoca o ponteiro, assim deixando igual a null
    tmp = null;
    // retorna o elemento que foi removido da pilha
    return elemento;
  }// !end of rmeover

  // mostrar
  public void mostrar(){
    System.out.println("[");
    // fazer um for, para percorrer todos os valores, onde i, depois da repeticao, vai ser igualado ao valor
    // da proxima variavel, assim, mudando a celula uma a uma, printando da ultima que foi colocada ate a 
    // primeira que foi colocada
    for (Celula i = topo; i != null; i=i.prox) {
      System.out.println(i.elemento + " ");
    }
    System.out.println("]");
  }// !end of mostrar()

  // somar
  public int somar(){
    int contador = 0;
    for (Celula i = topo; i != null; i=i.prox) {
      // pegar os elementos da celula e ir somando ao somador
      contador += i.elemento;
    }
    return contador;
  }// !end of somar()

  // soma rec
  public int somaRec(Celula i){
    if (i.prox == null) {
      return 0;
    }else{
      return i.elemento + somaRec(i.prox);
    }
  } // !end somaRec()

  // maior elemento
  public int maiorElemento()throws Exception{
    // caso se a pilha estiver vazia
    if (topo == null) {
      throw new Exception("a pilha esta vasia");
    }
    // pegadno o maior elemento da pilha, ate ent, o unico elemento que verificamos
    int maior = topo.elemento;
    // criando uma celula tmp
    Celula atual = topo.prox;
    // rodar toda a pilha, ate onde o valor for null, ou seja o primeiro valor que foi inserido na tela
    while (atual != null) {
      // swap
      if (atual.elemento > maior) {
        maior = atual.elemento;
      }
      // andando com o ponteiro para a proxima celula da lista
      atual = atual.prox;
    }
    return maior;
  }// !end of meiorElemento()

  // maior elemento recursivo
  public int maiorElementoRec()throws Exception{
    // tratar o caso da pilha estar vazia
    if (topo == null) {
      throw new Exception("A pilha esta vazia");
    }
    // metodo aux rec passando o topo da pilha
    return encontrarMaiorRec(topo.elemento, topo.prox);
  }
  public int encontrarMaiorRec(int maior, Celula i){
    // verificar se ja chegou no final da pilha
    if (i == null) {
      return maior;
    }
    // verifica se o elemento que eu to comparando e menor do que o atual
    if (i.elemento > maior) {
      // swap
      maior = i.elemento;
    }
    // chamar o metodo dnv, para verificar novos elementos
    return encontrarMaiorRec(maior, i.prox);
  }
}// !end of Pilha

// AKA ArrayList
class Fila{
  private Celula primeiro;
  private Celula ultimo;

  public Fila(){
    primeiro = new Celula(); // no cabeca da fila
    ultimo = primeiro;
  }

  public void inserir (int valor){
    // cria uma nova celula e joga o valor nela
    ultimo.prox = new Celula(valor);
    // faz o ponteiro ultimo andar por todas as celulas que existem dentro da fila
    ultimo = ultimo.prox;
  }//!end of inserir
  public int remover()throws Exception{
    if (primeiro == ultimo) {
      // a fila esta vazia, ja que os dois ponteiros sao iguais
      throw new Exception("Erro, a fila ta vazia");
    }
    // criar um ponteiro temporario, assim, nao perdemos a celula vazia
    Celula tmp = primeiro;
    // faz o ponteiro primeiro andar uma casa, assim, pod!endo pegar o valor presete nele
    primeiro = primeiro.prox;
    // armazena o valor de onde ta o elemento
    int elemento = primeiro.elemento;
    // desaloca a primeira celula
    //? isso e meio desnecessario, ja que o java ja faz a remocao automatica de memoria
    tmp.prox = null;
    // desaloca a celula temporaria
    tmp = null;
    return elemento;
  }//!end of remover
  public void mostrar()throws Exception{
    if (primeiro == null) {
      throw new Exception("Erro, lista vazia");
    }
    // crio um novo ponteiro para manipular sem remover as coisas da fila
    Celula tmp = primeiro;
    // percorro a fila toda, ate achar o final
    while (tmp != null) {
      // print
      System.out.println(tmp.elemento + " ");
      // movo o ponteiro temporario para a nova celuca, assim pegando o seu proximo elemento
      tmp = tmp.prox;
    }
  }//!end of mostrar
  public int getMaior()throws Exception{
    // define um valor pequeno para maior
    int maior = -1;
    // verifica se a lista ta vazia
    if (primeiro == ultimo) {
      throw new Exception("erro, lista vazia");
    }
    // inicia o valor com o primeiro elemento
    // pode gerar consufao, ja que a celula pode ser a cabeca da fila
    maior = primeiro.prox.elemento;
    Celula i = primeiro.prox.prox;
    // percorre a lista toda para encontrar o maior elemento
    while (i != null) {
      // swap
      if (i.elemento > maior) {
        maior = i.elemento;
      }
      // vai para o proximo valor
      i = i.prox;
    }
    // retorna o maior valor que achou 
    return maior;
  } // !end of getMaior
  public int getTerceiroElemento(){
    // pegar o terceiro valor
    int elemento = primeiro.prox.prox.prox.elemento;
    return elemento;
  } // !end of getTerceiroElemento
  public int soma(){
    int cont = 0;
    for (Celula i = primeiro.prox; i != null; i = i.prox) {
      cont += i.elemento;
    }
    return cont;
  } // !end of somar
  void inverter (){
    Celula fim = ultimo;
    while (primeiro != fim) {
      Celula nova = new Celula(primeiro.prox.elemento);
      nova.prox = fim.prox;
      fim.prox = nova;
      Celula tmp = primeiro.prox;
      primeiro.prox = tmp.prox;
      nova = tmp = tmp.prox = null;
      if (ultimo == fim) {
        ultimo= ultimo.prox;
      }
      fim = null;
    }
  } // !end of inverter
}

//  lista simples

class Lista {
  private Celula primeiro;
  private Celula ultimo;
  public Lista(){
    primeiro = new Celula();
    ultimo = primeiro;
  }

  public void inserirInicio(int x){
    // cria uma nova celula para colocar os valores
    Celula tmp = new Celula(x);
    // troca os ponteiros para a nova celula com o valor
    tmp.prox = primeiro.prox;
    // pega o ponteiro da nova celula e aponta para a proxima, assim tornando o primeiro elemento
    primeiro.prox = tmp;
    // verifica se a lista esta vazia
    if (primeiro == ultimo) {
      ultimo = tmp;
    }
    tmp = null;
  } // !end inserirInicio()
  public void inserirFim(int x){
    ultimo = new Celula(x);
    ultimo = ultimo.prox;
  }
  public int removerInicio(){
    int valor = primeiro.elemento;
    Celula i = primeiro;
    primeiro = primeiro.prox;
    i.prox = null;
    return valor;
  }
  public int removerFim()throws Exception{
    // verifica se a lista ta vazia
    if (primeiro == ultimo) {
      throw new Exception("erro, lista vazia");
    }
    Celula i;
    // chega no final da lista
    for ( i = primeiro; i.prox != ultimo ; i = i.prox);
    // guarda o valor da celula
    int elemento = ultimo.elemento;
    // retira o ponteiro da celula, para desaclopar ela da lista
    ultimo = i;
    // aponta a celula temporaria para nada
    i = ultimo.prox = null;
    return elemento;

  }// !end removerFim()
  public void inserir (int x, int pos)throws Exception{
    int tamanho = tamanho();
    if (pos < 0 || pos > tamanho) {
      throw new Exception("erro");
    }else if (pos == 0) {
      inserirInicio(x);
    }else if (pos == tamanho) {
      inserirFim(x);
    }else{
      Celula i = primeiro;
      for (int j = 0; j < pos; j++) {
        i = i.prox;
      }
      Celula tmp = new Celula(x);
      tmp.prox = i.prox;
      i.prox = tmp;
      i = tmp = null;
    }
  }// !end inserir
  public int remover (int pos){
    Celula i = primeiro;
    for (int j=0; j < pos; j++) {
      i = i.prox;
    }
    int elemento = (i.prox).elemento;
    ultimo = i;
    i.prox = null;
    return elemento;
  }
  public void mostrar(){}
  public int tamanho() {
    int tamanho = 0; 
    for(Celula i = primeiro; i != ultimo; i = i.prox, tamanho++);
    return tamanho;
  }
}

// listas duplas encadeadas

class CelulaDupla{
  public int elemento;
  public CelulaDupla prox, ant;
  public CelulaDupla(){
    this.elemento = 0;
  }
  public CelulaDupla(int x){
    this.elemento = x;
    this.prox = this.ant = null;
  }
}

class ListaDupla{
  private CelulaDupla primeiro;
  private CelulaDupla ultimo;

  public ListaDupla(){
    primeiro = new CelulaDupla();
    ultimo = primeiro;
  }

  public void inserir(int x){
    // crio uma nova celula, com o valor 3 ja nela
    CelulaDupla tmp = new CelulaDupla(x);
    // faco a celula tmp apntar para o primeiro valor e para o segundo valor da lista
    tmp.ant = primeiro;
    tmp.prox = primeiro.prox;
    // faco o ponteiro de primeiro aponar para um novo valor que foi inserido
    primeiro.prox = tmp;
    // o segundo ponteiro, o que vai para frente, aponta para a celula tmp, caso nao tenha nenhum valor
    // e apontado para ele mesmo
    if (primeiro == ultimo) {
      ultimo = tmp;
    }else{
      tmp.prox.ant = tmp;
    }
    // desaloco o ponteiro temp
    tmp = null;
  }// !end inserir
  public void inserirFim(int x){
    // crio uma nova celula que vai ser inserida no fim
    ultimo.prox = new CelulaDupla(x);
    // o ponteiro da nova celula criada (o que aponta para tras) vai apotar para ultima celula criada
    ultimo.prox.ant = ultimo;
    // o ponteiro ultimo e colocado na ultima celula que inserimos
    ultimo = ultimo.prox;
  }//!end inserirFim
  public int removerInicio()throws Exception{
    // Verificando se a lista está vazia:
    if(primeiro == ultimo){
      throw new Exception("erro");
    }
    // Guardando o no a ser removido em uma variável temporária:
    CelulaDupla tmp = primeiro;
    // Atualizando o ponteiro primeiro
    primeiro = primeiro.prox;
    // Armazenando o elemento do novo primeiro no
    int elemento = primeiro.elemento;
    // Remov!endo as referências do no removido
    tmp.prox = primeiro.ant = null;
    // Remov!endo as referências do no removido
    tmp = null;
    return elemento;
  }//!end removerInicio
  public int removerFim()throws Exception{
    // Verificando se a lista está vazia
    if (primeiro == ultimo) {
      throw new Exception("erro");
    }
    // Verificando se a lista está vazia
    int elemento = ultimo.elemento;
    // Verificando se a lista está vazia
    ultimo = ultimo.ant;
    // Remov!endo as referências do nó removidopro
    ultimo.prox.ant = null;
    ultimo.prox = null;
    // reotorno
    return elemento;
  }//!end removerFim
  public void inserir(int x, int pos) throws Exception {
    // pegar o tamanho final da lista
    int tamanho = tamanho();
    if (pos < 0 || pos > 0) {
      throw new Exception("erro, lista vazia");
    }else if (pos == 0) {
      inserir(x);
    }else if (pos == tamanho) {
      inserirFim(x);
    }else{
      CelulaDupla i = primeiro;
      for (int j = 0; j < pos; j++, i = i.prox);
      CelulaDupla tmp = new CelulaDupla(x);
      tmp.ant = i;
      tmp.prox = i.prox;
      tmp.ant.prox = tmp.prox.ant = tmp;
      tmp = i = null;
    }
  } // !end inserir
  public int tamanho() {
    int tamanho = 0; 
    for(CelulaDupla i = primeiro; i != ultimo; i = i.prox, tamanho++);
    return tamanho;
  }//! end tamanho
  public int remover(int pos){
    CelulaDupla i = primeiro;
    for(int j=0; j < pos; j++){
      i = i.prox;
    }
    int elemento = (i.prox).elemento;
    ultimo.ant = null;
    ultimo = i.prox;
    i.prox = null;   
    return elemento;
  }
  public void mostrar(){}
}