package Provas.P1.bouble_sort;

public class Q01 {
    // Função para ordenar o array usando Bubble Sort
    public static void bubbleSort(int array[]) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Troca os elementos se estiverem fora de ordem
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Função para imprimir o array
    public static void printArray(int array[]) {
        int n = array.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Método principal (main)
    public static void main(String args[]) {
        int array[] = { 64, 34, 25, 12, 22, 11, 90 };

        System.out.println("Array original:");
        printArray(array);

        bubbleSort(array);

        System.out.println("Array ordenado:");
        printArray(array);
    }
}
