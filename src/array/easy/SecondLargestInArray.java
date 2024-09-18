package array.easy;

public class SecondLargestInArray {
    public static int print2largest(int[] arr) {
        // Code Here
        int n = arr.length;
        if (n == 0 || n==1){
            return -1;
        }
        int large = Integer.MIN_VALUE;
        int second_large = Integer.MIN_VALUE;
        int i;
        for (i = 0;i < n;i++) {
            large = Math.max(large,arr[i]);
        }
        for (i = 0;i < n;i++) {
            if (arr[i] > second_large && arr[i] != large){
                second_large = arr[i];
            }
        }
        return second_large;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,6,9,2,1};
        System.out.println(print2largest(arr));
    }
}
