package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FrequesncyOfMostFrequestElement {
    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int maxFreq = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int currentFreq = 1;
            int operationsUsed = 0;
            for (int j = i - 1; j >= 0; j--) {
                int diff = nums[i] - nums[j];
                operationsUsed += diff;
                if (operationsUsed <= k) {
                    currentFreq++;
                } else {
                    break;
                }
            }
            maxFreq = Math.max(maxFreq, currentFreq);
        }
        return maxFreq;
    }
    public static int maxFrequencyEl(int[] nums, int k) {
        Arrays.sort(nums);
        long total = 0;
        int left = 0;
        int result = 1;

        for (int right = 0; right < nums.length; right++) {
            total += nums[right];
            while ((long) nums[right] * (right - left + 1) > total + k) {
                total -= nums[left];
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,4,8,13};
        int k=5;
        System.out.println(maxFrequency(nums,k));
        System.out.println(maxFrequencyEl(nums,k));
    }
}
