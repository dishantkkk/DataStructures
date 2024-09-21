package array.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
    public static int[] twoSumUsingMap(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int moreNeeded = target - num;
            if (map.containsKey(moreNeeded)) {
                return new int[]{i,map.get(moreNeeded)};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
    public static int[] twoSumUsingTwoPointers(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{map.get(nums[left]),map.get(nums[right])};
            }
            if (sum < target) {
                left++;
            }
            if (sum > target) {
                right--;
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int[] arr = {3,3};
        int target = 6;

        Arrays.stream(twoSum(arr, target)).forEach(System.out::println);
        Arrays.stream(twoSumUsingMap(arr, target)).forEach(System.out::println);
        Arrays.stream(twoSumUsingTwoPointers(arr, target)).forEach(System.out::println);
        Arrays.stream(twoSumUsingTwoPointers(arr, target)).forEach(System.out::println);
        // Last won't work because the map can contain only unique keys
    }
}
