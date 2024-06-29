import java.util.Scanner;

public class Q06 {

    public static char toLower(char c) { return 'A' <= c && c <= 'Z' ? (char)(c + 32) : c; }    
    public static boolean isAlpha(char c) { return 'A' <= c && c <= 'Z' || 'a' <= c && c <= 'z'; }
    public static boolean isNumber(char c){ return '0' <= c && c <= '9'; }

    /**
     * funcao que ve se o caracter esta contido na string
     * @param str
     * @return true / false
     */
    public static boolean contains(String str, char c){
        boolean retsult = false;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == c) {
                retsult = true;
                break;
            }
        }
        return retsult;
    }

    public static boolean isVowel(char c){
        return contains("aeiou", toLower(c));
    }
    public static boolean isConsonant(char c){
        return contains("bcdfghjklmnpqrstwxyz", toLower(c));
    }

    /**
     * funcao queverifica se a str e composta por numeros
     * @param str
     * @return resp
     */
    public static boolean isNumber(String str) {
        boolean resp = true;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (!(str.charAt(i) >= 1 && str.charAt(i) <= 9)) {
                resp = false;
                break;
            }
        }
        return resp;
    }

    /**
     * funcao queverifica se a str tem apenas vogais
     * @param str
     * @return resp
     */
    public static boolean isVowel(String str){
        boolean resp = true;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (isAlpha(c) || isConsonant(c)) {
                resp = false;
                break;
            }
        }
        return resp;
    }

    /**
     * funcao queverifica se a str tem apenas consoantes
     * @param str
     * @return resp
     */
    public static boolean isConsonant(String str){
        boolean resp = false;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (isAlpha(c) || isVowel(c)) {
                resp = false;
                break;
            }
        }
        return resp;
    }   

    /**
     * funcao que altera a string pasada pelo usuario, para os valores que sao passados por parametro
     * @param base o caractere a ser alterado
     * @param change o caractere que vai substituir
     * @param str a tring que e passada
     * @return a string modificada
     */
    public static String replaceString (char base, char change, String str){
        String aux = "";
		int strLen = str.length();
		for (int i = 0; i < strLen; i++) {
			char c = str.charAt(i);
			if (c == base) aux += change;
			else aux += c;
		}
		return aux;
    }

    /**
     * verifica se a string e um ponto flutuante, vendo se eiste mais de um '.' presente na string
     * @param input
     * @return boolean
     */
    public static boolean isFloatingPoint(String input) {
		boolean result = true;
		int len = input.length();
		int dotsCount = 0;
		input = replaceString(',', '.', input);
		for (int i = 0; i < len; i++) {
			char c = input.charAt(i);
			if (c == '.' && ++dotsCount > 1) {
				result = false;
				i = len;
			} else if (!isNumber(c) && c != '.') {
				result = false;
				i = len;
			}
		}
		return result;
	}


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String str;

        while (!(str = sc.nextLine()).equals("FIM")) {
            // vogais // consoantes // int // float    

            System.out.print(isVowel(str) ? "SIM " : "NAO ");
            System.out.print(isConsonant(str) ? "SIM " : "NAO ");
            System.out.print(isNumber(str) ? "SIM " :"NAO ");
            System.out.println(isFloatingPoint(str) ? "SIM" : "NAO");

        }

        sc.close();
    }
}