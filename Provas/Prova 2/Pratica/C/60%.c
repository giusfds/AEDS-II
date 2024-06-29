#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

// saida:
// 3
// 3
// 3

typedef struct No {
    int valor;
    struct No* next;
} No;

No* criarNo(int valor) {
    No* novoNo = (No*)malloc(sizeof(No));
    novoNo->valor = valor;
    novoNo->next = NULL;
    return novoNo;
}

typedef struct {
    No* topo;
    int min;
} Pilha;

void iniciar(Pilha* pilha) {
    pilha->topo = NULL;
    pilha->min = INT_MAX;
}

int isEmpty(Pilha* pilha) {
    return pilha->topo == NULL;
}

void push(Pilha* pilha, int valor) {
    No* novoNo = criarNo(valor);
    novoNo->next = pilha->topo;
    pilha->topo = novoNo;
    if (valor < pilha->min)
        pilha->min = valor;
}

void pop(Pilha* pilha) {
    if (isEmpty(pilha)) {
        printf("EMPTY\n");
        return;
    }
    No* temp = pilha->topo;
    pilha->topo = pilha->topo->next;
    free(temp);
    if (pilha->topo == NULL) {
        pilha->min = INT_MAX;
    } else {
        int min = INT_MAX;
        No* current = pilha->topo;
        while (current != NULL) {
            if (current->valor < min)
                min = current->valor;
            current = current->next;
        }
        pilha->min = min;
    }
}

int getMin(Pilha* pilha) {
    if (isEmpty(pilha)) {
        printf("EMPTY\n");
        return -1;
    }
    return pilha->min;
}

int main() {
    int N;
    scanf("%d", &N);

    Pilha pilha;
    iniciar(&pilha);

    for (int i = 0; i < N; i++) {
        char operacao[4];
        scanf("%s", operacao);

        if (operacao[0] == 'P') {
            int valor;
            scanf("%d", &valor);
            push(&pilha, valor);
        } else if (operacao[0] == 'M') {
            printf("%d\n", getMin(&pilha));
        } else {
            pop(&pilha);
        }
    }

    return 0;
}
