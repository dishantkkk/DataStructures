package com.miscellaneous;

import java.util.ArrayList;

public class Sort0s1s2s {
    public static void sort012(ArrayList<Integer> arr) {
        // code here
        int low = 0, mid = 0, high = arr.size() - 1;
        while (mid <= high) {
            switch (arr.get(mid)) {
                case 0:
                    swap(arr, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr, mid, high);
                    high--;
                    break;
            }
        }
    }
    private static void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public static void sort210(ArrayList<Integer> arr) {
        // code here
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == 0) {
                count0++;
            } else if (arr.get(i) == 1) {
                count1++;
            } else {
                count2++;
            }
        }
        for (int i = 0; i < count0; i++) {
            arr.set(i, 0);
        }
        for (int i = count0; i < count0 + count1; i++) {
            arr.set(i, 1);
        }
        for (int i = count0 + count1; i < arr.size(); i++) {
            arr.set(i, 2);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(0);
        al.add(2);
        al.add(0);
        al.add(1);
        System.out.println(al);
//        sort012(al);
        sort210(al);
        System.out.println(al);
    }
}
