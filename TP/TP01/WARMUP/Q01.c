#include <stdio.h>
#include <string.h>
#include <ctype.h>

#define MAXLEN 1000;

int getArgs ( char *principal, char *str){
    int cont = 0;
    for (int i = 0; i < strlen(principal); i++)
    {
        if ( principal[i] == '[' )
        {
            if ( !( principal[i] == ']' ) )
            {
                cont++;
                     
            }
            
        }
        
    }
    return cont;
}

// This_is_a_[Beiju]_text

//            Beiju


int main() {

    char str[MAXLEN];
    char algumacoisa[MAXLEN];
    fgets(str, MAXLEN, stdin);
    int agrs = getArgs(&str, &algumacoisa)
    
    printf("%s%s\n", algumacoisa, str);

    return 0;
}