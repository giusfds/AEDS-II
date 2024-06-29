
public class HashCRhash {
    int tabela[];
    int m;
    final int NULO = -1;

    public HashCRhash() {
        this(13);
    }

    // construtor padarao, para iniciar a tabela com elementos negativos
    public HashCRhash(int m) {
        this.m = m;
        this.tabela = new int[this.m];
        for (int i = 0; i < m; i++) {
            tabela[i] = NULO;
        }
    }

    // metodo para saber onde o elemento vai ficar
    public int h(int elemento) {
        return elemento % m;
    }

    // metodo para saber onde o elemento vai ficar se o local ja estiver cheio
    public int reh(int elemento) {
        return ++elemento % m;
    }

    // inserir o elemento na tabela
    public boolean inserir(int elemento){
        boolean resp = false;
        //  verificar se o elemento da tabela tem colisao
        if (elemento == NULO) {
            // pego a posicao do elemento
            int pos = h(elemento);
            // verifico se o elemento na posicao hash, para colocar o elemento
            if (tabela[pos] == NULO) {
                tabela[pos] = elemento;
                resp = true;
            } else {
                // se o elemento tiver cheio, temos que colocar ele na rehash
                pos = reh(elemento);
                if (tabela[pos] == NULO) {
                    // verifica se o valor da rehash ta disponivel
                    tabela[pos] = elemento;
                    resp = true;
                }
            }
        }
        return resp;
    }

    public boolean pesquisar(int elemento){
        int pos = h(elemento);
        boolean resp = false;
        if (tabela[pos] == elemento) {
            resp = true;
        }else if (tabela[pos] != NULO) {
            pos = reh(elemento);
            if (tabela[pos] == elemento) {
                resp = true;
            }
        }
        return resp;
    }

    public boolean remover(int elemento){
        int pos = h(elemento);
        boolean resp = false;
        if (tabela[pos] == elemento) {
            tabela[pos] = NULO;
            resp = true;
        }
        return resp;
    }

}