package Unidades.Balanceamento.Alvinegra;

public class NoAN {
  public boolean cor;
  int elemento;
  public NoAN esq, dir;

  public NoAN(){
    this(-1);
  }

  public NoAN(int elemento){
    this(elemento, false, null, null);
  }

  public NoAN(int elemento, boolean cor, NoAN esq, NoAN dir){
    this.cor = cor;
    this.elemento = elemento;
    this.esq = esq;
    this.dir = dir;
  }
}
