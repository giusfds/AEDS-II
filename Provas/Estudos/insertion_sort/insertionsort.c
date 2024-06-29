#include <stdio.h>
#include <stdlib.h>

void insertionSort (int arr[], int n){
    for (int i = 0; i < n; i++)
    {
        int j = i;
        while (j > 0 && arr[j-1]> arr[j])
        {
            int temp = arr[j-1];
            arr[j-1] = arr[j];
            arr[j] = temp;
            j--;
        }
        
    }
    
}

int main() {

    int array[] = {9,4,5,6,3,2,2,33,5,7,8,9};
    int n = sizeof(array)/sizeof(array[0]);
    insertionSort(array, n);

    for (int i = 0; i < n; i++)
    {
        printf("%d ",array[i]);
    }
    

    printf("\n\n--------- | FIM DO PROGRAMA | ---------\n\n");
    return 0;
}