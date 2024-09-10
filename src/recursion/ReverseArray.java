package recursion;

import java.util.Arrays;
import java.util.Collections;

public class ReverseArray {
    static void printArray(int[] ans, int n) {
        System.out.print("Reversed array is:- \n");
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
    static void reverseArrayIteratively(int[] arr, int n) {
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            ans[n - i - 1] = arr[i];
        }
        printArray(ans, n);
    }
    static void reverseArrayWithTwoPointers(int[] arr, int n) {
        int p1 = 0, p2 = n - 1;
        while (p1 < p2) {
            int tmp = arr[p1];
            arr[p1] = arr[p2];
            arr[p2] = tmp;
            p1++;
            p2--;
        }
        printArray(arr, n);
    }
    static void reverseArrayRecursively(int[] arr, int start, int end) {
        if (start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            reverseArrayRecursively(arr, start + 1, end - 1);
        }
    }
    static void reverseArrayUsingCollections(Integer[] arr) {
        //fetching array as list object
        //reversing the fetched object
        Collections.reverse(Arrays.asList(arr));
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr = {5,4,3,2,1};
        reverseArrayIteratively(arr, n);
        reverseArrayWithTwoPointers(arr, n);
        Integer[] arr1 = Arrays.stream(arr).boxed().toArray( Integer[]::new );
        reverseArrayUsingCollections(arr1);
        int[] arr2 = Arrays.stream(arr1).mapToInt(Integer::intValue).toArray();
        printArray(arr2, n);
        reverseArrayRecursively(arr, 0, n-1);
        printArray(arr, n);
    }
}
