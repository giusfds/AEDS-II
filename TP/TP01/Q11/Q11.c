#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

bool isPalindromo ( char* cadeia, int pos ) 
{
    bool resp = true;
    
    if (pos == strlen(cadeia)){
        resp = true;
    }else if (cadeia[pos] != cadeia[strlen(cadeia) - pos - 1]) {
        resp = false;
    }else{
        resp = isPalindromo(cadeia, pos + 1);
    } 
    return (resp);
}

int main ( int agrc, char* argv )
{
    char* cadeia = (char*)malloc(1000*sizeof(char));
    while (strcmp(cadeia,"FIM"))
    {
        scanf ( " %[^\n]",cadeia);
        if ( strcmp(cadeia,"FIM") ) 
        {
            if ( isPalindromo(cadeia,0) == true ){
                printf ( "SIM\n" );
            }else{
                printf ( "NAO\n" );
            } 
        } 
    }
    return (0);
}