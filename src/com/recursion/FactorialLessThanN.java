package com.recursion;

import java.util.ArrayList;

public class FactorialLessThanN {
    static ArrayList<Long> factorialNumbers(long n) {
        // code here
        ArrayList<Long> result = new ArrayList<>();
        generateFactorials(n, 1, 1, result);
        return result;
    }

    public static void generateFactorials(long n, long i, long fact, ArrayList<Long> result) {
        if (fact > n) {
            return;
        }
        result.add(fact);
        generateFactorials(n, i + 1, fact * (i + 1), result);
    }

    public static void main(String[] args) {
        System.out.println(factorialNumbers(10));
    }
}
