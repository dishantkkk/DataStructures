package strings.medium;

import java.util.*;

public class SortCharacterByFrequency {
    public static String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        // Step 1: Count the frequency of each character
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // Step 2: Create a list of characters sorted by frequency
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((a, b) -> b.getValue() - a.getValue());  // Sort by frequency in descending order
        // Step 3: Build the output string based on the sorted entries
        for (Map.Entry<Character, Integer> entry : entryList) {
            sb.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "Aabb";
        System.out.println(frequencySort(s));
    }
}
