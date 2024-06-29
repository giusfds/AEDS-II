public class HashCReserva {
  int tabela[];
  int m1, m2, m, reserva;
  final int NULO = -1;

  public HashCReserva(){
    this(13, 7);
  }

  public HashCReserva(int m1, int m2){
    // tamanho da tabela
    this.m1 = m1;
    // tamanho da reserva
    this.m2 = m2;
    //  tamanho da tabela + reserva
    this.m = m1 + m2;
    reserva = 0;
    // iniciar a tabela
    for (int i = 0; i < m1; i++) {
      tabela[i] = NULO;
    }
  }

  public int h (int elemento){
    return elemento % m1;
  }

  public boolean inserir(int elemento){
    boolean resp = false;
    if (elemento != NULO) {
      int pos = h(elemento);
      if (tabela[pos] == NULO) {
        tabela[pos] = elemento;
        resp = true;
      }else if (reserva < m2){
        tabela[m1 + reserva] = elemento;
        reserva ++;
        resp = true;
      }
    }
    return resp;
  }

  public boolean pesquisar(int elemento){
    boolean resp = false;
    int pos = h(elemento);
    if (tabela[pos] == elemento) {
      resp = true;
    }else if (tabela[pos] != NULO) {
      for (int i = 0; i < reserva; i++) {
        if (tabela[m1+i] == elemento) {
          resp = true;
          i = reserva; // AKA: break
        }
      }
    }
    return resp;
  }
}