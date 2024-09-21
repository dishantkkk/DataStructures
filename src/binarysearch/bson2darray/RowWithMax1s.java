package binarysearch.bson2darray;

public class RowWithMax1s {
    public static int rowWithMax1s(int[][] arr, int n, int m) {
        int cnt_max = 0;
        int index = -1;
        // traverse the matrix:
        for (int i = 0; i < n; i++) {
            int cnt_ones = 0;
            for (int j = 0; j < m; j++) {
                cnt_ones += arr[i][j];
            }
            if (cnt_ones > cnt_max) {
                cnt_max = cnt_ones;
                index = i;
            }
        }
        return index;
    }

    public static int lowerBound(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] >= x) {
                ans = mid;
                // look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans; //returns left most index of 1 (first 1)
    }
    public static int rowWithMax1sUsingBinarySearch(int[][] matrix, int n, int m) {
        int cnt_max = 0;
        int index = -1;

        // traverse the rows:
        for (int i = 0; i < n; i++) {
            // get the number of 1's:
            int cnt_ones = m - lowerBound(matrix[i], m, 1); //formula to calculate count of 1 in column i
            // as individual arrays are sorted, so 1's count is subtraction of total length - first 1.
            if (cnt_ones > cnt_max) {
                cnt_max = cnt_ones;
                index = i;
            }
        }
        return index;
    }


    public static void main(String[] args) {
        int[][] arr = {{0,1,1,1}, {0,0,1,1}, {1,1,1,1},{0,0,0,0}};
        System.out.println("The row with the maximum number of 1's is: " +
                rowWithMax1s(arr, arr.length, arr[0].length));
        System.out.println(rowWithMax1sUsingBinarySearch(arr, arr.length, arr[0].length));
    }
}
