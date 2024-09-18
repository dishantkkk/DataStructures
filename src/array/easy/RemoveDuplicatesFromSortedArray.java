package array.easy;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int a : nums) {
            set.add(a);
        }
        System.out.println(set);
        return set.size();
    }
    public static int removeDuplicatesAndUpdateInPlace(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
        // O(n)
    }
    public static void main(String[] args) {
        int[] arr = {1,1,2,4,4,6,9};
        System.out.println(removeDuplicates(arr));
        System.out.println(removeDuplicatesAndUpdateInPlace(arr));
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
