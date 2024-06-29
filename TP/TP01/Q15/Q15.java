import java.util.Scanner;

public class Q15 {
    public static void main ( String[] args ) {
        String str;
        Scanner reader = new Scanner ( System.in );
        boolean x1;
        boolean x2;
        boolean x3;
        boolean x4;
        String x1a;
        String x2a;
        String x3a;
        String x4a;

        do {
            str = reader.nextLine( );

            if ( !( str.equals( "FIM" ) ) ) {

                x1 = somenteVogais( str, 0 );
                x2 = somenteConsoantes( str, 0 );
                x3 = isInteiro( str, 0 );
                x4 = isReal( str, 0, 0, 0 );

                if ( x1 == true ) {
                    x1a = "SIM";
                } else {
                    x1a = "NAO";
                } 
                if ( x2 == true ) {
                    x2a = "SIM";
                } else {
                    x2a = "NAO";
                } 
                if ( x3 == true ) {
                    x3a = "SIM";
                } else {
                    x3a = "NAO";
                } 
                if ( x4 == true ) {
                    x4a = "SIM";
                } else {
                    x4a = "NAO";
                } 


                System.out.println ( x1a + " " + x2a + " " + x3a + " " + x4a );
            } 
        } while ( !( str.equals( "FIM" ) ) );
    }
    public static boolean somenteVogais( String str, int pos ) {

        boolean resultado = true;


        if ( pos == str.length( ) ) {
            resultado = true;
        } else if ( isInString( "AEIOUaeiou", str.charAt(pos) ) == false ) {
            resultado = false;
        } else {
            resultado = somenteVogais( str, pos + 1 );
        } 
        return ( resultado );
    }
    public static boolean somenteConsoantes( String str, int pos ) {
        boolean resultado = true;

        if ( pos == str.length( ) ) {
            resultado = true;
        } else if ( isInString( "BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz", str.charAt(pos) ) == false ) {
            resultado = false;
        } else {
            resultado = somenteConsoantes( str, pos + 1 );
        } 
        return ( resultado );
    }

    public static boolean isInteiro( String str, int pos ) {
        boolean resultado = true;

        if ( pos == str.length( ) ) {
            resultado = true;
        } else if ( !( '0' <= str.charAt(pos) && str.charAt(pos) <= '9' ) ) {
            resultado = false;
        } else {
            resultado = isInteiro( str, pos + 1 );
        }
        return ( resultado );
    } 


    public static boolean isReal( String str, int pos, int contaV, int contaP ) {
        boolean resultado = true;

        if ( pos == str.length( ) ) {
            resultado = true;
        } else if ( !( '0' <= str.charAt(pos) && str.charAt(pos) <= '9' || str.charAt(pos) == ',' || str.charAt(pos) == '.' ) ) {
            resultado = false;
        } else if ( str.charAt(pos) == ',' ) {
            resultado = isReal( str, pos + 1, contaV + 1, contaP );
        } else if ( str.charAt(pos) == '.' ) {
            resultado = isReal( str, pos + 1, contaV, contaP + 1 );
        } else if ( contaP > 1 ) {
            resultado = false;
        } else if ( contaV > 1 ) {
            resultado = false;
        } else {
            resultado = isReal( str, pos + 1, contaV, contaP );
        } 
        return ( resultado );
    }

    public static boolean isInString ( String str, char caracter ) {
        boolean resultado = false;

        for ( int i = 0; i < str.length( ); i = i + 1 ) {

            if ( caracter == str.charAt(i) ) {
                resultado = true;
            } 
        } 

        return ( resultado );
    } 
}