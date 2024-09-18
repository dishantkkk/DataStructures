package array.easy;

public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int s=0;
        for(int a : nums) {
            s+=a;
        }
        return n*(n+1)/2-s;
    }
    public static int missingNumberUsingXor(int []a, int N) {
        int xor1 = 0, xor2 = 0;
        for (int i = 0; i < N - 1; i++) {
            xor2 = xor2 ^ a[i]; // XOR of array elements
            xor1 = xor1 ^ (i + 1); //XOR up to [1...N-1]
        }
        xor1 = xor1 ^ N; //XOR up to [1...N]
        return (xor1 ^ xor2); // the missing number
    }
    public static void main(String[] args) {
        int[] arr = {0,1,2};
        System.out.println(missingNumber(arr));
        System.out.println(missingNumberUsingXor(arr, 3)); //It will work for array containing elements from 1 to N
    }
}
