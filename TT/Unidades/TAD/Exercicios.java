// package Unidades.TAD;

class NO {
    int elemento;
    NO esq;
    NO dir;

    public NO() {
        this(0);
    }

    public NO(int elemento) {
        this.elemento = elemento;
        this.esq = null;
        this.dir = null;
    }
} // end class NO

class Celula {
    int elemento;
    Celula prox;
    NO raiz;

    public Celula() {
        this(0);
    }

    public Celula(int elemento) {
        this.elemento = elemento;
        this.prox = null;
        this.raiz = null;
    }
} // end class Celula

class Lista {
    private Celula primeiro;
    private Celula ultimo;

    Lista() {
        Celula j = new Celula();
        primeiro = j;
        ultimo = primeiro;
        for (int i = 0; i < 10; i++, j = j.prox) {
            // System.out.print(j.elemento + "" );
            j.prox = new Celula(i);
            ultimo = j.prox;
        }
    }

    public void mostrar() {
        System.out.println("{");
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            System.out.print(" " + i.elemento + ": ");
            mostrarNO(i.raiz);
            System.out.println( " " );
        }
        System.out.println("}");
    }

    public void mostrarNO(NO i) {
        if (i != null) {
            mostrarNO(i.esq);
            System.out.print( " " + i.elemento + " ");
            mostrarNO(i.dir);
        }
    }

    public void inserir(int elemento) {
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            if (i.elemento == (elemento / 10)) {
                i.raiz = inserirNo(elemento, i.raiz);
            }
        }
    }

    private NO inserirNo(int elemento, NO i) {
        // System.out.println(elemento + " ");
        if (i == null) {
            i = new NO(elemento);
            // System.out.println(elemento + " ");
        } else if (elemento < i.elemento) {
            i.esq = inserirNo(elemento, i.esq);
            // System.out.println(elemento + " ");
        } else if (elemento > i.elemento) {
            i.dir = inserirNo(elemento, i.dir);
            // System.out.println(elemento + " ");
        } else {
            //
            System.err.println("ERRO");
        }
        return i;
    }
} // end class Lista

public class Exercicios {
    public static void main(String[] args) {
        Lista lista = new Lista();
        System.out.println("Ao criar a lista de arvore: ");
        lista.mostrar();
        for( int i = 0; i < 100; i++ ){
            lista.inserir(i);
        }
        System.out.println("Depois das insercoes: ");
        lista.mostrar();

    }
}