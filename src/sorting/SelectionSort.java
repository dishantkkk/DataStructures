package sorting;

public class SelectionSort {
    public static void selectionSort(int[] arr, int n) {
        for(int i=0;i<n-1;i++) {
            int min = i;
            for(int j=i+1;j<n;j++) {
                if(arr[j]<arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        // O(n^2)
    }
    public static void main(String[] args) {
        int[] arr = {8,2,5,4,5};
        selectionSort(arr,arr.length);
        for(int a : arr) {
            System.out.print(a+" ");
        }
    }
}
