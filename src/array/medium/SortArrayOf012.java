package array.medium;

public class SortArrayOf012 {
    public static void sortArray012(int[] nums) { // Dutch National Flag Algorithm
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        for (int num : nums) {
            if (num == 0) cnt0++;
            else if (num == 1) cnt1++;
            else cnt2++;
        }
        //Replace the places in the original array:
        for (int i = 0; i < cnt0; i++) nums[i]=0; // replacing 0's
        for (int i = cnt0; i < cnt0 + cnt1; i++) nums[i]=1; // replacing 1's
        for (int i = cnt0 + cnt1; i < nums.length; i++) nums[i]=2; // replacing 2's
    }
    // Dutch National Flag Algorithm
    public static void sortColors012(int[] nums) { // Dutch National Flag Algorithm
        int low = 0, mid = 0, high = nums.length-1;
        while(mid<=high) {
            if(nums[mid] == 0) {
                int t=nums[low];
                nums[low]=nums[mid];
                nums[mid]=t;
                low++;
                mid++;
            } else if(nums[mid]==1){
                mid++;
            } else{
                int t=nums[mid];
                nums[mid]=nums[high];
                nums[high]=t;
                high--;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,0,1,1,2,0};
        sortArray012(arr);
        for (int i : arr) System.out.print(i + " ");
        sortColors012(arr);
        for (int i : arr) System.out.print(i + " ");
    }
}
