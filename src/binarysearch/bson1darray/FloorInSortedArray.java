package binarysearch.bson1darray;

public class FloorInSortedArray {
    public static int findFloor(long[] arr, int n, long x) {
        long max = Long.MIN_VALUE;
        int res=-1;
        for(int i=0;i<n;i++) {
            if(arr[i]<=x) {
                max = Math.max(max,arr[i]);
                res = i;
            }
        }
        return res;
    }

    public static int findFloorUsingBinarySearch(long[] arr, int n, long x) {
        int left = 0, right = arr.length-1;
        int res=-1;
        while(left<=right) {
            int mid = (left+right)/2;
            if(arr[mid]<=x) {
                res = mid;
                left=mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        long[] arr = {35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113};
        int n = arr.length;
        int x = 159;
        System.out.println(findFloor(arr,n,x));
        System.out.println(findFloorUsingBinarySearch(arr,n,x));
    }
}
