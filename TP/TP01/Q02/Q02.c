#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int main()
{
    char palavra[1000];
    while (true )
    {
        scanf(" %[^\n]", palavra);

        if (strcmp(palavra, "FIM") == 0)
        {
            break;
        }

        bool resp = true;
        int tam = strlen(palavra);
        int j = tam - 1;
        for (int i = 0; i < (tam / 2); i++)
        {
            if (palavra[i] != palavra[j])
            {
                resp = false;
                break;
            }
            if (j >= 0)
            {
                j--;
            }
            else
            {
                break;
            }
        }
        if (resp == false)
        {
            printf("NAO\n");
        }
        else
        {
            printf("SIM\n");
        }
    }

    return 0;
}