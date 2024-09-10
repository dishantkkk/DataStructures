package com.recursion;

public class Fibonacci {
    public static int fibRecursive(int n) {
        if(n==0) return 0;
        if(n==1 || n==2) return 1;
        return fibRecursive(n-1)+fibRecursive(n-2);
    }
    static int fibNaive(int n) {
        if (n == 0)
            return 0;
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }
    static int fibTwoVariables(int n) {
        if (n == 0)
            return 0;
        int secondLast = 0;
        int last = 1;
        int cur=1;
        for (int i = 2; i <= n; i++) {
            cur = last + secondLast;
            secondLast = last;
            last = cur;
        }
        return cur;
    }
    public static void main(String[] args) {
        System.out.println(fibRecursive(6));
        System.out.println(fibNaive(6));
        System.out.println(fibTwoVariables(6));
    }
}
