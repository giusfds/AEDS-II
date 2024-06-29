#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

bool isInteiro( double numero )
{
    bool resultado = false;

    if( numero == (int)numero )
    {
        resultado = true;
    } 
    return ( resultado );
} 

void readFileAndWrite( char* filename, int n )
{
    double num = 0.0;
    int num2 = 0;

    FILE* arquivo = fopen( filename, "rb" );

    fseek( arquivo, 0, SEEK_END );
    double fileSize = ftell( arquivo );
    rewind( arquivo );
    for ( int i = 0; i < n; i = i + 1 ) 
    {
        fseek( arquivo, fileSize - (i + 1) * sizeof(double), SEEK_SET );
        fread( &num, sizeof(double), 1, arquivo );

        if ( isInteiro( num ) ) 
        {
            num2 = (int)num;
            printf( "%d\n", num2 );
        } 
        else 
        {
            printf( "%g\n", num );
        } 
    } 

} 

int main( int argc, char* argv[] )
{
    FILE* arquivo;
    int n = 0;
    double num = 0.0;

    scanf( "%d", &n );

    arquivo = fopen( "Questao09.bin", "wb" );

    for( int i = 0; i < n; i = i + 1 )
    {
        scanf( "%lf", &num );
        fwrite( &num, sizeof(double), 1, arquivo );
    }
    fclose( arquivo );

    readFileAndWrite( "Questao09.bin", n );

    return( 0 );
}