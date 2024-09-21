package array.medium;

import java.util.HashMap;
import java.util.Map;

public class MajorityElements {
    public static int majorityElements(int[] nums) {
        int n = nums.length;
        for (int j : nums) {
            int cnt = 0;
            for (int num : nums) {
                if (num == j) {
                    cnt++;
                }
            }
            if (cnt > (n / 2))
                return j;
        }
        return -1;
    }

    public static int majorityElementUsingMap(int []nums) {
        int n = nums.length;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int num : nums) {
            int value = mpp.getOrDefault(num, 0);
            mpp.put(num, value + 1);
        }
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() > (n / 2)) {
                return it.getKey();
            }
        }
        return -1;
    }

    // Moore’s Voting Algorithm
    public static int majorityElementUsingRecursion(int[] nums) {
        //size of the given array:
        int n = nums.length;
        int count = 0; // count
        int element = 0; // Element

        //applying the algorithm:
        for (int j : nums) {
            if (count == 0) {
                count = 1;
                element = j;
            } else if (element == j) count++;
            else count--;
        }
        //checking if the stored element is the majority element:
        int count1 = 0;
        for (int num : nums) {
            if (num == element) count1++;
        }
        if (count1 > (n / 2)) return element;
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{2, 1,3,1,3,1,3, 2, 2, 2, 2, 2, 2};
        System.out.println(majorityElements(nums));
        System.out.println(majorityElementUsingMap(nums));
        System.out.println(majorityElementUsingRecursion(nums));
    }
}
