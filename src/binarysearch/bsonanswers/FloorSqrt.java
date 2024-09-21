package binarysearch.bsonanswers;

public class FloorSqrt {
    public static int floorSqrt(int n) {
        int ans = 0;
        // linear search on the answer space
        for (long i = 1; i <= n; i++) {
            long val = i * i;
            if (val <= (long) n) {
                ans = (int) i;
            } else {
                break;
            }
        }
        return ans;
    }
    public static int floorSqrtUsingBuiltInMethod(int n) {
        return (int) Math.sqrt(n);
    }
    public static int floorSqrtUsingBinarySearch(int n) {
        int low = 1, high = n;
        while (low <= high) {
            long mid = (low + high) / 2;
            long val = mid * mid;
            if (val <= (long)(n)) {
                //eliminate the left half:
                low = (int)(mid + 1);
            } else {
                //eliminate the right half:
                high = (int)(mid - 1);
            }
        }
        return high;
    }



    public static void main(String[] args) {
        int n = 28;
        int ans = floorSqrt(n);
        System.out.println("The floor of square root of " + n + " is: " + ans);
        System.out.println(floorSqrtUsingBuiltInMethod(n));
        System.out.println(floorSqrtUsingBinarySearch(n));
    }
}


