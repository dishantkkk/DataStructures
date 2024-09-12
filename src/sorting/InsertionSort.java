package sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr, int n) {
        for(int i = 1; i < n; i++) {
            int a = arr[i];
            for(int j = i; j > 0 && a < arr[j-1]; j--) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
    }

    public static void insertion_sort(int[] arr, int n) {
        for (int i = 0; i <= n - 1; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,6,1,3,8,0};
        insertionSort(arr, arr.length);
        Arrays.stream(arr).forEach(System.out::print);
    }
}
