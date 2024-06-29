public class Hash {
  int tabela[];
  int tamanhoTabela;
  final int NULO = -1;

  // metodo de iniciar a tabela com espaco 13 dentro dela
  public Hash(){
    this(13)
  }

  // iniciando os valores da hash, de acordo com o tamanho que inicializamos ela
  public Hash(int len){
    this.tamanhoTabela = len;
    this.tabela = new int[this.tamanhoTabela];
    for (int i = 0; i < len; i++) {
      tabela[i] = NULO;
    }
  }

  // metodo de saber onde fica o elemento da hash
  public int hash(int elemento) {
    return elemento % tamanhoTabela;
  }

  // metodo de rehash da tabela
  public int rehash(int elemento) {
    return ++elemento % tamanhoTabela;
  }

}
