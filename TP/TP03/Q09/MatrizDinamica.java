
class CelulaMatriz {
    int elemento;
    CelulaMatriz esq, dir, sup, inf;

    CelulaMatriz() {
        this(0);
    }

    CelulaMatriz(int elemento) {
        this(elemento, null, null, null, null);
    }

    CelulaMatriz(int elemento, CelulaMatriz esq, CelulaMatriz dir, CelulaMatriz sup, CelulaMatriz inf) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
        this.sup = sup;
        this.inf = inf;
    }
}

class Matriz {
    int linha;
    int coluna;
    CelulaMatriz inicio;

    Matriz() {
        this(0, 0);
    }

    Matriz(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    void inicializarMatriz() {
        CelulaMatriz el = new CelulaMatriz();
        inicio = el;
        CelulaMatriz el2 = inicio;

        for (int j = 1; j < coluna; j++) {
            el.dir = new CelulaMatriz();
            el.dir.esq = el;
            el = el.dir;
        }

        for (int i = 1; i < linha; i++) {
            el2.inf = new CelulaMatriz();
            el2.inf.sup = el2;
            el2 = el2.inf;
            el = el2;

            for (int j = 1; j < coluna; j++) {
                el.dir = new CelulaMatriz();
                el.dir.esq = el;
                el = el.dir;
                el.sup = el.esq.sup.dir;
                el.sup.inf = el;
            }
        }
    }

    void inserir(int array[]) {
        CelulaMatriz el1, u1;
        el1 = u1 = inicio;
        int index = 0;

        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                u1.elemento = array[index++];
                u1 = u1.dir;
            }
            el1 = el1.inf;
            u1 = el1;
        }
    }

    void ler() {
        int x = MyIO.readInt();
        CelulaMatriz u = new CelulaMatriz(x);
        inicio = u;
        CelulaMatriz y = inicio;

        for (int j = 1; j < coluna; j++) {
            x = MyIO.readInt();
            u.dir = new CelulaMatriz(x);
            u.dir.esq = u;
            u = u.dir;
        }

        for (int i = 1; i < linha; i++) {
            x = MyIO.readInt();
            y.inf = new CelulaMatriz(x);
            y.inf.sup = y;
            y = y.inf;
            u = y;

            for (int j = 1; j < coluna; j++) {
                x = MyIO.readInt();
                u.dir = new CelulaMatriz(x);
                u.dir.esq = u;
                u = u.dir;
                u.sup = u.esq.sup.dir;
                u.sup.inf = u;
            }
        }
    }

    void mostrar() {
        CelulaMatriz y = inicio;
        CelulaMatriz u = inicio;
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                System.out.print(u.elemento + " ");
                u = u.dir;
            }
            System.out.println();
            y = y.inf;
            u = y;
        }
    }

    Matriz soma(Matriz m2) {
        CelulaMatriz y1, y2, u1, u2;
        y1 = u1 = this.inicio;
        y2 = u2 = m2.inicio;
        int index = 0;
        int tmp[] = new int[linha * coluna];

        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                tmp[index++] = u1.elemento + u2.elemento;
                u1 = u1.dir;
                u2 = u2.dir;
            }
            y1 = y1.inf;
            u1 = y1;
            y2 = y2.inf;
            u2 = y2;
        }

        Matriz soma = new Matriz(linha, coluna);
        soma.inicializarMatriz();
        soma.inserir(tmp);
        return soma;
    }

    void mostrarDiagonalPrincipal() {
        CelulaMatriz u, y;
        u = y = inicio;

        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                if (i == j)
                    System.out.print(u.elemento + " ");
                u = u.dir;
            }
            y = y.inf;
            u = y;
        }
        System.out.println();
    }

    void mostrarDiagonalSecundaria() {
        CelulaMatriz u, y;
        u = y = inicio;

        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                if (i + j == linha - 1)
                    System.out.print(u.elemento + " ");
                u = u.dir;
            }
            y = y.inf;
            u = y;
        }
        System.out.println();
    }

    Matriz multiplicacao(Matriz m2) {
        CelulaMatriz y1, y2, u1, u2;
        y1 = u1 = this.inicio;
        y2 = u2 = m2.inicio;
        int index = 0;
        int tmp[] = new int[linha * coluna];

        for (int i = 0; i < coluna; i++) {
            for (int t = 0; t < linha; t++) {
                for (int j = 0; j < linha; j++) {
                    tmp[index] += u1.elemento * y2.elemento;
                    u1 = u1.dir;
                    y2 = y2.inf;
                }
                index++;
                u1 = y1;
                u2 = u2.dir;
                y2 = u2;
            }
            y1 = y1.inf;
            u1 = y1;
            u2 = y2 = m2.inicio;
        }

        Matriz multi = new Matriz(linha, coluna);
        multi.inicializarMatriz();
        multi.inserir(tmp);
        return multi;
    }
}
class MatrizDinamica {

    public static void main(String args[]) {
        int casos = MyIO.readInt();

        for (int i = 0; i < casos; i++) {
            int lin = MyIO.readInt();
            int col = MyIO.readInt();
            Matriz m1 = new Matriz(lin, col);
            m1.ler();

            lin = MyIO.readInt();
            col = MyIO.readInt();
            Matriz m2 = new Matriz(lin, col);
            m2.ler();

            Matriz soma = m1.soma(m2);
            m1.mostrarDiagonalPrincipal();
            m1.mostrarDiagonalSecundaria();
            soma.mostrar();

            Matriz multiplicacao = m1.multiplicacao(m2);
            multiplicacao.mostrar();
        }
    }
}