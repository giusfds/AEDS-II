#include <stdio.h>
#include <math.h>


int main() {

    int y =2;
    int n = 4;
    int v = 0;
    int numero = 1234;

    int potencia = 0;

    for (int i = 0; i < n; i++)
    {
        int c = numero % 10;
        numero /= 10;
        if (i != y)
        {
            v += c * pow (10, potencia++);
        }
        
    }
    printf("%d\n", v);

    printf("\n\n--------- | FIM DO PROGRAMA | ---------\n\n");
    return 0;
}