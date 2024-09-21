package binarysearch.bson1darray;

public class BinarySearch {
    public static int binarySearch(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            else if (target > nums[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static int binarySearch(int[] nums, int low, int high, int target) {
        if (low > high) return -1;

        int mid = (low + high) / 2;
        if (nums[mid] == target) return mid;
        else if (target > nums[mid])
            return binarySearch(nums, mid + 1, high, target);
        return binarySearch(nums, low, mid - 1, target);
    }


    public static void main(String[] args) {
        int[] a = {3, 4, 6, 7, 9, 12, 16, 17};
        int target = 6;
        int index = binarySearch(a, target);
        if (index == -1)
            System.out.println("The target is not present.");
        else
            System.out.println("The target is at index: " + index);
        System.out.println(binarySearch(a, 0, a.length, target));
    }
}

