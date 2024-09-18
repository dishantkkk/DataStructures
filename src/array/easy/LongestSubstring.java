package array.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public static int lengthOfLongestSubArray(int[] A, int N, int K) {
        int len = 0;
        for (int i = 0; i < N; i++) { // starting index
            long s = 0; // Sum variable
            for (int j = i; j < N; j++) { // ending index
                // add the current element to the subarray a[i...j-1]:
                s += A[j];

                if (s == K)
                    len = Math.max(len, j - i + 1);
            }
        }
        return len;
    }
    public static int getLongestSubarrayLength(int[] A, int N, int K) {
        int len = 0;
        for (int i = 0; i < N; i++) { // starting index
            for (int j = i; j < N; j++) { // ending index
                // add all the elements of subarray = a[i...j]:
                long s = 0;
                for (int k = i; k <= j; k++) {
                    s += A[k];
                }

                if (s == K)
                    len = Math.max(len, j - i + 1);
            }
        }
        return len;
    }
    public static int getLongestSubarrayLengthUsingMap(int[] A, int N, int K) {
        Map<Integer, Integer> preSumMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            //calculate the prefix sum till index i:
            sum += A[i];
            // if the sum = k, update the maxLen:
            if (sum == K) {
                maxLen = Math.max(maxLen, i + 1);
            }
            // calculate the sum of remaining part i.e. x-k:
            long rem = sum - K;
            //Calculate the length and update maxLen:
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            //Finally, update the map checking the conditions:
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }
        return maxLen;
    }
    public static int getLongestSubarrayLengthUsingTwoPointers(int[] A, int N, int K) {
        int left = 0, right = 0; // 2 pointers
        long sum = A[0];
        int maxLen = 0;
        while (right < N) {
            // if sum > k, reduce the subarray from left until sum becomes less or equal to k:
            while (left <= right && sum > K) {
                sum -= A[left];
                left++;
            }
            // if sum = k, update the maxLen i.e. answer:
            if (sum == K) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            // Move forward thw right pointer:
            right++;
            if (right < N) sum += A[right];
        }
        return maxLen;
    }
    public static int lenOfLongSubArrayPositiveAndNegative(int A[], int N, int K) {
        Map<Integer, Integer> preSumMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            //calculate the prefix sum till index i:
            sum += A[i];

            // if the sum = k, update the maxLen:
            if (sum == K) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // calculate the sum of remaining part i.e. x-k:
            int rem = sum - K;

            //Calculate the length and update maxLen:
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            //Finally, update the map checking the conditions:
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println(lengthOfLongestSubArray(A, 9, 15));
        System.out.println(getLongestSubarrayLength(A, 9, 15));
        System.out.println(getLongestSubarrayLengthUsingMap(A, 9, 15));
        System.out.println(getLongestSubarrayLengthUsingTwoPointers(A, 9, 15));
        System.out.println(lenOfLongSubArrayPositiveAndNegative(A, 9, 15));
    }
}
