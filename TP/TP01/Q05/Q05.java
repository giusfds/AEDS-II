import java.util.Scanner;

public class Q05 {

    public static int parseInt(char str) {
        int qnt = str - 48;
        return qnt;
    }

    public static boolean parseBoolean(char str) {
        return str != '0';
    }

    public static String substring(String str, int start, int end) {
        String newStr = new String();

        for (int i = start; i < end; i++) {
            newStr += str.charAt(i);
        }

        return newStr;
    }

    public static String replace(String str, int star, int end, String subReplace) {
        // separando as beradas da string, o que eu quero manter
        String newStr1 = substring(str, 0, star);
        String newStr2 = substring(str, end, str.length());

        // nova string
        return newStr1 + subReplace + newStr2;
    }

    public static char[] getArgs(String str, int index) {

        int contador = 0;

        // descobrindo o tamanho do vetor para colocar os valores boolean dentro

        for (int i = index + 1; str.charAt(i) != ')'; i++) {
            if (str.charAt(i) == '0' || str.charAt(i) == '1') {
                contador++;
            }
        }

        char[] args = new char[contador];

        // criei um vetor para colocar os valores boolean que ja tinha alterado antes

        for (int i = index + 1, j = 0; str.charAt(i) != ')'; i++) {
            if (str.charAt(i) == '0' || str.charAt(i) == '1') {
                args[j] = str.charAt(i);
                j++;
            }
        }

        return args;
    }

    public static char not(char[] args) {

        if (args[0] == '0') {
            return '1';
        } else if (args[0] == '1') {
            return '0';
        }
        return 0;

    }

    public static char and(char[] args) {

        for (int i = 0; i < args.length; i++) {
            if (args[i] == '0') {
                return '0';
            }
        }
        return '1';

    }

    public static char or(char[] args) {

        for (int i = 0; i < args.length; i++) {
            if (args[i] == '1') {
                return '1';
            }
        }
        return '0';

    }

    public static String solveEquation(String str) throws Exception {

        char[] args;
        char result;
        int end;

        for (int i = (str.length() - 1); i >= 0; i--) {
            if (str.charAt(i) == '(') {
                switch (str.charAt(i - 1)) {
                    case 'd':
                        args = getArgs(str, i);
                        result = and(args);
                        // achar o ')'
                        for (end = i; str.charAt(end) != ')'; end++)
                            ;
                        str = replace(str, i - 3, end + 1, result + "");
                        i -= 3;
                        break;
                    case 't':
                        args = getArgs(str, i);
                        result = not(args);
                        str = replace(str, i - 3, i + 3, result + "");
                        i -= 3;
                        break;
                    case 'r':
                        args = getArgs(str, i);
                        result = or(args);
                        // achar o ')'
                        for (end = i; str.charAt(end) != ')'; end++)
                            ;
                        str = replace(str, i - 2, end + 1, result + "");
                        i -= 2;
                        break;

                    default:
                        throw new Exception("FUDEU");
                }
            }
        }

        return substring(str, 0, 1);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // ler a string
        String str = sc.nextLine();

        while (str.charAt(0) != '0') {
            // passar a quantidade de string to int (stoi)
            int qnt = parseInt(str.charAt(0));

            // criar vetor com a quantidade de vartiaveis que precisa
            boolean[] vetor = new boolean[qnt];

            // colocar no vetor os valores corretos, A B C respectivamente

            if (qnt == 2) {
                vetor[0] = parseBoolean(str.charAt(2));
                vetor[1] = parseBoolean(str.charAt(4));
                // tirando o que nao importa mais
                str = substring(str, 6, str.length());

            } else if (qnt == 3) {
                vetor[0] = parseBoolean(str.charAt(2));
                vetor[1] = parseBoolean(str.charAt(4));
                vetor[2] = parseBoolean(str.charAt(6));
                // tirando o que nao importa mais
                str = substring(str, 8, str.length());
            }

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'A') {
                    str = replace(str, i, i + 1, vetor[0] == false ? "0" : "1");
                } else if (str.charAt(i) == 'B') {
                    str = replace(str, i, i + 1, vetor[1] == false ? "0" : "1");
                } else if (str.charAt(i) == 'C') {
                    str = replace(str, i, i + 1, vetor[2] == false ? "0" : "1");
                }
            }
            str = solveEquation(str);
            System.out.println(str);

            str = sc.nextLine();
        }

        sc.close();
    }

}