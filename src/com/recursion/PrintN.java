package com.recursion;

public class PrintN {
    static void printNos(int N){
        //Your code here
        if (N < 1) {
            return;
        }
        printNos(N - 1);
        System.out.print(N + " ");
    }

    public static void main(String[] args) {
        printNos(5);
    }
}
