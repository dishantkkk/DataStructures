package array.easy;

import java.util.ArrayList;

public class MoveAllZerosToEnd {
    public static void moveZerosBruteForce(int[] arr) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int j : arr) {
            if (j != 0)
                temp.add(j);
        }
        int nz = temp.size();
        for (int i = 0; i < nz; i++) {
            arr[i] = temp.get(i);
        }
        for (int i = nz; i < arr.length; i++) {
            arr[i] = 0;
        }
    }
    public static void moveZerosOptimal(int[] nums) {
        int j=-1;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==0) {
                j=i;
                break;
            }
        }
        if(j==-1) {
            return;
        }
        for(int i=j+1;i<nums.length;i++) {
            if(nums[i]!=0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,0,0,40,2,5,0,0,9};
//        moveZerosBruteForce(arr);
        moveZerosOptimal(nums);
        for (int j : nums) {
            System.out.print(j + " ");
        }
    }
}
