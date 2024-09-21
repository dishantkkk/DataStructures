package miscellaneous;
import java.util.HashMap;
import java.util.HashSet;

public class PicnicGroups {
    public static int maxGroups(int N, int[] compatibilityFactors) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        int groups = 0;

        for (int factor : compatibilityFactors) {
            frequency.put(factor, frequency.getOrDefault(factor, 0) + 1);
            if (frequency.get(factor) == 2) {
                groups++;
                frequency.put(factor, 0);
            }
        }
        return groups;
    }
    public static void maximumGroups(int N, int[] arr) {
        int count=0;
        HashSet<Integer> set=new HashSet<>();
        for (int x: arr) {
            if(set.contains(x)){
                count++;
                set.clear();
            }else{
                set.add(x);
            }
        }
        System.out.println(count);
    }


    public static void main(String[] args) {
        System.out.println(maxGroups(2, new int[]{1, 1})); // Output: 1
        System.out.println(maxGroups(8, new int[]{1, 2, 1, 1, 1, 1, 1, 1})); // Output: 3
        maximumGroups(8,new int[]{1,2,1,1,1,1,1,1,});
    }
}

