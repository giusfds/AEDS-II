import java.util.Scanner;
import java.util.ArrayList;

public class a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int teste = 1;
        while (true) {
            // p == praia 
            int P = scanner.nextInt(); 
            // s == sorveteiros
            int S = scanner.nextInt(); 
            // verificar se os valores lifos sao validos
            if (P == 0 && S == 0) 
                break;
            // lista com os sorveteiros e os seus locais de trabanho U/V
            ArrayList<Integer[]> sorveteiros = new ArrayList<>();
            // para cada sorveteiro, saber o local que ele trabalha
            for (int i = 0; i < S; i++) {
                int U = scanner.nextInt();
                int V = scanner.nextInt();
                sorveteiros.add(new Integer[]{U, V});
            }
            // saida obrigatoria
            System.out.println("Teste " + teste++);
            // pegando os intervalos do tempo de trabalho
            ArrayList<Integer[]> intervalos = new ArrayList<>();
            // colocando valores menores do que o posivel -int
            int inicio = -1;
            int fim = -1;
            // percorrendo os sorveteiros
            for (Integer[] sorveteiro : sorveteiros) {
                // vendo se tem algum sorveteiro perto do fim
                if (sorveteiro[0] > fim) {
                    if (inicio != -1)
                        intervalos.add(new Integer[]{inicio, fim});
                    inicio = sorveteiro[0];
                    fim = sorveteiro[1];
                } else if (sorveteiro[1] > fim) {
                    fim = sorveteiro[1];
                }
            }
            // vendo se a pilha nao ta vaizia 
            if (inicio != -1)
                intervalos.add(new Integer[]{inicio, fim});
            // printando a saida esperada
            for (Integer[] intervalo : intervalos) {
                System.out.println(intervalo[0] + " " + intervalo[1]);
            }
        }
        scanner.close();
    }
}
