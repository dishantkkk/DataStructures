package array.easy;

import java.util.HashMap;
import java.util.Map;

public class FindSingleNumber {
    public static int singleNumber(int[] nums) {
        int n = nums.length;
        int xorr = 0;
        for (int i = 0; i < n; i++) {
            xorr = xorr ^ nums[i];
        }
        return xorr;
    }
    public static int getSingleElementBruteForce(int []arr) {
        int n = arr.length;
        for (int num : arr) {
            int cnt = 0;
            for (int i : arr) {
                if (i == num)
                    cnt++;
            }
            if (cnt == 1) return num;
        }
        return -1;
    }
    public static int getSingleElementUsingMap(int []arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j : arr) {
            int value = map.getOrDefault(j, 0);
            map.put(j, value + 1);
        }

        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            if (it.getValue() == 1) {
                return it.getKey();
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {2,2,1};
        System.out.println(singleNumber(arr));
        System.out.println(getSingleElementBruteForce(arr));
        System.out.println(getSingleElementUsingMap(arr));
    }
}
