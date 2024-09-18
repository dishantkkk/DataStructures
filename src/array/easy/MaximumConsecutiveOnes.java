package array.easy;

public class MaximumConsecutiveOnes {
    static int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int maxi = 0;
        for (int num : nums) {
            if (num == 1) {
                cnt++;
            } else {
                cnt = 0;
            }
            maxi = Math.max(maxi, cnt);
        }
        return maxi;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 0, 1, 1, 1 };
        System.out.println("The maximum  consecutive 1's are " + findMaxConsecutiveOnes(nums));
    }
}
