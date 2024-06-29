class Celula {
  int elemento;
  Celula prox;
  Pilha topo1;

  public Celula() {
      this(0);
  }

  public Celula(int elemento) {
      this.elemento = elemento;
      this.prox = null;
      this.topo1 = null;
  }
} // end class Celula

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
}


public class Prova1 {

}
