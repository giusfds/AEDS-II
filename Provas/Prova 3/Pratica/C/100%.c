#include <stdio.h>
#include <stdlib.h>
typedef struct No {
    int elemento;
    struct No* esq;
    struct No* dir;
} No;

No* novoNo(int elemento) {
    No* no = (No*)malloc(sizeof(No));
    no->elemento = elemento;
    no->esq = no->dir = NULL;
    return no;
}

No* inserir(No* raiz, int elemento) {
    if (raiz == NULL) return novoNo(elemento);
    if (elemento < raiz->elemento)
        raiz->esq = inserir(raiz->esq, elemento);
    else if (elemento > raiz->elemento)
        raiz->dir = inserir(raiz->dir, elemento);
    return raiz;
}

void mostrar(No* raiz) {
    if (raiz == NULL) return;
    No** fila = (No**)malloc(500 * sizeof(No*));
    int start = 0, end = 0;
    fila[end++] = raiz;
    while (start < end) {
    No* atual = fila[start++];
        printf("%d ", atual->elemento);
    if (atual->esq != NULL)
        fila[end++] = atual->esq;
    if (atual->dir != NULL)
        fila[end++] = atual->dir;
    }
    free(fila);
}

int main() {
    int C, N, valor;
    scanf("%d", &C);
    for (int i = 1; i <= C; i++) {
        scanf("%d", &N);
        No* raiz = NULL;
        for (int j = 0; j < N; j++) {
            scanf("%d", &valor);
            raiz = inserir(raiz, valor);
        }
        printf("Case %d:\n", i);
        mostrar(raiz);
        printf("\n\n");    
    }
return 0;
}