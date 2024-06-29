
public class Q1 {

    public static void ordenacaoInsersao(int[] array){
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j >= 0 && array[j-1] > array[j]) {
                int temp = array[j-1];
                array[j-1] = array[j];
                array[j] = temp;
                j--;
            }
        }
    } 

    public static void main(String[] args) {
        int[] array = {9, 4, 5, 6, 3, 2, 2, 33, 5, 7, 8, 9};
        ordenacaoInsersao(array);
        for(int i=0; i < array.length; i++){
            System.out.println(array[i] + " ");
        }
    }
}
