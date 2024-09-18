package array.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class FindUnion {
    static ArrayList<Integer> findUnion(int[] arr1, int[] arr2, int n, int m) {
        int i = 0, j = 0;
        ArrayList<Integer > union=new ArrayList<>();
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]){
                if (union.isEmpty() || union.getLast() != arr1[i])
                    union.add(arr1[i]);
                i++;
            } else {
                if (union.isEmpty() || union.getLast() != arr2[j])
                    union.add(arr2[j]);
                j++;
            }
        }
        while (i < n) {
            if (union.getLast() != arr1[i])
                union.add(arr1[i]);
            i++;
        }
        while (j < m) {
            if (union.getLast() != arr2[j])
                union.add(arr2[j]);
            j++;
        }
        return union;
    }
    static ArrayList<Integer> findUnionUsingSet(int[] arr1, int[] arr2, int n, int m) {
        HashSet <Integer> s=new HashSet<>();
        for (int i = 0; i < n; i++)
            s.add(arr1[i]);
        for (int i = 0; i < m; i++)
            s.add(arr2[i]);
        return new ArrayList<>(s);
    }
    static ArrayList<Integer> findUnionUsingMap(int[] arr1, int[] arr2, int n, int m) {
        HashMap<Integer,Integer > freq=new HashMap<>();
        for (int i = 0; i < n; i++)
            freq.put(arr1[i],freq.getOrDefault(arr1[i],0)+1);
        for (int i = 0; i < m; i++)
            freq.put(arr2[i],freq.getOrDefault(arr2[i],0)+1);

        return new ArrayList<>(freq.keySet());
    }

    public static void main(String[] args) {
        int n = 10, m = 7;
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = {2, 3, 4, 4, 5, 11, 12};
        ArrayList<Integer> union = findUnion(arr1, arr2, n, m);
        ArrayList<Integer> unionUsingSet = findUnionUsingSet(arr1, arr2, n, m);
        ArrayList<Integer> unionUsingMap = findUnionUsingMap(arr1, arr2, n, m);
        System.out.println("Union of arr1 and arr2 is ");
        System.out.println(union);
        System.out.println(unionUsingSet);
        System.out.println(unionUsingMap);
    }
}
