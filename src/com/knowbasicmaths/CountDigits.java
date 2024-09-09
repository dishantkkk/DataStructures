package com.knowbasicmaths;

public class CountDigits {
    static int evenlyDivides(int N){
        // code here
        int count = 0;
        for (char c : String.valueOf(N).toCharArray()) {
            int digit = Character.getNumericValue(c);
            if (digit != 0 && N % digit == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int N = 2336;
        System.out.println(evenlyDivides(N));
    }
}
