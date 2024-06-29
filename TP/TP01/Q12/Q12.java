import java.util.Scanner;

public class Q12 {
    public static void main ( String[] args ) {
        String str = new String( );
        String newStr = new String( );

        do {
            str = MyIO.readLine( );

            if ( !( str.equals( "FIM" ) ) ) {
                newStr = criptografar( str, 0 );
                MyIO.println ( newStr );
            }
        } while ( !( str.equals( "FIM" ) ) ); 
    } 
    public static String criptografar( String str, int pos ) {
        
        String newStr = new String( );

        
        if ( pos == str.length( ) ) {
            newStr =  newStr;
        } else {
            newStr = newStr + ( char ) ( str.charAt( pos ) + 3 ) + criptografar( str, pos + 1 );
        } 

        
        return ( newStr );
    } 
}