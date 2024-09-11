package hashing;

import java.util.HashMap;
import java.util.Map;

public class FrequenciesOfLimitedRangeArrayElements {
    public static void frequencyCount(int arr[], int N, int P) {
        // do modify in the given array
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++) {
            if(arr[i]<=N)
                map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for (int i = 0; i < N; i++) {
            int element = i + 1;
            arr[i] = map.getOrDefault(element, 0);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,2,3,5};
        frequencyCount(arr, arr.length, 5);
        for(int a : arr) {
            System.out.println(a);
        }

    }
}
