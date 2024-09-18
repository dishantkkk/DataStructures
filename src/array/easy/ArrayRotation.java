package array.easy;

public class ArrayRotation {
    public static void rotateToTight(int[] arr, int n, int k) {
        if (n == 0)
            return;
        k = k % n;
        if (k > n)
            return;
        int[] temp = new int[k];
        for (int i = n - k; i < n; i++) {
            temp[i - n + k] = arr[i];
        }
        for (int i = n - k - 1; i >= 0; i--) {
            arr[i + k] = arr[i];
        }
        for (int i = 0; i < k; i++) {
            arr[i] = temp[i];
        }
    }
    public static void rotateToLeft(int[] arr, int n, int k) {
        if (n == 0)
            return;
        k = k % n;
        if (k > n)
            return;
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }
        for (int i = 0; i < n - k; i++) {
            arr[i] = arr[i + k];
        }
        for (int i = n - k; i < n; i++) {
            arr[i] = temp[i - n + k];
        }
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    // Function to Rotate k elements to right
    public static void rotateToRightUsingReverse(int[] arr, int n, int k) {
        // Reverse first n-k elements
        reverse(arr, 0, n - k - 1);
        // Reverse last k elements
        reverse(arr, n - k, n - 1);
        // Reverse whole array
        reverse(arr, 0, n - 1);
    }

    public static void rotateToLeftUsingReverse(int[] arr, int n, int k) {
        // Reverse first k elements
        reverse(arr, 0, k - 1);
        // Reverse last n-k elements
        reverse(arr, k , n - 1);
        // Reverse whole array
        reverse(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        rotateToTight(arr, arr.length, 3);
        for(int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
        rotateToLeft(arr, arr.length, 3);
        for(int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
        rotateToRightUsingReverse(arr, arr.length, 3);
        for(int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
        rotateToLeftUsingReverse(arr, arr.length, 3);
        for(int a : arr) {
            System.out.print(a + " ");
        }
    }
}
