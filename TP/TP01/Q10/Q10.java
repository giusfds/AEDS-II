import java.util.Scanner;

public class Q10 {
    public static void main ( String[] args ) {

        String str;
        Scanner reader = new Scanner ( System.in );

        do {
            str = reader.nextLine( );

            if ( !( str.equals( "FIM" ) ) ) {

                if ( isPalindromo( str, 0 ) == true ) {
                    System.out.println ( "SIM" );
                } else {
                    System.out.println ( "NAO" );
                } 
            } 
        } while ( !( str.equals( "FIM" ) ) );
    }
    public static boolean isPalindromo ( String str, int pos ) {
        boolean resp = true;

        if ( pos == str.length( ) ) {
            resp = true;
        } else if ( str.charAt(pos) != str.charAt(str.length( ) - pos - 1) ) {
            resp = false;
        } else {
            resp = isPalindromo( str, pos + 1 );
        } 

        return ( resp );
    }
}