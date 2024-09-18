package array.easy;

public class RotateArray {
    public static void leftRotate(int[] nums, int k) {
        int[] arr = new int[nums.length];
        System.arraycopy(nums, 0, arr, 0, nums.length);
        for(int i=0;i<k;i++) {
            int t = nums[0];
            for(int j=0;j<=nums.length-1;j++) {
//                int t = nums[0];
                if(j<nums.length-1) {
                    nums[j] = nums[j+1];
                } else {
                    nums[j] = t;
                }
            }
        }
    }

    public static void rightRotate(int[] nums, int k) {
        for(int i=0;i<k;i++) {
            int t = nums[nums.length-1];
            for(int j=nums.length-1;j>=0;j--) {
                if(j>0) {
                    nums[j] = nums[j-1];
                } else {
                    nums[j] = t;
                }
            }
        }
    }
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;  // In case k is greater than array length
        reverse(nums, 0, n - 1);  // Step 1: Reverse the entire array
        reverse(nums, 0, k - 1);  // Step 2: Reverse the first k elements
        reverse(nums, k, n - 1);  // Step 3: Reverse the remaining elements
    }

    // Helper method to reverse elements in the array
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public void rotateUsingExtraArray(int[] nums, int k) {
        int length = nums.length;

        int[] rotated = new int[length];

        for (int i = 0; i < length; i++) {
            rotated[(i + k) % length] = nums[i];
        }

        for (int i = 0; i < length; i++) {
            nums[i] = rotated[i];
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        rotate(arr, 3);
        for(int i:arr) {
            System.out.println(i);
        }
    }

}