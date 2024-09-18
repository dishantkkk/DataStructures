package array.easy;

public class LargestElementInArray {
    public static int largest(int n, int[] arr) {
        // code here
        int max = arr[0];
        for(int i=1;i<n;i++) {
            if(arr[i]>max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,6,1,2};
        System.out.println(largest(5, arr));
    }
}
