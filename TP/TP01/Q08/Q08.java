import java.io.*;

public class Q08 {
    public static void main ( String[] args ) throws Exception {
        RandomAccessFile raf = new RandomAccessFile( "Questao08.txt", "rw" );
        int n = 0;
        double numero = 0.0;
        n = MyIO.readInt( );
        for( int i = 0; i < n; i = i + 1 ) {
            numero = MyIO.readDouble( );
            raf.writeDouble( numero );
        } 
        // Arq.close( ); 
        lerDeArquivoEEscrever( "Questao08.txt", n );

    }
    public static void lerDeArquivoEEscrever( String filename, int quantidade ) throws Exception {
        RandomAccessFile raf = new RandomAccessFile( filename, "rw" );
        double numero = 0.0;
        for( int i = quantidade * 8 - 1; i >= 0; i = i - 1 ) {
            if( i % 8 == 0 || i == 0 ){
                raf.seek(i);
                numero = raf.readDouble( );
                if( isInteiro( numero ) ) {
                    System.out.println( (int)numero );
                } else {
                    System.out.println( numero );
                }
            } 
        } 
    }
    public static boolean isInteiro( double n ) {
        boolean resultado = false;
        if( n == (int)n ) {
            resultado = true;
        } 
        return ( resultado );
    } 
}