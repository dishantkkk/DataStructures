package array.medium;

public class MaxSumSubArray {
    public static int maxSubarraySum(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE; // maximum sum
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // subarray = nums[i.....j]
                int sum = 0;
                //add all the elements of subarray:
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    public static int maxSubarraySumBetter(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE; // maximum sum
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                // current subarray = arr[i.....j]
                // add the current element arr[j] to the sum i.e. sum of arr[i...j-1]
                sum += nums[j];
                maxSum = Math.max(maxSum, sum); // getting the maximum
            }
        }
        return maxSum;
    }

    //Kadane's Algorithm
    public static int maxSubarraySumOptimal(int[] nums) {
        int maxSum = Integer.MIN_VALUE; // maximum sum
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > maxSum) {
                maxSum = sum;
            }
            // If sum < 0: discard the sum calculated
            if (sum < 0) {
                sum = 0;
            }
        }
        // To consider the sum of the empty subarray uncomment the following check:
        //if (maxi < 0) maxi = 0;
        return maxSum;
    }

    public static int maxSubarraySumWithSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE; // maximum sum
        int sum = 0;
        int start = 0;
        int ansStart = -1, ansEnd = -1;
        for (int i = 0; i < n; i++) {
            if (sum == 0) start = i; // starting index
            sum += nums[i];
            if (sum > maxSum) {
                maxSum = sum;
                ansStart = start;
                ansEnd = i;
            }
            // If sum < 0: discard the sum calculated
            if (sum < 0) {
                sum = 0;
            }
        }
        //printing the subarray:
        System.out.print("The subarray is: [");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.print("]\n");
        // To consider the sum of the empty subarray uncomment the following check:
        //if (maxi < 0) maxi = 0;
        return maxSum;
    }


    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = maxSubarraySum(arr);
        System.out.println("The maximum subarray sum is: " + maxSum);
        System.out.println("The maximum subarray sum is: " + maxSubarraySumBetter(arr));
        System.out.println("The maximum subarray sum is: " + maxSubarraySumOptimal(arr));
        System.out.println("The maximum subarray sum is: " + maxSubarraySumWithSubArray(arr));
    }
}