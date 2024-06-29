
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int iteracoes = 0;

        for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
            // Troca os elementos arr[j] e arr[j + 1]
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
            }
            iteracoes++;
        }
        }

        System.out.println("Total de iterações: " + iteracoes);
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Array antes do Bubble Sort:");
        printArray(arr);

        bubbleSort(arr);

        System.out.println("Array depois do Bubble Sort:");
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
