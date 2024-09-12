package miscellaneous;
import java.util.Arrays;

public class MaxSumSubarray {
    // Function to find the sum of subarray with maximum sum using two for loop
    static int maxSubarraySumTwoFor(int[] arr) {
        int res = arr[0];
        // Outer loop for starting point of subarray
        for (int i = 0; i < arr.length; i++) {
            int currSum = 0;
            // Inner loop for ending point of subarray
            for (int j = i; j < arr.length; j++) {
                currSum = currSum + arr[j];
                // Update res if currSum is greater than res
                res = Math.max(res, currSum);
            }
        }
        return res;
    }
    // Function to find the maximum subarray sum using 1 for loop (Kadane's algorithm)
    static int maxSubarraySum(int[] arr) {
        int res = arr[0];
        int maxEnding = arr[0];
        for (int i = 1; i < arr.length; i++) {
            // Find the maximum sum ending at index i by either extending
            // the maximum sum subarray ending at index i - 1 or by
            // starting a new subarray from index i
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            // Update res if maximum subarray sum ending at index i > res
            res = Math.max(res, maxEnding);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, -8, 7, -1, 2, 3};
        System.out.println(maxSubarraySum(arr));
        System.out.println(maxSubarraySumTwoFor(arr));
    }
}
