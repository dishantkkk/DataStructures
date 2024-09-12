package sorting;

public class RecursiveBubbleSort {
    static void bubble_sort(int[] arr, int n) {
        if (n == 1) return;
        for (int j = 0; j <= n - 2; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        bubble_sort(arr, n - 1);
    }
    static void bubble_sort_optimised(int[] arr, int n) {
        if (n == 1) return;
        int didSwap = 0;
        for (int j = 0; j <= n - 2; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                didSwap = 1;
            }
        }
        if (didSwap == 0) return;
        bubble_sort_optimised(arr, n - 1);
    }
    public static void main(String args[]) {
        int arr[] = {13, 46, 24, 52, 20, 9};
//        bubble_sort(arr, arr.length);
        bubble_sort_optimised(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
