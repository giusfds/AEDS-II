// bibliotecas
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

bool isInString ( char* str, char caracter ) {

    bool resultado = true;

    for ( int i = 0; i < strlen(str); i = i + 1 ) {

        if ( caracter == str[i] ) {
            resultado = false;
        } 
    } 

    return ( resultado );
} 
void substituicao( char* str, int pos, char caracter, char substituto ) 
{
    if ( pos ==  strlen( str ) ) 
    {
        str = str;
    } 
    else if ( str[pos] != caracter ) 
    {
        str[pos] = str[pos]; 
        substituicao( str, pos + 1, caracter, substituto );
    } 
    else 
    {
        str[pos] = substituto; 
        substituicao( str, pos + 1, caracter, substituto );
    } 
} 

int main ( int argc, char argv ) 
{
    char caracter;
    char substituto;

    char* str = (char*) malloc(1000 * sizeof(char));

    do {

        scanf ( " %[^\n]", str );

        if ( strcmp( str, "FIM" ) != 0 ) {

            caracter = 'a' + ( rand() % 26 );

            substituto = 'a' + ( rand() % 26 );

            substituicao( str, 0, caracter, substituto );

            
            printf( "%s\n", str );
        } 
    } while ( strcmp( str, "FIM" ) != 0 );

    return ( 0 );
} 