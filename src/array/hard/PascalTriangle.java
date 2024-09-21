package array.hard;
import java.util.*;

// We have total 3 variations
// 1. Get or print the element of row r and column c
// 2. Get or print the whole row elements at row r
// 3. Get or print the whole Pascal triangle
public class PascalTriangle {
    // Formula to find the element at row r and column c : nCr = n! / (r! * (n-r)!)
    // We have an easier formula to find out the element i.e. (r-1)C(c-1).
    // Let’s try to analyze the formula to find the value of the combination assuming r-1 as n and c-1 as r:
    // nCr = n! / (r! * (n-r)!)
    // here its (r-1)C(c-1) = (r-1)! / ((c-1)! * ((r-1)-(c-1))!)
    // we can reach it to this formula in below method
    public static int nCr(int n, int r) {
        long res = 1;
        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return (int) res;
    }

    public static List<List<Integer>> pascalTriangle(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        // Store the entire Pascal's triangle:
        for (int row = 1; row <= n; row++) {
            List<Integer> tempLst = new ArrayList<>(); // temporary list
            for (int col = 1; col <= row; col++) {
                tempLst.add(nCr(row - 1, col - 1));
            }
            ans.add(tempLst);
        }
        return ans;
    }

    public static List<List<Integer>> generatePascalTriangleBasic(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) {
            return triangle;
        }
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);
        for (int row = 1; row < numRows; row++) {
            List<Integer> prevRow = triangle.get(row - 1);
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for (int j = 1; j < row; j++) {
                newRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            newRow.add(1);
            triangle.add(newRow);
        }
        return triangle;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(pascalTriangle(n));
        System.out.println(generatePascalTriangleBasic(n));
    }
}

