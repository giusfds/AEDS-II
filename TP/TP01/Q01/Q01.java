
import java.util.Scanner;

public class Q01 {

    public static boolean isPalindromo (String imput){
        StringBuilder frase = new StringBuilder(imput);
        return imput.equals(frase.reverse().toString());
    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String frase;
        while (!(frase = sc.nextLine()).equals("FIM")) {
            System.out.println(isPalindromo(frase) ? "SIM" : "NAO");
        }

        sc.close();
    }
}
