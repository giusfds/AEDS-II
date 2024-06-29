import java.util.Random;
import java.util.Scanner;

public class Q04 {

    public static String substituicaoString(String str, char caracter, char substituto){
        String newStr = new String();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)!= caracter) {
                newStr = newStr + str.charAt(i);
            }else{
                newStr = newStr + substituto;
            }
        }
        return newStr;
    }
    
    public static void main(String[] args) {
        
        char caracter;
        char substituto;

        Random gerador = new Random();
        gerador.setSeed(4);

        Scanner sc = new Scanner(System.in);
        String str;
        String newStr= "";

        while (!(str = sc.nextLine()).equals("FIM")) {
            caracter  =  ( char ) ( 'a' + ( Math.abs( gerador.nextInt( ) ) % 26 ) );
            substituto = ( char ) ( 'a' + ( Math.abs( gerador.nextInt( ) ) % 26 ) );
            newStr = substituicaoString(str, caracter, substituto);
            System.out.println(newStr);
        }
        
    }
    
}
