package sorting;

import java.util.ArrayList;

public class MergeSort {
    static void merge(int[] arr, int low, int mid, int high){
        // Your code here
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
    static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2 ;
        mergeSort(arr, low, mid);  // left half
        mergeSort(arr, mid + 1, high); // right half
        merge(arr, low, mid, high);
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,4,2,5,3};
        mergeSort(arr,0,arr.length-1);
        for(int a : arr) {
            System.out.print(a);
        }
    }
}
