package Provas.P1.selection_sort;

public class Q01 {
    void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void selectionSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            }
            swap(arr, min_idx, i);
        }
    }

    void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        Q01 ob = new Q01();
        int arr[] = {64, 25, 12, 22, 11};
        System.out.println("Array antes do Selection Sort:");
        ob.printArray(arr);
        ob.selectionSort(arr);
        System.out.println("Array depois do Selection Sort:");
        ob.printArray(arr);
    }
}
