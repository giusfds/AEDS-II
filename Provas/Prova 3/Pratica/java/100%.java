import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        // percorrer a string ocntando os valores, a saber quantos assuntos temos em
        // aberto
        while (sc.hasNext()) {
            String S = sc.next();
            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                if (c == '(') {
                    count++;
                } else if (c == ')') {
                    if (count > 0) {
                        count--;
                    }
                }
            }
            // printar a saida necessaria
            if (count == 0) {
                System.out.println("Partiu RU!");
            } else if (count > 0) {
                System.out.println("Ainda temos " + count + " assunto(s) pendente(s)!");
            }
        }

        sc.close();
    }
}
