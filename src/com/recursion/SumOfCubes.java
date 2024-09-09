package com.recursion;

public class SumOfCubes {
    static long sumOfCubes(long n) {
        // code here
        if (n == 0) {
            return 0;
        }
        return (n*n*n) + sumOfCubes(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(sumOfCubes(5));
    }
}
